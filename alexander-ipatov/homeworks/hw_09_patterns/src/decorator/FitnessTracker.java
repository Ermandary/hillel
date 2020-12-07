package decorator;

public class FitnessTracker extends WatchDecorator {

    public FitnessTracker(Watch watch) {
        super(watch);
    }

    public void getCalories(){
        System.out.println("You have burned 100 calories");
    }

    @Override
    public void showInformation() {
        super.showInformation();
        getCalories();
    }
}
