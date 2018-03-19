#include <stdio.h>
#include <stdlib.h>
#include "my-stdio.h"

void insertion_sort (int* p, int n) {
	int j = 0;
	int temp = -1;
	for (int i = 1; i < n; i ++) {
		j = i;
		temp = *(p + j);
		while (j >= 1 && p[j - 1] > temp) {
			 p[j] = p[j - 1];
			 j--;
		}
		p[j] = temp;
	}
}

int main () {

	int n = 8;
	int *p =(int*)malloc(sizeof(int) * n);

	p = input(p, n);
	insertion_sort(p, n);
	output(p, n);
	free(p);

	return 0;
}