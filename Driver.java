/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ss237597
 */
public class Driver {
    /**
     *
     * @param args
     * @throws Seats.SeatsCurrentlyOccupiedException
     */
    public static void main(String[] args) throws Seats.SeatsCurrentlyOccupiedException  {
        CustomerGenerator cg = new CustomerGenerator();
        Seats s = new Seats();
        for (int i = 0; i < 200; i++)   {
            cg.print();
            int time = i;
            for (int j = 0; j < 100; j++)   {
                if (cg.sort_by_a_time[j].a_time() == time)
                    s.reserve(cg.sort_by_a_time[j]);
            }
            s.refresh(time);
        }
    }
}
