public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("I'm a dog");
    }

    @Override
    public void eat() {
        System.out.println("Bone");
    }
}
