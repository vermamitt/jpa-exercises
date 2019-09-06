package com.xebia.jpaexcercises._00_driver;

import com.xebia.jpaexcercises._07_id_gen.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class DbApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Test Employee");
        //employee.setEmail("test@test.com");
        employee.setBio("asvhgfdghwhsgdj");
        //entityManager.persist(employee);
        //entityManager.getTransaction().commit();

        File file = new File("C:\\Users\\amit.verma\\Downloads\\Photo.png");
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //employee.setPicture(bFile);
        //employee.setEmployeeType(EmployeeType.FULL_TIME);
        employee.setDateOfBirth(new Date());
        employee.setRegisteredAt(new Date());
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        Employee foundEmployee = entityManager.find(Employee.class, 1L);
        System.out.println("Find me.");
        System.out.println(foundEmployee);
        entityManager.close();
        entityManagerFactory.close();

    }
}
