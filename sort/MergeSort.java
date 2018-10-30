public class MergeSort {
        public void mergeSort(int[] array, int from, int to) {
        int mid = (from + to) / 2;

        if (from < to) {
            mergeSort(array, from, mid);
            mergeSort(array, mid + 1, to);
            merge(array, from, mid, to);
        }
    }

    public int[] merge(int[] array, int from, int mid, int to) {
        int i = from;
        int j = mid + 1;
        int k = 0;
        int[] result = new int[to - from + 1];

        while (i <= mid && j <= to) {
            if (array[i] <= array[j]) {
                result[k++] = array[i++];
            } else {
                result[k++] = array[j++];
            }
        }

        while(i <= mid) {
            result[k++] = array[i++];
        }

        while(j <= to) {
            result[k++] = array[j++];
        }

        for (int x = from; x <= to; x++) {
            array[x] = result[x - from];
        }

        return result;
    }

    public int[] merge(int[] one, int[] another) {

        int[] result = new int[one.length + another.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < one.length && j < another.length) {
            if (one[i] <= another[j]) {
                result[k++] = one[i++];
            } else {
                result[k++] = another[j++];
            }
        }

        while(i < one.length) {
            result[k++] = one[i++];
        }

        while(j < another.length) {
            result[k++] = another[j++];
        }

        Arrays.stream(result).forEach(System.out::print);

        return result;
    }
}
