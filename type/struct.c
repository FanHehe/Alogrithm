#include <stdio.h>

struct stu2 {
    int k;
    long f;
    short t[10];
};

int main () {
    printf("struct {int, short} size: %lu", sizeof(struct stu2));
    return 0;
}
