package Generics.Employees;
import java.util.*;


public class EmployeeCompare {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("BOB",new MyDate(2006,5,3)));
        employees.add(new Employee("BOB",new MyDate(2015,10,3)));
        employees.add(new Employee("BOB",new MyDate(2015,10,5)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirth().compareTo(o2.getBirth());
            }         //这个判断CompareTo判断可以封装起来
        });

        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}


class Employee{
    private final String name;
    private final MyDate birth;

    public Employee(String name, MyDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}


