package APIProject.Website_sach_cu.service;

import APIProject.Website_sach_cu.controller.response.BookResponse;
import APIProject.Website_sach_cu.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    Connection connection;



    public BookResponse getBookByCategoryID(Integer cateID, String ascdesc, String orderBy) {
        BookResponse bookResponse =new BookResponse();
        if ( !ascdesc.equals("ASC") && !ascdesc.equals("DESC")){
            bookResponse.setCode(-1);
            bookResponse.setMessage("Order value is not valid");
            return bookResponse;
        }

        List<BookEntity> bookData =null;
        String sql = "SELECT * FROM book WHERE category_id = "+cateID +" ORDER BY "+orderBy+" "+ascdesc+";";
        try {
            Statement statement =connection.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                if (bookData == null){
                    bookData =new ArrayList<>();
                }
                String title =resultSet.getString("book_name");
                String author =resultSet.getString("book_author");
                String year =resultSet.getString("book_year");
                BookEntity item = new BookEntity(title,author,year);
                bookData.add(item);
            }
            bookResponse.setData(bookData);
            bookResponse.setCode(200);
            bookResponse.setMessage("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bookResponse;
    }
}
