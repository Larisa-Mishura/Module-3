package com.mishura.repository;

public class SubjectRepository implements GeneralRepository {

    private static SubjectRepository instance;

    public SubjectRepository() {
    }

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }

    public void getBestGradesSubject(){
        getSql("SELECT subject_name, AVG(mark)" +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY subject_name");
    }

    public void getWorstGradesSubject(){
        getSql("SELECT subject_name, AVG(mark)" +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY subject_name");
    }

}
