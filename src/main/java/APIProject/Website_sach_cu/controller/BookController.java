package APIProject.Website_sach_cu.controller;

import APIProject.Website_sach_cu.controller.response.BookResponse;
import APIProject.Website_sach_cu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{category_id}")
    public BookResponse getBookByCategoryID(@PathVariable(name = "category_id") Integer cateID,
                                            @RequestParam(name = "ascdesc" , defaultValue = "ASC") String ascdesc,
                                            @RequestParam(name = "orderBy" ,defaultValue = "book_name") String orderBy ){

        return  bookService.getBookByCategoryID(cateID,ascdesc,orderBy);
    }

}
