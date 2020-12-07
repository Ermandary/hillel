package prototype;

public class Computer implements Cloneable {
    private String CPU;
    private String GPU;
    private String HardWare;
    private String Motherboards;
    private String Memory;
    private String PowerSupplies;

    public Computer(String CPU, String GPU, String hardWare, String motherboards, String memory, String powerSupplies) {
        this.CPU = CPU;
        this.GPU = GPU;
        HardWare = hardWare;
        Motherboards = motherboards;
        Memory = memory;
        PowerSupplies = powerSupplies;
    }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        return (Computer) super.clone();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", HardWare='" + HardWare + '\'' +
                ", Motherboards='" + Motherboards + '\'' +
                ", Memory='" + Memory + '\'' +
                ", PowerSupplies='" + PowerSupplies + '\'' +
                '}';
    }
}
