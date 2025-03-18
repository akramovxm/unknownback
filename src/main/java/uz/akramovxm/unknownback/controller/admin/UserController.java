package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.UserRequest;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminUserDTO;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.mapper.UserMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.UserService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PreAuthorize("hasAuthority('GET_USER')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt_sort") String sortBy,
            @RequestParam(value = "sortType", defaultValue = "DESC") String sortType,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        SearchResult<User> result = userService.getAll(search, page, size, sortBy, sortType);

        List<AdminUserDTO> users = result.hits().stream().map(userMapper::toAdminUserDTO).toList();

        return new Response(HttpStatus.OK.name(), users, result.total().hitCount(), page, size);
    }

    @Validated(OnCreate.class)
    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody UserRequest request) {
        User user = userService.create(request);

        return new Response(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @Validated(OnUpdate.class)
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response update(@Valid @RequestBody UserRequest request, @PathVariable Long id) {
        User user = userService.update(request, id);

        return new Response(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@Valid @RequestBody IDRequest request) {
        userService.delete(request);

        return new Response(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/lock")
    @ResponseStatus(HttpStatus.OK)
    public Response lock(@Valid @RequestBody IDRequest request) {
        userService.lock(request);

        return new Response(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/unlock")
    @ResponseStatus(HttpStatus.OK)
    public Response unlock(@Valid @RequestBody IDRequest request) {
        userService.unlock(request);

        return new Response(HttpStatus.OK.name());
    }
}
