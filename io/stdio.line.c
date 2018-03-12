#include <stdio.h>
#include <string.h>

int main () {
    char str[8];

    fgets(str, 8, stdin);

    fputs(str, stdout);
    puts(str);
    return 0;
}
