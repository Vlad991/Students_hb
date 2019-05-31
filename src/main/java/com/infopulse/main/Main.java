package com.infopulse.main;

import com.infopulse.entity.Group;
import com.infopulse.entity.Student;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory)
                Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Group group1 = new Group();
        group1.setName("EM-71");

        Student vlad = new Student();
        vlad.setName("Vlad");
        vlad.setSurname("Kuzma");
        vlad.setAge(19);
        vlad.setDateOfBirth("14.10.1999");
        vlad.setGroup(group1);

        Student yura = new Student();
        yura.setName("Yura");
        yura.setSurname("Pilipko");
        yura.setAge(19);
        yura.setDateOfBirth("10.05.2000");
        yura.setGroup(group1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(vlad);
        students.add(yura);
        group1.setStudents(students);

        entityManager.persist(group1);

        entityManager.getTransaction().commit();
        sessionFactory.close();
    }
}
