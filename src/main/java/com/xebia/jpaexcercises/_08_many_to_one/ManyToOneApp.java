package com.xebia.jpaexcercises._08_many_to_one;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Employee employee = new Employee();
            employee.setName("Tom");
            employee.setSalary(100_000);
            Department department = new Department("IT");
            employee.setDepartment(department);

            Employee employee1 = new Employee();
            employee1.setName("Amit");
            employee1.setSalary(100_00);
            employee1.setDepartment(department);
            entityManager.persist(employee);
            entityManager.persist(employee1);
            entityManager.getTransaction().commit();

            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println(foundEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
