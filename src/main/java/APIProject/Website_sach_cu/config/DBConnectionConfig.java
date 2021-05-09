package APIProject.Website_sach_cu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DBConnectionConfig {

    @Value("${database.user}")
    String user;
    @Value("${database.pass}")
    String pass;
    @Value("${database.url}")
    String url;

    @Bean
    Connection getDBConnection(){
        Connection conne = null;
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            if (conne == null){
                conne = (Connection) DriverManager.getConnection(url,user,pass);
            } else return conne;
        } catch (Exception e){
            e.printStackTrace();
        }
        return conne;
    }
    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}

