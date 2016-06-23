/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datafrmfile.controller;

import com.leapfrog.datafrmfile.StudentDAO.Impl.StudentDaoImpl;
import com.leapfrog.datafrmfile.StudentDAO.StudentDao;
import com.leapfrog.datafrmfile.entity.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author onesoft
 */
public class Controller {

    StudentDao stdDao = new StudentDaoImpl();

    public void addAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/onesoft/student"));
            String line = "";
            while ((line = reader.readLine()) != null) {
               //System.out.println(line);

                String[] element = line.split(",");
                if (element.length >= 5) {
                    Student student = new Student();
                    student.setId(Integer.parseInt(element[0]));
                    student.setFirstName(element[1]);
                    student.setLastName(element[2]);
                    student.setEmail(element[3]);
                    if (Integer.parseInt(element[4]) == 1) {
                        student.setStatus(true);
                    } else if (Integer.parseInt(element[4]) == 0) {
                        student.setStatus(false);
                    }
                    boolean isEmail = stdDao.checkEmail(student);
                    boolean isId = stdDao.checkID(student);

                    if (isEmail == false && isId == false) {
                        stdDao.add(student);
                    }
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
    public void showAll(){
            for(Student std : stdDao.showAll()){
                System.out.println("ID : " + std.getId());
                System.out.println("First Name : " + std.getFirstName());
                System.out.println("Last Name : " + std.getLastName());
                System.out.println("Email : " + std.getEmail());
                System.out.println("Status : " + std.isStatus());
            }
        }
}
