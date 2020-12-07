package decorator;

import java.util.Date;

public class WristWatch implements Watch{
    private Date date;

    @Override
    public void showInformation() {
        date = new Date();
        System.out.println(date);
    }
}
