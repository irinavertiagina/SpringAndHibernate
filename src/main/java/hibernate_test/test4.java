package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Author irkin
 **/
public class test4 {// change salary for emp id= 1
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
             Session session = factory.getCurrentSession();//start tr
            session.beginTransaction();//start tr
//1 example
//             Employee emp = session.get(Employee.class, 1);
//             emp.setSalary(1440);
//2 example
//            List<Employee> list = session.createQuery(" from  Employee where name = 'Higgs'").getResultList();
//            for (Employee el: list){
//                el.setDepartment("beloved");
//            }
//3 example = better way to do 2 example
             session.createQuery(" update Employee set department = 'pet' where name = 'Higgs'").executeUpdate();//the same way to cas 2 quety but without list

            session.getTransaction().commit();//close transaction
            System.out.println("Done!");//for testing purposes!

        } finally{
            factory.close();
        }



    }//main


}//class
