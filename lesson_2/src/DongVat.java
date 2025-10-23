public class DongVat {
    static int count;
    private String name;
    private String weight;

    public DongVat() {
        count++;
    }

    public DongVat(String name, String weight) {
        this.name = name;
        this.weight = weight;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        DongVat.count = count;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DongVat{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
