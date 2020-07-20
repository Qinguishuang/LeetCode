package java8.chapter10;

import java.util.Optional;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        Optional<Car> car1 = Optional.empty();

        Car car = new Car();
        Optional<Car> car2 = Optional.of(car);

        Optional<Car> car3 = Optional.ofNullable(car);

        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println(name);

        optInsurance.filter(ins -> "insurance".equals(ins.getName())).ifPresent(x -> System.out.println("ok"));

    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");

    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        // if (person.isPresent() && car.isPresent()) {
        //     return Optional.of(findCheapestInsurance(person.get(), car.get()));
        // } else {
        //     return Optional.empty();
        // }
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    private Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }

}

class Person {
    private Optional<Car> car;
    private int age;

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}
