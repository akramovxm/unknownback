package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import uz.akramovxm.unknownback.dto.request.MeRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.factory.UserDTOFactory;
import uz.akramovxm.unknownback.service.MeService;

@RestController
@RequestMapping("/me")
public class MeController {
    @Autowired
    private MeService meService;
    @Autowired
    private UserDTOFactory userDTOFactory;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> getMe() {
        User user = meService.getCurrentUser();

        return new Response<>(HttpStatus.OK.name(), userDTOFactory.create(user));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> updateMe(@Valid @RequestBody MeRequest request) {
        User user = meService.update(request);

        return new Response<>(HttpStatus.OK.name(), userDTOFactory.create(user));
    }

    @PutMapping("/update-password")
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> updatePassword(@Valid @RequestBody UpdatePasswordRequest request) {
        meService.updatePassword(request);

        return new Response<>(HttpStatus.OK.name());
    }
}
