#include<stdio.h>
#include<stdlib.h>

#define LENGTH 9

void floyd (double** matrix, int length) {
    for (int k = 0; k < length; k++) {
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j ++) {
               if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                   matrix[i][j] = matrix[i][k] + matrix[k][j];
               }
            }
        }
    }
}

int main () {
    double** matrix = NULL;

    matrix = (double**)malloc(LENGTH * sizeof(double*));

    for (int i = 0; i < LENGTH; i++) {
        matrix[i] = (double*)malloc(LENGTH * sizeof(double));
    }

    
    for (int i = 0; i < LENGTH; i++) {
        for (int j = 0; j < LENGTH; j++) {
            matrix[i][j] = i == j ? 0 : 100000000000.0;
        }
    }


    matrix[0][1] = matrix[1][0] = 1;
    matrix[0][2] = matrix[2][0] = 5;
    matrix[1][2] = matrix[2][1] = 3;
    matrix[1][3] = matrix[3][1] = 7;
    matrix[1][4] = matrix[4][1] = 5;
    matrix[2][4] = matrix[4][2] = 1;
    matrix[2][5] = matrix[5][2] = 7;
    matrix[3][4] = matrix[4][3] = 2;
    matrix[3][6] = matrix[6][3] = 3;
    matrix[4][5] = matrix[5][4] = 3;
    matrix[4][6] = matrix[6][4] = 6;
    matrix[4][7] = matrix[7][4] = 9;
    matrix[5][7] = matrix[7][5] = 5;
    matrix[6][7] = matrix[7][6] = 2;
    matrix[6][8] = matrix[8][6] = 7;
    matrix[7][8] = matrix[8][7] = 4;

    floyd(matrix, LENGTH);

    for (int i = 0; i < LENGTH; i++) {
        for (int j = 0; j < LENGTH; j++) {
            printf("%.1f ", matrix[i][j]);
        }
        printf("\n");
    }

    printf("\n");

    return 0;

}
