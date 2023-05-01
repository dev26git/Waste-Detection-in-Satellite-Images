package repos;

import models.Author;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws InterruptedException, SQLException {

        Connection conn = DBUtil.getConnection();

        AuthorRepo authorRepo  = new AuthorRepo(conn);
        System.out.println(authorRepo.insertAuthor("Devansh", "dsg@gmail.com"));
        System.out.println(authorRepo.insertAuthor("Ketan", "KK@gmail.com"));

        for(Author a:authorRepo.getAllAuthors()) {
            System.out.println(a.toString());
        }
    }

}
