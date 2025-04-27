package uz.akramovxm.unknownback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.mapper.TestSessionMapper;
import uz.akramovxm.unknownback.service.TestSessionService;

@RestController
@RequestMapping("/test-sessions")
public class TestSessionController {
    @Autowired
    private TestSessionService testSessionService;
    @Autowired
    private TestSessionMapper testSessionMapper;
}
