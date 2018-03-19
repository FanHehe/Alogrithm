#ifndef MY_STDIO_H
#define MY_STDIO_H

#include <stdio.h>
#include <stdlib.h>

int* input (int* p, int n) {

	for (int i = 0; i < n; i++) {
		scanf("%d", p + i);
	}

	return p;
}

void output (int* p, int n) {
	for (int i = 0; i < n; i++) {
		printf("%d ", *(p + i));
	}
	printf("\n");
}

#endif