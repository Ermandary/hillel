package decorator;

public class Program {
    public static void main(String[] args) {
        Watch smartWatch = new SmartWatch(new FitnessTracker(new WristWatch()));
        smartWatch.showInformation();
    }
}
