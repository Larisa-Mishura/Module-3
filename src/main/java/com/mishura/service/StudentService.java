package com.mishura.service;

import com.mishura.model.Group;
import com.mishura.model.Person;
import com.mishura.model.Student;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.SearchableRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.util.UserInput;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Random;

@Getter
public class StudentService implements SearchService{

    private final GeneralRepository<Student> repository;

    private static final Random RANDOM = new Random();

    private static StudentService instance;

    public StudentService(GeneralRepository<Student> repository) {
        this.repository = repository;
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService(StudentRepository.getInstance());
        }
        return instance;
    }

    public static StudentService getInstance(GeneralRepository<Student> repository) {
        if (instance == null) {
            instance = new StudentService(repository);
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        SearchableRepository searchableRepository = (SearchableRepository) getInstance().repository;
        searchableRepository.getByFieldName(field, fieldName);
    }

    public void save(Student student) {
        repository.save(student);
    }

    public Student createAndSave() {
        final Student student = create();
        repository.save(student);
        return student;
    }

    public Student create() {
        final Student student = new Student();
        student.setFirstName("StudentName" + RANDOM.nextInt(100));
        student.setLastName("LastName" + RANDOM.nextInt(100));
        return student;
    }

    public Student createByConsole() {
        final String[] menuForTable = {"Current date and time", "Enter date and time"};
        final int userChoice = UserInput.menu(menuForTable, "Make your choice");
        LocalDateTime dateOfEntrance = null;
        if(userChoice == 0){
            dateOfEntrance = LocalTime.now().atDate(LocalDate.now());
        }
        if(userChoice == 1) {
            dateOfEntrance = LocalDateTime.of(
                    UserInput.getInt("Enter year"),
                    UserInput.getInt("Enter month"),
                    UserInput.getInt("Enter day of month"),
                    UserInput.getInt("Enter hour"),
                    UserInput.getInt("Enter minute")
            );
        }

        System.out.println("Date of entrance - " + dateOfEntrance);

       final Student.Builder builder = new Student.Builder();
            Student student = (Student) builder
                    .withFirstName(UserInput.getString("Enter first name"))
                    .withLastName(UserInput.getString("Enter last name"))
                    .withAge(UserInput.getInt("Enter age"))
                    .withDateOfEntrance(dateOfEntrance)
                    .withGroup(new Group(UserInput.getString("Enter group")))
            .build();
        return student;
    }

    public void getGroupSizes() {
        StudentRepository.getInstance().getGroupSizes();
    }

    public void getBestSubject() {
        StudentRepository.getInstance().getBestSubject();
    }

}
