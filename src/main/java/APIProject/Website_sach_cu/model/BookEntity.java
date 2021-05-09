package APIProject.Website_sach_cu.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookEntity {
    private String title;
    private String author;
    private String year;

    public BookEntity(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
