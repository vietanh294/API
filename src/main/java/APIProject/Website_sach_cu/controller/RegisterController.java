package APIProject.Website_sach_cu.controller;

import APIProject.Website_sach_cu.controller.request.PersonForm;
import APIProject.Website_sach_cu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class RegisterController {

   @Autowired
   RegisterService registerService;

   @GetMapping(value = "/register")
   public String registerPage(Model model1){
       PersonForm personForm = new PersonForm();
       model1.addAttribute("personForm" ,personForm);
//         registerService.registerForm(request);
//       model1.addAttribute("messageRegister",registerService.messageService);
       return "register";
   }

    @PostMapping(value = "/register")
    public String registerPage(Model model,
                               @ModelAttribute ("personForm")PersonForm request) throws SQLException {
//        String phone = request.getUserPhone();
//        String password =request.getUserPassword();
//        String confirmPass =request.getConfirmUserPass();
//        String email = request.getUserEmail();

        String runRequest =    registerService.registerForm(request);
        model.addAttribute("messageRegister",registerService.messageService);
        if (runRequest == "login"){
            return "login";
        }

        return "register";
    }
}
