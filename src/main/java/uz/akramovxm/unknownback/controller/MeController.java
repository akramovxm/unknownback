package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.UserRequest;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.mapper.UserMapper;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.UserService;

@Validated
@RestController
@RequestMapping("/me")
public class MeController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response getMe(Authentication authentication) {
        User user = userService.getByEmail(authentication.getName());

        return new Response(HttpStatus.OK.name(), userMapper.toUserDTO(user));
    }

    @Validated(OnUpdate.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response updateMe(@Valid @RequestBody UserRequest request, Authentication authentication) {
        User user = userService.update(request, authentication);

        return new Response(HttpStatus.OK.name(), userMapper.toUserDTO(user));
    }
}
