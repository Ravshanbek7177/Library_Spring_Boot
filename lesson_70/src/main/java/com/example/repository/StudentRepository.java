package com.example.repository;

import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentEntity saveStudent(StudentEntity student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);

        transaction.commit();
        session.close();
        return student;
    }
}
