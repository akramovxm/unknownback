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
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminUserDTO;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.mapper.UserMapper;
import uz.akramovxm.unknownback.service.UserService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PreAuthorize("hasAuthority('GET_USER')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<AdminUserDTO> getUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt_sort") String sortBy,
            @RequestParam(value = "sortType", defaultValue = "DESC") String sortType,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        SearchResult<User> result = userService.getAll(search, page, size, sortBy, sortType);

        List<AdminUserDTO> users = result.hits().stream().map(userMapper::toAdminUserDTO).toList();

        return new ListResponse<>(HttpStatus.OK.name(), users, result.total().hitCount(), page, size);
    }

    @PreAuthorize("hasAuthority('GET_USER')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> getAll(@PathVariable Long id) {
        User user = userService.getById(id);

        return new Response<>(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<AdminUserDTO> create(@RequestBody UserRequest request) {
        User user = userService.create(request);

        return new Response<>(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> updateFully(@RequestBody UserRequest request, @PathVariable Long id) {
        User user = userService.updateFully(request, id);

        return new Response<>(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> updatePartially(@RequestBody UserRequest request, @PathVariable Long id) {
        User user = userService.updatePartially(request, id);

        return new Response<>(HttpStatus.OK.name(), userMapper.toAdminUserDTO(user));
    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> deleteById(@PathVariable Long id) {
        userService.deleteById(id);

        return new Response<>(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> deleteByIds(@Valid @RequestBody IDRequest request) {
        userService.delete(request);

        return new Response<>(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/lock")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> lockByIds(@Valid @RequestBody IDRequest request) {
        userService.lock(request);

        return new Response<>(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/unlock")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminUserDTO> unlockByIds(@Valid @RequestBody IDRequest request) {
        userService.unlock(request);

        return new Response<>(HttpStatus.OK.name());
    }
}
