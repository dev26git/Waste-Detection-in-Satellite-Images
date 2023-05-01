package Service;

import models.Project;
import repos.MentorRepo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AllUsersService {

    public static Connection connection;

    public AllUsersService(Connection conn) {
        connection = conn;
    }



    public List<Project> searchKeyword(String keyword) {
        List<Project> projectList = new ArrayList<>();

        // SEARCH CODE HERE

        return projectList;
    }



    public boolean insertMentor(String mentorName, String mentorEmail) {
        MentorRepo mentorRepo = new MentorRepo(connection);
        return mentorRepo.insertMentor(mentorName, mentorEmail);
    }
}
