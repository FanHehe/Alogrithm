#include <stdio.h>

int main () {

    char str[100];

    FILE* fp = fopen("assets/chinese.txt", "r");


    while(!feof(fp)) {
        int ch = fgetc(fp);
        fputc(ch, stdout);
    }

    return 0;
}
