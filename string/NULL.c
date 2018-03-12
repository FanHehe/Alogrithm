#include <stdio.h>
#include <string.h>

void strchrTest () {
    const char* str = "www.fanhehe.com";

    char* pointer = strchr(str, '.');

    printf("%ld \n", str - pointer);
}


int main (void) {


    strchrTest();


    char* n = 0;
    const char* str = "www.fanhehe.com";
    printf("%d \n", NULL == (void*)0);
    printf("%d", NULL == strstr(str, "net"));
}
