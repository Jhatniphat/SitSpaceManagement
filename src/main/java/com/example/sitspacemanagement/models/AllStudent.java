package com.example.sitspacemanagement.models;
import java.util.Map;
import java.util.HashMap;
public class AllStudent {
    private Map<Integer , Student> allStudentMap = new HashMap<>();
    //allStudentMap เอาไว้เก็บ Student
    public void addStudent(int id , String name , double score){
        allStudentMap.put(id , new Student(id , name , score , calculateGrade(score) ));
        //map.put เอา (key , value) ไปใส่ใน map
    }

    private String calculateGrade(double score){
        if(score < 0 || score > 100) return "Error";
        if(score >= 80) return "A";
        else if(score >= 70) return "B";
        else if(score >= 60) return "C";
        else if(score >= 50) return "D";
        else return "F";
    }

    public void removeStudent(int id){
        allStudentMap.remove(id);
    }

    public Map<Integer, Student> findAll() {
        return allStudentMap;
    }

    public Boolean findId(int id){
        if (allStudentMap.get(id) == null ) return false;
        return true;
    }

}
