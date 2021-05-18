package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Author irkin
 **/
public class test5 {// change salary for emp id= 1
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();//start tr
            session.beginTransaction();//start tr

            //Employee emp =session.get(Employee.class,1);
           // session.delete(emp);

//            Employee emp = new Employee("Hui", "Sbugra", "huevii", 10);//for testing purposes
//            session.save(emp);//fot testing purposes
            session.createQuery("delete Employee where name = 'Hui' ").executeUpdate();//2 way to delete




            session.getTransaction().commit();//close transaction
            System.out.println("Done!");//for testing purposes!

        } finally{
            factory.close();
        }



    }//main


}//class
