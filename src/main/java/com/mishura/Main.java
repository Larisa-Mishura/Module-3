package com.mishura;

import com.mishura.action.Actions;
import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.TeacherRepository;
import com.mishura.service.GroupService;
import com.mishura.service.SearchService;
import com.mishura.service.StudentService;
import com.mishura.util.HibernateUtil;
import com.mishura.util.UserInput;
import org.apache.log4j.PropertyConfigurator;
import org.flywaydb.core.Flyway;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/University", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.clean();

        final EntityManager entityManager = HibernateUtil.getEntityManager();

        flyway.migrate();

        PropertyConfigurator.configure("src/main/resources/log4j.properties");


        /*final Actions[] values = Actions.values();
        final String[] names = Actions.mapActionsToNames(values);

        while (true) {
            final int userChoice = UserInput.menu(names, "Write what you want to do");
            values[userChoice].execute();
        }*/

        StudentService studentService = StudentService.getInstance(StudentRepository.getInstance());
        GroupService groupService = GroupService.getInstance();

        Group group1 = groupService.create(10);
        Group group2 = groupService.create(15);
        Group group3 = groupService.create(12);

        studentService.getGroupSizes();

        studentService.getBestSubject();


        /*final Student.Builder builder = new Student.Builder();
        Student student = (Student) builder
                .withFirstName("Xxxx")
                .withLastName("Test")
                .withAge(18)
                .withDateOfEntrance(LocalTime.now().atDate(LocalDate.now()))
                .withGroup(group)
                .build();*/

        /*Set<Student> set = new HashSet<>();
        set.add(student);
        group.setStudents(set);

        studentService.save(student);*/

    }
}
