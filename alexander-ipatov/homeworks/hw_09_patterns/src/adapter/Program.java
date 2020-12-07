package adapter;

public class Program {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        FlashDrive flash = new FlashDrive();

        laptop.insertStorage(flash);
        laptop.showDescription();

        Disk disk = new Disk();
        ExternalDrive externalDrive = new ExternalDrive(disk);

        laptop.insertStorage(externalDrive);
        laptop.showDescription();
    }
}
