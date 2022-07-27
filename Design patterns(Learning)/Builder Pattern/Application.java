package BuilderPattern;

public class Application {
    public static void main(String[] args) {
        Computer.Builder b = new Computer.Builder();
        b.setBrand("Brand").setRam("16GB");

        Computer computer = b.build();
        System.out.println(computer);
    }
}