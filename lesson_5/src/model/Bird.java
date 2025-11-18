package model;

public class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public boolean fly() {
        return true;
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "} ";
    }
}
