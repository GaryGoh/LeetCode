package Practice;

public class FindKthElement {

    public int findKthElement(int[] list, int k) {
        return selectionAgorithm(list, 0, list.length - 1, k);
    }

    private int selectionAgorithm(int[] list, int left, int right, int k) {
        while (true) {
            int pivot = partition(list, left, right);
            int len = pivot - left + 1;

            if (k == len) {
                return list[pivot];
            }
            else if (k < len) {
                right = pivot - 1;
            }
            else {
                k = k - len;
                left = pivot + 1;
            }
        }
    }
    private int partition(int[] list, int left, int right) {
        int m = left - 1;
        int p = list[right];
        for (int i = left; i < right; i ++) {
            if (list[i] <= p) {
                m ++;
                swap(list, i, m);
            }
        }
        swap(list, right, m + 1);
        return m + 1;
    }

    private void swap(int[] list, int a, int b) {
        int tmp = list[b];
        list[b] = list[a];
        list[a] = tmp;
    }

    public static void main(String[] args) {
        FindKthElement f = new FindKthElement();
        int[] i = {0, 4, 2};
        int res = f.findKthElement(i, 2);
        System.out.println(res);
    }
}
