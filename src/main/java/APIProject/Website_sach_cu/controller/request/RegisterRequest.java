package APIProject.Website_sach_cu.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {
    private  String phone;
    private String email;
    private String pass;
}
