package hybernate_one_to_many.bi;

import hybernate_one_to_many.bi.entity.Department;
import hybernate_one_to_many.bi.entity.Employee;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();//start transaction
            session.beginTransaction();//start transaction

//           Department it = new Department("it", 200, 300);
//           Employee higgs = new Employee("Higgs", "Vertiahin", 300);
//           Employee irina = new Employee("Irina", "Ver", 200);
//           it.addNewEmployee(higgs);
//           it.addNewEmployee(irina);
 //          session.save(it);

Department department = session.get(Department.class, 4);
            System.out.println(department.getEmployeeList());

            session.getTransaction().commit();//close transaction
            System.out.println("Done!");
           // System.out.println(emp1);//for testing purposes

        } finally{
            factory.close();
        }



    }//main


}//class
