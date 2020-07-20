package java8.JUC;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Person> ar = new AtomicReference<>();
        Person p = new Person("ha", 23);
        ar.set(p);

        System.out.println(p);

        Person person = new Person("qqq", 11);
        ar.compareAndSet(person, p);
        System.out.println(person);
    }
}


class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}