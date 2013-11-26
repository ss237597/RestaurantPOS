import java.sql.Time;
import java.util.Calendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ss237597
 */
public class Customer {
    String name;
    int size;
    int reserved_time;
    String status;
    int arrived_time;
    int staying_time;
    String seat;
    int leaving_time;
    public Customer(String name, int size, int reserved_time, int arrived_time, int staying_time, String seat)   {
        this.name = name;
        this.size = size;
        this.reserved_time = reserved_time;
        this.status = "Not served";
        this.arrived_time = arrived_time;
        this.staying_time = staying_time;
        this.seat = seat;
        this.leaving_time = this.arrived_time + this.staying_time;
    }
    public String getName() {
        return name;
    }
    public int getSize()    {
        return size;
    }
    public String getSeat() {
        return seat.toLowerCase();
    }
    public void set_r_time(int r_time)    {
        reserved_time = r_time;
    }
    public void set_a_time(int a_time)    {
        arrived_time = a_time;
    }
    public void set_l_time(int l_time)    {
        leaving_time = l_time;
    }
    public int r_time() {
        return reserved_time;
    }
    public int a_time() {
        return arrived_time;
    }
    public int l_time() {
        return leaving_time;
    }
}
