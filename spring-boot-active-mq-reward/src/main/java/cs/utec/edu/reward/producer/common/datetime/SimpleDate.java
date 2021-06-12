package cs.utec.edu.reward.producer.common.datetime;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimpleDate implements Serializable {
    private GregorianCalendar base;

    public SimpleDate(int month, int day, int year) {
        this.init(new GregorianCalendar(year, month - 1, day));
    }

    SimpleDate(long time) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time);
        this.init(cal);
    }

    private SimpleDate() {
        this.init(new GregorianCalendar());
    }

    private void init(GregorianCalendar cal) {
        this.base = this.trimToDays(cal);
    }

    private GregorianCalendar trimToDays(GregorianCalendar cal) {
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal;
    }

    public Date asDate() {
        return this.base.getTime();
    }

    public long inMilliseconds() {
        return this.asDate().getTime();
    }

    public int compareTo(Object date) {
        SimpleDate other = (SimpleDate)date;
        return this.asDate().compareTo(other.asDate());
    }

    public boolean equals(Object day) {
        if (!(day instanceof SimpleDate)) {
            return false;
        } else {
            SimpleDate other = (SimpleDate)day;
            return this.base.equals(other.base);
        }
    }

    public int hashCode() {
        return 29 * this.base.hashCode();
    }

    public static SimpleDate today() {
        return new SimpleDate();
    }

    public static SimpleDate valueOf(Date date) {
        return valueOf(date.getTime());
    }

    public static SimpleDate valueOf(long time) {
        return new SimpleDate(time);
    }

    public String toString() {
        return this.base.toString();
    }
}
