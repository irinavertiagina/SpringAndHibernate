package hibernate_one_to_one;

import hibernate_one_to_one.entity.Details;
import hibernate_one_to_one.entity.Employee;
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
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();
        try {
            Employee emp1 = new Employee("Higgs", "Mehov", "check", 650);

            Session session = factory.getCurrentSession();//start transaction
            session.beginTransaction();//start transaction

//            Employee emp = new Employee("Higgs", "Pirogov", "IT", 300);
//            Details details = new Details("Engels", "eshak@mail.com", "12345678");
//            emp.setEmptyDetail(details);
//            session.save(emp);

            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp.getEmptyDetail());


            session.getTransaction().commit();//close transaction
            System.out.println("Done!");
           // System.out.println(emp1);//for testing purposes

        } finally{
            factory.close();
        }



    }//main


}//class
