var array = new int[] {1,-1,2,3,5,7,9,8,6,0,4};

Arrays.stream(array).forEach(System.out::print);
// 冒泡排序
void bubbleSort (int[] array) {
	for (int i = 0, length = array.length; i < length; i++) {
		for (int j = i + 1; j < length; j ++) {
			if (array[i] > array[j])
			{
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}

	Arrays.stream(array).forEach(System.out::print);
}

// 单次快排
int quick (int[] array, int start, int end) {

	int povit = end;
	int i = start, j = end;
	int temp = array[end];

	while (i < j) {

		while (i < j && array[i] < temp) i++;
		array[povit] = array[i];
		povit = i;

		while (i < j && array[j] > temp) j--;
		array[povit] = array[j];
		povit = j;
	}

	array[povit] = temp;
	// Arrays.stream(array).forEach(System.out::print);
	return povit;
}

// 快排
void quickSort (int[] array, int start, int end) {
	if (start < end) {
		int povit = quick(array, start, end);

		quickSort(array, start, povit - 1);
		quickSort(array, povit + 1, end);
	}
}

// 插排
void insertSort (int[] array) {
	for (int i = 1, len = array.length; i < len; i++) {
		int j = i - 1;
		int temp = array[i];

		while (j >= 0 && array[j] > temp) {
			array[j + 1] = array[j];
			j--;
		}

		array[j + 1] = temp;

	}

	Arrays.stream(array).forEach(System.out::print);
}

// 希尔排序
void shellSort (int[] array) {

	int length = array.length;
	int povit  = length / 2;

	for (int i = povit; i >= 1; i /= 2) {

		for (int j = i; j < length; j += i) {

			int k = j - i;
			int temp = array[j];

			for (; k >= 0 && array[k] > temp; k -= i) {
				array[k + i] = array[k];
			}

			array[k + i] = temp;
		}
	}

	Arrays.stream(array).forEach(System.out::print);
}

// 选排
void selectSort (int[] array) {

	for (int i = 0, length = array.length; i < length; i++) {

		int position = i;

		for (int j = i + 1; j < length; j++) {
			if (array[position] > array[j]) position = j;
		}

		if (position != i) {
			int temp = array[i];
			array[i] = array[position];
			array[position] = temp;
		}

	}

	Arrays.stream(array).forEach(System.out::print);
}

// 单分支整堆
void build (int[] array, int start, int end, int index) {
	int temp = 0;
	int left = 2 * index + 1;
	int right = 2 * index + 2;

	if (left > end) return ;

	int minIndex = right > end ? left : ((array[left] > array[right]) ? right : left);

	if (array[minIndex] < array[index]) {
		temp = array[minIndex];
		array[minIndex] = array[index];
		array[index] = temp;
		build(array, start, end, minIndex);
	}
}

// 建堆
void buildHeap(int[] array, int start, int end) {
	for (int i = (end - start - 1) / 2; i >=0; i--) {
		build(array, start, end, i);
	}
}

// 堆排
void heapSort(int[] array) {
	int temp = 0;
	for (int i = array.length - 1; i >= 0; i--) {
		buildHeap(array, 0, i);
		temp = array[0];
		array[0] = array[i];
		array[i] = temp;
	}
}

// 一次合并
void merge (int[] array, int start, int center, int end) {
	int k = 0;
	int i = start;
	int j = center + 1;

	int temp[] = new int[end - start + 1];

	while (i <= center && j <= end) {
		while (i <= center && array[i] <= array[j])
		{
			temp[k++] = array[i++];
		}
		while (j <= end && array[i] > array[j])
		{
			temp[k++] = array[j++];
		}
	}

	while (i <= center) temp[k++] = array[i++];
	while (j <= end) temp[k++] = array[j++];

	for(int n = 0; n < temp.length; n++) {
		array[start + n] = temp[n];
	}

	return;
}

// 归并排序
void mergeSort (int[] array, int start, int end) {
	if (start < end) {
		int center = (start + end) / 2;

		mergeSort(array, start, center);
		mergeSort(array, center + 1, end);

		merge(array, start, center, end);
	}
}

<T extends Comparable<T>> int binarySearch(T[] array, T value) {

    int left = 0;
    int right = array.length - 1;

    while (left <= right) {

        int mid = (left + right) >>> 1;

        if (value.compareTo(array[mid]) < 0) {
            right = mid - 1;
        } else if (value.compareTo(array[mid]) > 0) {
            left = mid + 1;
        } else {
            return mid;
        }
    }

    return - (left + 1);
}
