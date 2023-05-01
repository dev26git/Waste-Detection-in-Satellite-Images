package Client;

import Service.CurrentUserService;
import models.Author;
import models.Project;
import repos.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws SQLException {

        Connection conn = DBUtil.getConnection();

//        AuthorRepo authorRepo = new AuthorRepo(conn);
//        System.out.println(authorRepo.insertAuthor("Dev", "jugni@gmail.com"));
//
//        MentorRepo mentorRepo = new MentorRepo(conn);
//        System.out.println(mentorRepo.insertMentor("Shruti Patil", "HoD@sitpune"));



        Author currUser = new Author(18, "Dev", "jugni@gmail.com");

        CurrentUserService currUserService = new CurrentUserService(conn, currUser);
//        currUserService.insertProject("SampleProject", "I hope this project gets accepted.", 1);
//        currUserService.insertProject("SampleProject2", "I hope this project does not get accepted.", 1);
//
//        ProjectRepo projectRepo = new ProjectRepo(conn);
//        for(Project p: projectRepo.getAllProjects()) {
//            System.out.println(p.toString());
//        }

        currUserService.deleteProject(3);




    }

}
