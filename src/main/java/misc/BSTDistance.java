package misc;

/**
 * Created by PV029500 on 5/23/2017.
 */
public class BSTDistance {

    public int bstDistance(int[] arr, int first, int second) {

        if (first == second) return 0;
        int max = first > second ? first : second;
        int min = first > second ? second : first;
        int ancestor = Integer.MAX_VALUE;
        int maxPos = -1;
        int minPos = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                maxPos = i;
            } else if (arr[i] == min) {
                minPos = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min || arr[i] == max) {
                ancestor = i;
                break;
            } else if (arr[i] > min && arr[i] < max && i < maxPos && i < minPos) {
                ancestor = i;
                break;
            }
        }

        int tempMin = Integer.MIN_VALUE;
        int tempMax = Integer.MAX_VALUE;
        int fromMinToA = 0;
        for (int i = ancestor + 1; i < minPos; i++) {
            if (arr[i] < arr[ancestor]) {
                if (min < arr[i] && arr[i] < tempMax) {
                    tempMax = arr[i];
                    fromMinToA++;
                } else if (min > arr[i] && arr[i] > tempMin) {
                    tempMin = arr[i];
                    fromMinToA++;
                }
            }
        }

        tempMin = Integer.MAX_VALUE;
        tempMax = Integer.MIN_VALUE;

        int fromAtoMax = 0;
        for (int i = ancestor + 1; i < maxPos; i++) {
            if (arr[i] > arr[ancestor]) {
                if (max > arr[i] && arr[i] > tempMax) {
                    tempMax = arr[i];
                    fromAtoMax++;
                } else if (max < arr[i] && arr[i] < tempMin) {
                    tempMin = arr[i];
                    fromAtoMax++;
                }
            }
        }
        fromAtoMax = ancestor == max ? 0 : fromAtoMax + 1;
        fromMinToA = ancestor == min ? 0 : fromMinToA + 1;
        return fromMinToA + fromAtoMax;
    }
}
