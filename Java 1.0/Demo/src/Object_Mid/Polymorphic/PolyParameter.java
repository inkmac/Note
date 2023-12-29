package Object_Mid.Polymorphic;

//多态参数: 形参(编译类型)为父类类型, 但实参(运行类型)可为子类类型
//解释: 子类可以算作是父类, 就像dog也算animal, 所以父类类型参数可以传入子类类型

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getAnnual() {
        return 12 * salary;
    }
}

class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("worker " + getName() + " is working");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("worker " + getName() + " is managing");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}


public class PolyParameter {
    public static void main(String[] args) {
        Worker tom = new Worker("Tom", 9000);
        Manager pot = new Manager("POT", 21000, 30000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.show(tom);
        polyParameter.show(pot);
    }

    public void show(Employee er) {
        System.out.print(er.getAnnual() + "\t");
        if (er instanceof Worker) {
            ((Worker) er).work();
        } else if (er instanceof Manager) {
            ((Manager) er).manage();
        }else {
            System.out.println("无职业");
        }
    }
}

