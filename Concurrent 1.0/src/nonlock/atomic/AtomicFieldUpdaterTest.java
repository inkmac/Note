package nonlock.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicFieldUpdaterTest {
    public static void main(String[] args) {
        Student student = new Student();

        AtomicReferenceFieldUpdater<Student, String> updater =
                AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");

        System.out.println(updater.compareAndSet(student, null, "A"));
        System.out.println(student);
    }
}

class Student {
    volatile String name;  // 必须和volatile一起使用

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
