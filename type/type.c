#include <stdio.h>

void getType () {
    printf("sizeof(char): %lu \n", sizeof(char));
    printf("sizeof(short): %lu \n", sizeof(short));
    printf("sizeof(int): %lu \n", sizeof(int));
    printf("sizeof(long): %lu \n", sizeof(long));
    //    printf("sizeof(long char): %lu \n", sizeof(long char));
    //    printf("sizeof(long short): %lu \n", sizeof(long short));
    printf("sizeof(long int): %lu \n", sizeof(long int));
    printf("sizeof(long long): %lu \n", sizeof(long long));
    //    printf("sizeof(long long long): %lu \n", sizeof(long long long));

    printf("sizeof(float): %lu \n", sizeof(float));
    printf("sizeof(double): %lu \n", sizeof(double));
    //    printf("sizeof(long float): %lu \n", sizeof(long float));
    printf("sizeof(long double): %lu \n", sizeof(long double));
}


int main (void) {
    getType();
    return 0;
}
