package org.ahnu.chap10;

import org.ahnu.model.Car;
import org.ahnu.model.Insurance;
import org.ahnu.model.Person;

import java.util.Optional;

public class OptionalAction {

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);
        System.out.println("1------------" + name);

        Person person = null;
        Optional<Person> optPerson = Optional.ofNullable(person);
        String insuranceName2 = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
        System.out.println("2------------------" + insuranceName2);
    }
}
