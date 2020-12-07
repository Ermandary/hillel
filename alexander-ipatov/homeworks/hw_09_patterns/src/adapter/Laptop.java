package adapter;

public class Laptop {
    private UsbPort storage;

    public void insertStorage(UsbPort storage){
        this.storage = storage;
    }

    public void showDescription() {
        System.out.println(storage.getDescription());
    }
}
