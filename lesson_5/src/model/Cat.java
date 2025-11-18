package model;

import service.Flyable;

public class Cat extends Animal {


    public Cat() {
        super();
    }
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }

    @Override
    public void eat() {
        System.out.println("Fish");
    }

    @Override
    public void move() {

    }

    @Override
    public boolean fly() {
        return false;
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "} ";
    }
}
