package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author irkin
 **/
public class test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            Employee emp1 = new Employee("Higgs", "Vertiagin", "it", 500);
            session.beginTransaction();
            session.save(emp1);
            session.getTransaction().commit();//close transaction
        } finally{
            factory.close();
        }



    }//main


}//class
