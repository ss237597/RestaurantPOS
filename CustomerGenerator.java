/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ss237597
 */
public class CustomerGenerator {
    Customer[] c = new Customer[100];
    Customer[] sort_by_r_time = new Customer[100];
    Customer[] sort_by_a_time = new Customer[100];
    Customer[] sort_by_l_time = new Customer[100];
    public CustomerGenerator()  {
        for (int i = 0; i < 100; i++)   {
            String name = "John" + Integer.toString(i+1);
            int size = (int)(10*Math.random())+1;
            int reserved_time = (int)(100*Math.random())+1;
            int arrived_time = reserved_time + (int)(10*Math.random());
            int staying_time = (int)(20*Math.random())+1;
            int r = (int)(10*Math.random())+1;
            String seat = null;
            if (r < 3)
                seat = "Booth";
            if (r >= 3 && r < 7)
                seat = "Window";
            if (r >= 7)
                seat = "Bar";
            c[i] = new Customer(name, size, reserved_time, arrived_time, staying_time, seat);
        }
        sort_by_r_time = sbrt();
        sort_by_a_time = sbat();
        sort_by_l_time = sblt();
    }
    public Customer[] sbrt()    {
        Customer[] temp = c;
        for (int i = 0; i < 100; i++)   {
            int temp2 = 99999;
            int ind = 0;
            for (int j = 0; j < 100; j++)   {
                int t = temp[j].r_time();
                if (temp2 > t)   {
                    temp2 = t;
                    ind = j;
                }
            }
            sort_by_r_time[i] = c[ind];
            temp[ind].set_r_time(99999);
        }
        return sort_by_r_time;
    }
    public Customer[] sbat()    {
        Customer[] temp = c;
        for (int i = 0; i < 100; i++)   {
            int temp2 = 99999;
            int ind = 0;
            for (int j = 0; j < 100; j++)   {
                int t = temp[j].a_time();
                if (temp2 > t)   {
                    temp2 = t;
                    ind = j;
                }
            }
            sort_by_a_time[i] = c[ind];
            temp[ind].set_a_time(99999);
        }
        return sort_by_a_time;
    }
    public Customer[] sblt()    {
        Customer[] temp = c;
        for (int i = 0; i < 100; i++)   {
            int temp2 = 99999;
            int ind = 0;
            for (int j = 0; j < 100; j++)   {
                int t = temp[j].l_time();
                if (temp2 > t)   {
                    temp2 = t;
                    ind = j;
                }
            }
            sort_by_l_time[i] = c[ind];
            temp[ind].set_l_time(99999);
        }
        return sort_by_l_time;
    }
    public void print() {
        for (int i = 0; i < 100; i++)   {
            Customer x = c[i];
            System.out.println(x.name + " " + x.size + " " + x.reserved_time + " " + x.status + " " + x.arrived_time + " " + x.staying_time + " " + x.seat + " " + x.leaving_time);
        }
    }
    
    public void print_sbrt()    {
        for (int i = 0; i < 100; i++)
            System.out.println(sort_by_r_time[i].r_time());
    }
    public void print_sbat()    {
        for (int i = 0; i < 100; i++)
            System.out.println(sort_by_a_time[i].r_time());
    }
    public void print_sblt()    {
        for (int i = 0; i < 100; i++)
            System.out.println(sort_by_l_time[i].r_time());
    }
}
