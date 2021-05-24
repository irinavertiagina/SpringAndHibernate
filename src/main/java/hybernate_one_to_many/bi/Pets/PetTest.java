package hybernate_one_to_many.bi.Pets;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Author irkin
 **/
public class PetTest { // save 1 employee
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Pet.class)
                .buildSessionFactory();
        try {


            Session session = factory.getCurrentSession();//start transaction
            session.beginTransaction();//start transaction
//
//            Pet pet = new Pet("higgs", "cat");
//            Person person = new Person("Irina");
//            pet.setOwner(person);
//             session.save(pet);
//            session.save(person);
//            List<Pet> petList = person.getPetList();
//            for(Pet el: petList){
//                System.out.println(el);
//            }


            Person person = session.get(Person.class, 3);
            System.out.println(person.getPetList());



            session.getTransaction().commit();//close transaction
            System.out.println("Done!");
            // System.out.println(emp1);//for testing purposes

        } finally{
            factory.close();
        }



    }//main


}//class
