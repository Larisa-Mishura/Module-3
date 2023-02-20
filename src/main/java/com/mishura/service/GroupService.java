package com.mishura.service;

import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.GroupRepository;
import com.mishura.repository.SearchableRepository;
import com.mishura.repository.TeacherRepository;
import lombok.Getter;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
public class GroupService implements SearchService{

    private static final Random RANDOM = new Random();

    private final GeneralRepository<Group> repository;

    private final StudentService studentService;

    private static GroupService instance;

    public GroupService(GeneralRepository<Group> repository, StudentService studentService) {
        this.repository = repository;
        this.studentService = studentService;
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService(GroupRepository.getInstance(), StudentService.getInstance());
        }
        return instance;
    }

    public static GroupService getInstance(GeneralRepository<Group> repository, StudentService studentService) {
        if (instance == null) {
            instance = new GroupService(repository, studentService);
        }
        return instance;
    }

    public Group create(int countOfStudents){
        final Group group = new Group();
        group.setName("Group-" + RANDOM.nextInt(1000));
        final Set<Student> students = createAndLinkStudents(group, countOfStudents);
        repository.save(group);
        return group;
    }
    public Group create(){
        final Group group = new Group();
        group.setName("Group-" + RANDOM.nextInt(1000));
        final Set<Student> students = createAndLinkStudents(group, RANDOM.nextInt(20));
        repository.save(group);
        return group;
    }

    private Set<Student> createAndLinkStudents(final Group group, int countOfStudents) {
        final Set<Student> students = new HashSet<>();
        for (int i = 0; i < countOfStudents; i++) {
            final Student student = studentService.create();
            student.setGroup(group);
            students.add(student);
        }
        group.setStudents(students);
        return students;
    }

    public void getByFieldName(String field, String fieldName) {
        SearchableRepository searchableRepository = (SearchableRepository) getInstance().repository;
        searchableRepository.getByFieldName(field, fieldName);
    }


}
