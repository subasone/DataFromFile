/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datafrmfile.StudentDAO.Impl;

import com.leapfrog.datafrmfile.StudentDAO.StudentDao;
import com.leapfrog.datafrmfile.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author onesoft
 */
public class StudentDaoImpl implements StudentDao {
    
    ArrayList<Student> studentList = new ArrayList<>();
    @Override
    public boolean add(Student std) {
        studentList.add(std);
        return true;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Student> showAll() {
        
        return studentList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkEmail(Student std) {
        
        int checkEmail = 0;
        for(Student st : studentList){
            if(st.getEmail().equals(std.getEmail())){
                checkEmail = 1;
            }
        }
        if(checkEmail == 1){
            return true;
        } else {
            return false;
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkID(Student std) {
        
        int checkId = 0;
        for(Student st : studentList){
            if(st.getId()== std.getId()){
                checkId = 1;
            }
        }
        if(checkId == 1){
            return true;
        } else {
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
