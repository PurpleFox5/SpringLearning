package Task1_8;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private Random rnd = new Random();
    private DateFormat dt;

    private int id = rnd.nextInt(100);
    private String msg;
    private Date date;

    public Event(Date date, DateFormat dt) {
        this.date = date;
        this.dt = dt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dt.format(date) +
                '}';
    }
}
