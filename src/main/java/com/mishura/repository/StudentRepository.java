package com.mishura.repository;

public class StudentRepository implements SearchableRepository, GeneralRepository{

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
        getSql("SELECT * FROM student WHERE " + field + " LIKE '" + fieldName + "'");
    }

    public void getGroupSizes() {
        getSql("SELECT group_id, count(*) FROM student GROUP BY group_id");
    }

    public void getStudentsGrades() { // не требуется, но для проверки очень нужен )
        getSql("SELECT id, first_name, last_name, group_id, mark, subject_name " +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS);
    }

    public void getStudentsByGrade(double grade){
        getSql("SELECT id, first_name, last_name,  AVG(mark)" +
                "FROM " +STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY id " +
                "HAVING AVG(mark) > " + String.valueOf(grade)) ;
    }

    public void getAverageGradeInGroup(){
        getSql("SELECT group_id, AVG(mark) " +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY group_id") ;
    }
}
