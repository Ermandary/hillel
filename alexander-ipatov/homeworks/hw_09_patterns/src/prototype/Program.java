package prototype;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException {
        Computer myComputer = new Computer(
                "Intel Core i5-6400",
                "Nvidia 1060 6gb",
                "1TB",
                "Asus B-360",
                "8gb",
                "FSP 750W"
        );
        Computer clone = myComputer.clone();

        System.out.println(myComputer);
        System.out.println(clone);
    }
}
