package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author irkin
 **/
public class test1 { // save 1 employee
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Employee emp1 = new Employee("Higgs", "Mehov", "check", 650);

            Session session = factory.getCurrentSession();//start transaction
            session.beginTransaction();//start transaction
            session.save(emp1);//working code
            session.getTransaction().commit();//close transaction
            System.out.println(emp1);//for testing purposes

        } finally{
            factory.close();
         }



    }//main


}//class
