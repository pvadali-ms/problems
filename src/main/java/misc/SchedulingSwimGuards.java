package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SchedulingSwimGuards {


    public int getTotalShiftLongMethod(List<SwimInterval> swimIntervals) {
        int sum = 0;
        Collections.sort(swimIntervals, new Comparator<SwimInterval>() {
            @Override
            public int compare(SwimInterval o1, SwimInterval o2) {
                return ((Integer) o1.getBegin()).compareTo((Integer) o2.getBegin());
            }
        });
        for (int i = 0; i < swimIntervals.size() - 1; i++) {
            List<SwimInterval> prefixList = new ArrayList<>(swimIntervals.subList(0, i + 1));
            List<SwimInterval> suffixList = new ArrayList<>(swimIntervals.subList(i + 2, swimIntervals.size()));
            prefixList.addAll(suffixList);
            int temp = getTotalShiftAfterFiring(prefixList);
            sum = Math.max(sum, temp);
        }
        return sum;
    }

    public int getTotalShift(List<SwimInterval> swimIntervals) {
        Collections.sort(swimIntervals, Comparator.comparing(o -> (o.getBegin())));
        removeMinimalImpactGuard(swimIntervals);
        return getTotalShiftAfterFiring(swimIntervals);
    }

    private void removeMinimalImpactGuard(List<SwimInterval> swimIntervals) {
        int minImpact = Integer.MAX_VALUE;
        int previousEnd = Integer.MIN_VALUE;
        SwimInterval minSwimInterval = null;
        int swimIntervalSize = swimIntervals.size();
        for (int i = 0; i < swimIntervalSize; i++) {
            int nextEnd = i == swimIntervalSize - 1 ? Integer.MAX_VALUE : swimIntervals.get(i + 1).getEnd();
            SwimInterval swimInterval = swimIntervals.get(i);
            SwimInterval nextInterval = i == swimIntervalSize - 1 ? null : swimIntervals.get(i + 1);
            int nextBegin = nextInterval == null ? Integer.MAX_VALUE : nextInterval.getBegin();
            int currentImpact;
            if (nextEnd <= swimInterval.getEnd()) {
                swimIntervals.remove(nextInterval);
                System.out.println("shortcut " + nextInterval.getBegin() + " " + nextInterval.getEnd());
                return;
            }
            currentImpact = swimInterval.getEnd() - swimInterval.getBegin();
            if (previousEnd > swimInterval.getBegin()) {
                currentImpact = currentImpact - (previousEnd - swimInterval.getBegin());
            }
            if (nextBegin < swimInterval.getEnd()) {
                currentImpact = currentImpact - (swimInterval.getEnd() - nextBegin);
            }
            if (currentImpact < minImpact) {
                minSwimInterval = swimInterval;
                minImpact = currentImpact;
            }
            previousEnd = swimInterval.getEnd();
        }
        swimIntervals.remove(minSwimInterval);
        System.out.println("Min interval is " + minSwimInterval.getBegin() + " " + minSwimInterval.getEnd());
    }


    private int getTotalShiftAfterFiring(List<SwimInterval> swimIntervals) {
        int sum = 0;
        int swimIntervalSize = swimIntervals.size();
        for (int i = 0; i < swimIntervalSize; i++) {
            SwimInterval currentInterval = swimIntervals.get(i);
            sum += currentInterval.getEnd() - currentInterval.getBegin();
//            System.out.println(currentInterval.getEnd() - currentInterval.getBegin());
            SwimInterval nextInterval = i == swimIntervalSize - 1 ? null : swimIntervals.get(i + 1);
            while (nextInterval != null && nextInterval.getEnd() <= currentInterval.getEnd()) {
                i++;
                nextInterval = i == swimIntervalSize - 1 ? null : swimIntervals.get(i + 1);
                System.out.println(sum);
            }
            if (nextInterval != null && currentInterval.getEnd() > nextInterval.getBegin()) {
                sum -= currentInterval.getEnd() - nextInterval.getBegin();
                //9.0013452e7;
            }
        }
        return sum;
    }

    public static class SwimInterval {
        int begin;
        int end;

        public SwimInterval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
