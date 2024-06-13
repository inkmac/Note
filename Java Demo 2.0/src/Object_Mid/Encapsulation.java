package Object_Mid;

//封装: 将代码写在一个方法里面-->隐藏内部细节, 保障数据安全和提供受控访问; 提高代码重用性

/*  细节
1.可以用Generate自动生成Getter和Setter,或者直接set+Tab补全
2.如何用构造器进行封装: 在构造器中调方法
3.
 */
class Person {
    private String name = "null";                      //给一个默认的值
    private int age = 0;

    public Person() {}                         //建立两个构造器
    public Person(String name, int age) {
        setAge(age);
        setName(name);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <=6) {      //使用name.length()获得字符串长度
            this.name = name;
        }else{
            System.out.println("name invalid, 2-6bytes");
        }
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120){
            this.age = age;
        }else{
            System.out.println("age invalid, 1-120int");
            this.age = 0;
        }
    }

    public String info() {
        //可以在这里加一个校验权限的机制 if...
        return "name=" + name + " age=" + age;
    }
}
class Account {
    public static void main(String[] args) {
        Person Person = new Person();
        Person.setName("bob");
        Person.setAge(20);
        System.out.println("=====information=====\n" + Person.info() + "\n");

        Person person02 = new Person("jackBoy", 300);
        System.out.println("=====information=====\n" + person02.info());

    }
}

