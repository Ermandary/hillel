package decorator;

public class WatchDecorator implements Watch {
    private Watch watch;

    public WatchDecorator(Watch watch) {
        this.watch = watch;
    }

    @Override
    public void showInformation() {
        watch.showInformation();
    }
}
