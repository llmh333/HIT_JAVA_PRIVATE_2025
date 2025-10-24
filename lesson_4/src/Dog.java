public class Dog extends Animal {
    private String name;
    private String color;

    public Dog() {
        super();
    }

    public Dog(String name, String color, double weight) {
        super(weight);
        this.name = name;
        this.color = color;
    }

    @Override
    protected double sound() {
        System.out.println("Gau Gau");
        return 1;
    }



    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight='" + getWeight() + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
