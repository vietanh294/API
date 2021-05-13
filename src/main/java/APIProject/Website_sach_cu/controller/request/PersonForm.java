package APIProject.Website_sach_cu.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonForm {
    private String userPhone;
    private String userPassword;
    private String confirmUserPass;
    private String userEmail;
}
