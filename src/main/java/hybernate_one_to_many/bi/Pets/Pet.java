package hybernate_one_to_many.bi.Pets;

import javax.persistence.*;

/**
 * Author irkin
 **/
@Entity
@Table(name = "pet")
public class Pet {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "breed")
    private String breed;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Person owner;


    public Pet() {
    }

    public Pet(String name, String breed) {
        this.breed = breed;
        this.name = name;
    }

    public Pet(String breed, String name, Person owner) {
        this.breed = breed;
        this.name = name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
