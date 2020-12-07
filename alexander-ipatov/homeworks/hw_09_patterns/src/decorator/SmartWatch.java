package decorator;

public class SmartWatch extends WatchDecorator {
    public SmartWatch(Watch watch) {
        super(watch);
    }

    public void showMessage(){
        System.out.println("form Alex: Hi, how are you?");
    }

    @Override
    public void showInformation() {
        super.showInformation();
        showMessage();
    }
}
