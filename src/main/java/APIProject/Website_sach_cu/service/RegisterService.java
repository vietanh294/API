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
public class RegisterService {

    @Autowired
    Connection connection;

    public String messageService = null;

    public String registerForm(PersonForm personForm) throws SQLException {
        // Check phone
        if ( personForm.getUserPhone() == null || personForm.getUserPhone() == "" || personForm.getUserPhone().length() != 10){
            messageService = "Số điện thoại không hợp lệ!";
            return "" ;
        }
        //Check email
        if (StringUtils.isEmpty(personForm.getUserEmail()) || !personForm.getUserEmail().contains("@gmail.com")){
            messageService ="Email không chính xác";
            return "";
        }
        // Check pass

        if (StringUtils.isEmpty(personForm.getUserPassword()) || personForm.getUserPassword().length() <8){
            messageService ="Mật khẩu không hợp lệ";
            return "";
        }
        if (!personForm.getUserPassword().equals(personForm.getConfirmUserPass())){
            messageService ="Xác nhận thất bại! Mật khẩu không trùng khớp";
            return "";
        }

        //Kiem tra SDT va Email da ton tai hay chua

        String sql = "SELECT * FROM user WHERE user_phone = '"
                +personForm.getUserPhone() +"' OR user_email = '"+personForm.getUserEmail()+"'; ";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(sql);
            while (rs.next()){
                messageService = "SDT hoặc Email đã tồn tại!";
                return "";
            }
            // insert new user
            sql ="insert into user(`user_phone` , `user_email` ,`user_password`) VALUE ( '" +
                    personForm.getUserPhone()+"','"+ personForm.getUserEmail()+"','"+personForm.getUserPassword()+"');" ;
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "";
        }
        
        return "login" ;
    }
}