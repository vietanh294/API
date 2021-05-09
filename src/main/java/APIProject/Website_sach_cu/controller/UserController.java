package APIProject.Website_sach_cu.controller;

import APIProject.Website_sach_cu.controller.request.LoginRequest;
import APIProject.Website_sach_cu.controller.request.RegisterRequest;
import APIProject.Website_sach_cu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest registerRequest) throws SQLException {
        String result = userService.register(registerRequest);
        return result;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest loginRequest) throws  SQLException {
        String result =userService.login(loginRequest);
        return result;
    }

}
