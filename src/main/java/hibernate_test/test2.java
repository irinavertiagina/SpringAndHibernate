package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author irkin
 **/
public class test2 { //get 1 employee
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();//start tr
            session.beginTransaction();//start tr

            Employee emp1 = session.get(Employee.class, 2);//working code

            session.getTransaction().commit();//close transaction

            System.out.println("Done!");//for testing purposes!
            System.out.println(emp1);
        } finally{
            factory.close();
        }



    }//main


}//class
