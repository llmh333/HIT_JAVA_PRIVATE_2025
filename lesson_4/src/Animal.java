public class Animal {
    private double weight;

    public Animal() {}

    public Animal(double weight) {
        this.weight = weight;
    }

    protected double sound() {
        System.out.println("some sound");
        return 1;
    }

    public double getWeight() {
        return weight;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }
}
