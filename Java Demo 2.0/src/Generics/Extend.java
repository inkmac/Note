package Generics;

import java.util.List;
import java.util.function.Consumer;

public class Extend {

    public static void main(String[] args) {
        List<Dog> dogList = Dog.getDogList();
        List<Cat> catList = Cat.getCatList();

        test1(dogList);
        test1(catList);

        Consumer<Object> c1 = obj -> System.out.println(obj + ": " + "Obj");
        Consumer<Animal> c2 = animal -> System.out.println(animal + ": " + "Animal");

        test2(dogList, c1);
        test2(catList, c2);
    }

    /*
     *  需求1: 写一个方法能处理 List<Dog> List<Cat>, 但不能处理List<Person>
     *
     *  设想: 使用 List<Animal> list 来接收
     *  List<Animal> list = new List<Dog>();  假设可以
     *  list.add(new Cat())  又跟 List<Dog> 冲突, 所以不行
     *
     *  解决: 用 <? extends Animal>
     *      但是会导致传入的List可以是<Dog> 也可以是<Cat>,
     *      因此传入的list不能进行添加操作
     */
    private static void test1(List<? extends Animal> list) {
        for (Animal o : list) {
            System.out.println(o);
        }
    }

    /*
     *  需求2: 在需求1的基础上, 给方法提供一个Consumer参数, 能够将参数1的集合, 按Object类型打印或按Animal类型打印
     *
     *  解决: 用 <? super Animal>
     *      可以往泛型容器写入对象, 但是只能写入Animal及其子类型的对象,
     *      因为Animal及其子类一定是<? super Animal>的子类类型, 可以添加;
     *      而Animal父类类型就不一定了, 因此不能添加
     *
     */
    private static void test2(List<? extends Animal> list, Consumer<? super Animal> consumer) {
        for (Animal o : list) {
            consumer.accept(o);
        }
    }


    static class Animal {
        private static List<Animal> getAnimalList() {
            return List.of(
                new Animal(),
                new Animal()
            );
        }
    }

    static class Dog extends Animal {
        private static List<Dog> getDogList() {
            return List.of(
                new Dog(),
                new Dog()
            );
        }
    }

    static class Cat extends Animal {
        private static List<Cat> getCatList() {
            return List.of(
                new Cat(),
                new Cat()
            );
        }
    }

    static class Person {
        private static List<Person> getPersonList() {
            return List.of(
                new Person(),
                new Person()
            );
        }
    }
}



/*
    // <?> 表示任意的泛型类型都可以接收
    public static void all(List<?> list) {}

    // <? extends AA> 表示AA及其子类的泛型类型都可以接收
    public static void extend(List<? extends AA> list) {}

    // <? super AA> 表示AA及其父类的泛型类型都可以接收
    public static void super_(List<? super AA> list) {}

    /* <?> 的产生:
        List类型有许多泛型类型, 比如List<Cat>, List<Dog>, List<Animal>,
        但是如果要的类型不确定, 就可以用List<? extends Animal>, 这样就只接收Animal及子类泛型类型的List
    */





