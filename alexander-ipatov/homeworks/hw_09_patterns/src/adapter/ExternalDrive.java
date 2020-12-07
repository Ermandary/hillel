package adapter;

public class ExternalDrive implements UsbPort {
    private Disk disk;

    public ExternalDrive(Disk disk) {
        this.disk = disk;
    }

    @Override
    public String getDescription() {
        return disk.DESCRIPTION;
    }
}
