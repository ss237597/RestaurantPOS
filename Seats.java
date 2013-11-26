/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ss237597
 */
public class Seats {
    static boolean[] bar = new boolean[20];
    static boolean[] booth = new boolean[50];
    static boolean[] window = new boolean[20];
    static int[] bar_occ_times = new int[20];
    static int[] booth_occ_times = new int[50];
    static int[] window_occ_times = new int[20];
    public Seats()  {
        for (int i = 0; i < bar.length; i++)
            bar[i] = true;
        for (int i = 0; i < booth.length; i++)
            booth[i] = true;
        for (int i = 0; i < window.length; i++)
            window[i] = true;
        for (int i = 0; i < bar_occ_times.length; i++)
            bar_occ_times[i] = 0;
        for (int i = 0; i < booth_occ_times.length; i++)
            booth_occ_times[i] = 0;
        for (int i = 0; i < window_occ_times.length; i++)
            window_occ_times[i] = 0;
    }
    public int bar_unocc()  {
        int asdf = 0;
        for (int i = 0; i < bar.length; i++)    {
            if (bar[i])
                asdf++;
        }
        return asdf;
    }
    public int booth_unocc()  {
        int asdf = 0;
        for (int i = 0; i < booth.length; i++)    {
            if (booth[i])
                asdf++;
        }
        return asdf;
    }
    public int window_unocc()  {
        int asdf = 0;
        for (int i = 0; i < window.length; i++)    {
            if (window[i])
                asdf++;
        }
        return asdf;
    }
    public void reserve(Customer c) throws SeatsCurrentlyOccupiedException {
        String s = c.getSeat();
        if (s.equals("bar"))  {
            if (c.getSize() > bar_unocc())
                throw new SeatsCurrentlyOccupiedException();
            else    {
                int[] unoccs = new int[c.getSize()];
                for (int i = 0; i < unoccs.length; i++)
                    unoccs[i] = 0;
                int ind = 0;
                int u_ind = 0;
                while (unoccs[unoccs.length-1] != 0) {
                    if (bar_occ_times[ind] == 0)    {
                        unoccs[u_ind] = ind;
                        u_ind++;
                    }
                    ind++;
                }
                for (int i = 0; i < unoccs.length; i++) {
                    bar_occ_times[unoccs[i]] = c.l_time();
                    bar[unoccs[i]] = false;
                    System.out.println("Bar seat " + unoccs[i] + " is now reserved by customer " + c.getName());
                }
            }
        }
        else if (s.equals("booth")) {
            if (c.getSize() > booth_unocc())
                throw new SeatsCurrentlyOccupiedException();
            else    {
                int[] unoccs = new int[c.getSize()];
                for (int i = 0; i < unoccs.length; i++)
                    unoccs[i] = 0;
                int ind = 0;
                int u_ind = 0;
                while (unoccs[unoccs.length-1] != 0) {
                    if (booth_occ_times[ind] == 0)    {
                        unoccs[u_ind] = ind;
                        u_ind++;
                    }
                    ind++;
                }
                for (int i = 0; i < unoccs.length; i++) {
                    booth_occ_times[unoccs[i]] = c.l_time();
                    booth[unoccs[i]] = false;
                    System.out.println("Booth seat " + unoccs[i] + " is now reserved by customer " + c.getName());
                }
            }
        }
        else    {
            if (c.getSize() > window_unocc())
                throw new SeatsCurrentlyOccupiedException();
            else    {
                int[] unoccs = new int[c.getSize()];
                for (int i = 0; i < unoccs.length; i++)
                    unoccs[i] = 0;
                int ind = 0;
                int u_ind = 0;
                while (unoccs[unoccs.length-1] != 0) {
                    if (window_occ_times[ind] == 0)    {
                        unoccs[u_ind] = ind;
                        u_ind++;
                    }
                    ind++;
                }
                for (int i = 0; i < unoccs.length; i++) {
                    window_occ_times[unoccs[i]] = c.l_time();
                    window[unoccs[i]] = false;
                    System.out.println("Window seat " + unoccs[i] + " is now reserved by customer " + c.getName());
                }
            }
        }
    }
    public static void refresh(int time) {
        for (int i = 0; i < bar.length; i++)    {
            if (bar_occ_times[i] == time)   {
                bar_occ_times[i] = 0;
                bar[i] = true;
            }
        }
        for (int i = 0; i < booth.length; i++)    {
            if (booth_occ_times[i] == time)   {
                booth_occ_times[i] = 0;
                booth[i] = true;
            }
        }
        for (int i = 0; i < booth.length; i++)    {
            if (booth_occ_times[i] == time)   {
                booth_occ_times[i] = 0;
                booth[i] = true;
            }
        }
    }
    public static class SeatsCurrentlyOccupiedException extends Exception {
        public SeatsCurrentlyOccupiedException() {
            System.out.println("Currently no available seats of this type at this time.");
        }
    }
}
