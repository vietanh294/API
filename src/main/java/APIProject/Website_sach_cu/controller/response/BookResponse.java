package APIProject.Website_sach_cu.controller.response;

import APIProject.Website_sach_cu.model.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BookResponse {
    private Integer code;
    private String message;
    private List<BookEntity> data;
}
