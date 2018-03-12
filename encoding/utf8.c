#include <stdio.h>
#include <string.h>

int main () {
    char* str = "严";

    for (int i = 0, len = strlen(str); i < len; i++) {
        printf("%x\n", str[i]);
    }

    FILE* fp = fopen("tmp", "w");

    fwrite(str, strlen(str), 1, fp);

    fclose(fp);
    return 0;
}
