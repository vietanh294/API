package APIProject.Website_sach_cu.controller;

import APIProject.Website_sach_cu.controller.request.PersonForm;
import APIProject.Website_sach_cu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/login")
    public String loginPage(Model modelLogin ,
                            @ModelAttribute("personForm") PersonForm requestLogin) throws SQLException{
        String runLoginRequest = loginService.loginForm(requestLogin);
        modelLogin.addAttribute("messageLogin" , runLoginRequest);
        return "login";
    }
}
