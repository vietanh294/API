package APIProject.Website_sach_cu.service;

import APIProject.Website_sach_cu.controller.request.LoginRequest;
import APIProject.Website_sach_cu.controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserService {
    @Autowired
    Connection connection;

    public String register(RegisterRequest registerRequest) throws SQLException {
        // Check phone
        if ( registerRequest.getPhone() == null || registerRequest.getPhone() == "" || registerRequest.getPhone().length() != 10){
            return "So dien thoai khong chinh xac";
        }
        //Check email
        if (StringUtils.isEmpty(registerRequest.getEmail()) || !registerRequest.getEmail().contains("@gmail.com")){
            return "Email khong chinh xac";
        }
        // Check pass
        if (StringUtils.isEmpty(registerRequest.getPass()) || registerRequest.getEmail().length() <8){
            return "Mat khau chua dap ung";
        }
        //Kiem tra SDT va Email da ton tai hay chua
        String sql = "SELECT * FROM user WHERE user_phone = '"
                +registerRequest.getPhone() +"' OR user_email = '"+registerRequest.getEmail()+"'; ";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery(sql);
            while (rs.next()){
                return "So dien thoai hoac email ton tai";
            }
            // insert new user
            sql ="insert into user(`user_phone` , `user_email` ,`user_password`) VALUE ( '" +
                    registerRequest.getPhone()+"','"+ registerRequest.getEmail()+"','"+registerRequest.getPass()+"');" ;
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Register fail:internal error";
        }
        return  "Success";
    }


    public String login(LoginRequest loginRequest) throws  SQLException{
        //check Phone
        //check password
        //check login
        String sql = "SELECT user_password FROM user WHERE user_phone = '"
                + loginRequest.getUserName()+"';";
        Statement statement = connection.createStatement();
        ResultSet resultSetLogin = statement.executeQuery(sql);
        while (resultSetLogin.next()){
            if (loginRequest.getPassword().equals(resultSetLogin.getString("user_password")) == true){
                return "Login success";
            } else return "Password khong chinh xac";
        } return "Login failure";
    }

}
