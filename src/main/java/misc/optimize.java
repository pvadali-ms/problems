package misc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ChaitraDinesh
 */
public class optimize {

    /**
     * @param args the command line arguments
     * @param list ClassLoader classLoader = getClass().getClassLoader();
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String inputfile = "/Users/pvadali/publicgit/problems/src/main/resources/5.in", line = "";
        FileReader file_rdr = new FileReader(inputfile);
        BufferedReader buf_rdr = new BufferedReader(file_rdr);
        int num_lifeguard = Integer.parseInt(buf_rdr.readLine());

        ArrayList<LifeGuard> lifeGaurds = new ArrayList<>();
        while ((line = buf_rdr.readLine()) != null) {
            String[] ratings = line.split(" ");
            lifeGaurds.add(new LifeGuard(Double.parseDouble(ratings[0]), Double.parseDouble(ratings[1])));
        }

        Collections.sort(lifeGaurds, new LifeGuard());

        LifeGuard minoverlapSwimInterval = new LifeGuard(Integer.MIN_VALUE, Integer.MAX_VALUE);
        double total_time = 0;
        double removetimeinterval = Integer.MAX_VALUE;
        double effectiveinterval = Integer.MAX_VALUE;
        double calculateinterval = 0;
        double temp_interval = 0;
        //int flag=0;
        for (int i = 0; i < num_lifeguard; i++) {
            total_time += lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
            //if time interval is compltely inside another interval
            //calculate the effective time for inside interval
            if (i > 0 && (lifeGaurds.get(i).startTime < lifeGaurds.get(i - 1).endTime) && (lifeGaurds.get(i).endTime < lifeGaurds.get(i - 1).endTime)) {
                temp_interval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime);
                calculateinterval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime) - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
            //if time interval is compltely inside another interval
            //calculate the effective time for outside interval
            else if (i < (num_lifeguard - 1) && (lifeGaurds.get(i + 1).startTime < lifeGaurds.get(i).endTime) && (lifeGaurds.get(i + 1).endTime < lifeGaurds.get(i).endTime)) {
                temp_interval = (lifeGaurds.get(i + 1).endTime - lifeGaurds.get(i + 1).startTime);
                calculateinterval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime) - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
            //if time interval is the first one present and has overlapping intrval
            //special case
            else if (i == 0 && i < (num_lifeguard - 1) && (lifeGaurds.get(i + 1).startTime < lifeGaurds.get(i).endTime)) {
                temp_interval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i + 1).startTime);
                calculateinterval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime) - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
            //if time interval is has overlapping next interval
            else if (i > 0 && i < (num_lifeguard - 1) && i > 0 && (lifeGaurds.get(i + 1).startTime < lifeGaurds.get(i).endTime) && (lifeGaurds.get(i).startTime == lifeGaurds.get(i - 1).endTime)) {
                temp_interval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i + 1).startTime);
                calculateinterval = (lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime) - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
            //if time interval is has overlapping previous interval
            else if (i > 0 && (lifeGaurds.get(i - 1).endTime > lifeGaurds.get(i).startTime) && (lifeGaurds.get(i).startTime == lifeGaurds.get(i - 1).endTime)) {
                temp_interval = (lifeGaurds.get(i - 1).endTime - lifeGaurds.get(i).startTime);
                calculateinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
            //if time interval is completely overlapping
            else if (i > 0 && (lifeGaurds.get(i).startTime < lifeGaurds.get(i - 1).endTime) && (lifeGaurds.get(i).startTime != lifeGaurds.get(i - 1).endTime)) {
                temp_interval = (lifeGaurds.get(i - 1).endTime - lifeGaurds.get(i).startTime) +
                        (lifeGaurds.get(i).endTime - lifeGaurds.get(i - 1).endTime);
                calculateinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime - temp_interval;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            } else {
                calculateinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                if (calculateinterval < effectiveinterval) {
                    effectiveinterval = calculateinterval;
                    removetimeinterval = lifeGaurds.get(i).endTime - lifeGaurds.get(i).startTime;
                    minoverlapSwimInterval = new LifeGuard(lifeGaurds.get(i).getStartTime(), lifeGaurds.get(i).getEndTime());
                }
            }
        }

        System.out.println("The intervals starttime" + minoverlapSwimInterval.startTime + "The intervals endtime" + minoverlapSwimInterval.endTime);
        System.out.println("The total time is " + total_time);
        System.out.println("The time interval to be removed is" + (removetimeinterval));
        System.out.println("The optimum time with lifegaurds" + (total_time - (removetimeinterval)));
    }

    public static class LifeGuard implements Comparator<Object> {
        double startTime;
        double endTime;

        public LifeGuard(double startTime, double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LifeGuard() {
            this.startTime = 0;
            this.endTime = 0;
        }

        public double getStartTime() {
            return startTime;
        }

        public double getEndTime() {
            return endTime;
        }

        public double getDuration() {
            return endTime - startTime;
        }

        public boolean equals(Object o) {
            // self check
            if (this == o)
                return true;
            // null check
            if (o == null)
                return false;
            // type check and cast
            if (getClass() != o.getClass())
                return false;
            LifeGuard lg = (LifeGuard) o;
            // field comparison
            return (lg.getStartTime() == startTime
                    && lg.getEndTime() == endTime);
        }

        @Override
        public int compare(Object t, Object t1) {

            int ret = 0;
            LifeGuard l = (LifeGuard) t;
            LifeGuard l1 = (LifeGuard) t1;
            if (l.equals(l1)) {
                return ret;
            }
            ret = Double.compare(l.getStartTime(), l1.getStartTime());
            if (0 == ret) {
                return Double.compare(l.getEndTime(), l1.getEndTime());
            }

            return ret;
        }

    }

}




