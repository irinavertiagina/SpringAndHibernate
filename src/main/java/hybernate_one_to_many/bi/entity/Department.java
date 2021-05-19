package hybernate_one_to_many.bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author irkin
 **/

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_salary")
    private int min;

    @Column(name = "max_salary")
    private int max;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dept")
    private List <Employee> employeeList ;

    public Department() {
    }

    public Department(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }



    public void addNewEmployee(Employee emp){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(emp);
        emp.setDept(this);
    }







    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", employeeList=" + employeeList +
                '}';
    }
}
