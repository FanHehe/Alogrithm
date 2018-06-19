#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "my-stdio.h"


void heap_sort (int* p, int n) {

	for (int i = n / 2; i > 0; i--) {
		heap_adjust(p, i, n);
	}

}



int main () {

	int n = 9;
	int *p =(int*)malloc(sizeof(int) * n);

	p = input(p, n);
	heap_sort(p, 0, n);
	output(p, n);
	free(p);

	return 0;
}