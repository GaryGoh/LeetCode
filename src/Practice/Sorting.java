package Practice;

/**
 * Created by mgao on 2018/3/22.
 */
public class Sorting {
    public int[] quickSort(int[] input) {
        partition(input, 0, input.length - 1);
        return input;
    }

    private void partition(int[] list, int left, int right) {
        if (left > right) {
            return;
        }
        int iniLeft = left;
        int iniRight = right;
        int pivot = list[left];

        while (left < right) {
            while (list[right] >= pivot && left < right) {
                right--;
            }

            while (list[left] <= pivot && left < right) {
                left++;
            }

            if (left < right) {
                list[right] ^= list[left];
                list[left] ^= list[right];
                list[right] ^= list[left];
            }
        }

        list[iniLeft] = list[left];
        list[left] = pivot;

        partition(list, iniLeft, left - 1);
        partition(list, right + 1, iniRight);
    }


    private void partition1(int[] input, int left, int right) {
        int iniLeft = left;
        int iniRight = right;

        if (left > right) return;
        int target = input[right];

        while (left < right) {
            // compare left with the flag, swap if flag > current.
            while (input[left] <= target && left < right) {
                left++;
            }

            if (left < right) {
                input[right] = input[left];
                right--;
            }

            // compare right with the flag, swap if flag < current.
            while (target <= input[right] && left < right) {
                right--;
            }

            if (left < right) {
                input[left] = input[right];
                left++;
            }

        }
        input[left] = target;
        partition(input, iniLeft, left - 1);
        partition(input, left + 1, iniRight);
    }

    public static void main(String[] args) {
        int[] i = {4, 3, 6, 8, 1, 3, 2};
        int[] i2 = {3, 1, 2, 5, 4, 6};
        Sorting s = new Sorting();
        s.quickSort(i);
        for (int e : i) {
            System.out.print(e + ",");
        }
    }
}


