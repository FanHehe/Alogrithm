#include <stdio.h>
#include <unistd.h>

int main () {
    printf ("机器时钟滴答/秒 = %lu", sysconf(_SC_CLK_TCK));
    return 0;
}
