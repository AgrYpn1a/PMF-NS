package hashtables.putnici;

/**
 * Created by Rastko on 15-Nov-16.
 */
public class Date {

    private final int day;
    private final int month;
    private final int year;

    public Date(final int day, final int month, final int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDate() {
        return day + "/" + month + "/" + year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
