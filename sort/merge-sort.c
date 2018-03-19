#include <stdio.h>
#include <stdlib.h>
#include "my-stdio.h"

void mergeSort (int*, int ,int ,int);

void merge_sort (int* p, int start, int end) {
	if (start < end) {
		int i = (start + end) / 2;

		merge_sort(p, start, i);
		merge_sort(p, i + 1, end); 
		mergeSort(p, start, i, end);
	}
}

void mergeSort (int* p, int start, int pivot, int end) {

	int* temp = (int*)malloc(sizeof(int) * (end - start + 1));

	for (int i = start, j = pivot + 1, k = 0; k < end - start + 1; k++) {
		if (i == pivot + 1) {
			temp[k] = p[j++];
			continue;
		}

		if (j == end + 1) {
			temp[k] = p[i++];
			continue;
		}

		if (p[i] <= p[j]) {
			temp[k] = p[i++];
			continue;
		}

		else  {
			temp[k] = p[j++];
			continue;
		}
	}

	for (int m = 0; m < end - start  + 1; m++) {
		p[start + m] = temp[m];
	}

	free(temp);
}

int main () {

	int n = 8;
	int *p =(int*)malloc(sizeof(int) * n);

	p = input(p, n);
	merge_sort(p, 0, n - 1);
	output(p, n);
	free(p);

	return 0;
}