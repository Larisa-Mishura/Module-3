package com.mishura.repository;

import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.service.StudentService;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements SearchableRepository, GeneralRepository<Student>{

    private static String QUERY_SELECT = "SELECT * FROM student";

    private static StudentRepository instance;

    public StudentRepository() {
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        getSql("SELECT * FROM student WHERE " + field + " LIKE '" + fieldName + "'", Student.class);
    }

    public void getGroupSizes() {
        getSql("SELECT group_id, count(*) FROM student GROUP BY group_id");
    }

    public void getStudentsGrades() {
        getSql("SELECT id, first_name, last_name, group_id, mark, subject_name FROM ( (student s LEFT JOIN student_grade g ON s.id = g.student_id) LEFT JOIN grade m ON g.grade_id = m.gradeId)") ;
    }

    public void getBestSubject() {
        getSql("SELECT id, first_name, last_name, group_id, mark, subject_name FROM ( (student s LEFT JOIN student_grade g ON s.id = g.student_id) LEFT JOIN grade m ON g.grade_id = m.gradeId)") ;
    }

    public void getAverageGradeInGroup(){
        getSql("SELECT group_id, AVG(mark) " +
                "FROM ( (student s LEFT JOIN student_grade g ON s.id = g.student_id) LEFT JOIN grade m ON g.grade_id = m.gradeId) GROUP BY group_id") ;
    }

    public void getBestGradesSubject(){
        getSql("SELECT subject_name, AVG(mark) " +
                "FROM ( (student s LEFT JOIN student_grade g ON s.id = g.student_id) " +
                "LEFT JOIN grade m ON g.grade_id = m.gradeId) " +
                "GROUP BY subject_name") ;
    }

    public void getStudentsByGrade(double grade){
        getSql("SELECT id, first_name, last_name,  AVG(mark)" +
                "FROM ( (student s LEFT JOIN student_grade g ON s.id = g.student_id) " +
                "LEFT JOIN grade m ON g.grade_id = m.gradeId) " +
                "GROUP BY id " +
                "HAVING AVG(mark) > " + String.valueOf(grade)) ;
    }

}
