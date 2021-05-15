package APIProject.Website_sach_cu.service;

import APIProject.Website_sach_cu.controller.request.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class LoginService {

    @Autowired
    Connection connection;

    public String messageServiceLogin = null;

    public String loginForm(PersonForm personForm) throws SQLException {
//         Check phone
        if ( personForm.getUserPhone() == null || personForm.getUserPhone() == "" ){
            return "Tài khoản không hợp lệ!" ;
        }
//        //Check email
//        if (StringUtils.isEmpty(personForm.getUserEmail()) || !personForm.getUserEmail().contains("@gmail.com")){
//            messageService ="Email không chính xác";
//            return "";
//        }
//        // Check pass
//
//        if (StringUtils.isEmpty(personForm.getUserPassword()) || personForm.getUserPassword().length() <8){
//            messageService ="Mật khẩu không hợp lệ";
//            return "";
//        }
//        if (!personForm.getUserPassword().equals(personForm.getConfirmUserPass())){
//            messageService ="Xác nhận thất bại! Mật khẩu không trùng khớp";
//            return "";
//        }

        //Check Login Page

        String sql = "SELECT user_password FROM user WHERE user_phone = '"
                + personForm.getUserPhone()+"' or user_email='"+personForm.getUserPhone()+"';";
        Statement statement = connection.createStatement();
        ResultSet resultSetLogin = statement.executeQuery(sql);
        while (resultSetLogin.next()){
            if (personForm.getUserPassword().equals(resultSetLogin.getString("user_password")) == true){
                return "Login success";
            } else return "Password không chính xác";
        } return "Login failure";
    }
}