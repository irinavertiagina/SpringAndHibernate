package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Author irkin
 **/
public class test3 {// get all the employees
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            List<Employee> list;
            Session session = factory.getCurrentSession();//start tr
            session.beginTransaction();//start tr
//            list = session.createQuery("from  Employee ")// Employee.class ??
//                    .getResultList();

//            list = session.createQuery("from  Employee where name = 'Higgs'") // Employee.class ??
//                    .getResultList();

            list = session.createQuery("from  Employee where name = 'Higgs' AND salary = 500 ") // Employee.class ??
                    .getResultList();

            for(Employee elem : list){
                System.out.println(elem);
            }

            session.getTransaction().commit();//close transaction

            System.out.println("Done!");//for testing purposes!

        } finally{
            factory.close();
        }



    }//main


}//class
