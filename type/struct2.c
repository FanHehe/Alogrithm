#include <stdio.h>

struct stu5 {
    short i;
    struct {
        char c;
        long j;
    } ss;
    int k;
};


int main (void) {
    printf("%lu", sizeof(struct stu5));
    return 0;
}
