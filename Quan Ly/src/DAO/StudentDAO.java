package DAO;

import Entity.Students;

import java.util.Map;

public interface StudentDAO {
    Map<String, Students> getAllStudents();

    void addStudent();

    void editStudent();

    void delete();

    void show();

    void sort();

    void addMark();

    void editMark();

}
