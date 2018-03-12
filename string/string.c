#include <stdio.h>
#include <string.h>


void strchrTest () {

   const char* str = "www.fanhehe.com";

   char* ret = strchr(str, '.');

   printf("'%c'之后的字符串是%s\n", '.', ret);

}


void strcatTest () {


    char src[30] = "www.fanhehe.com";

    char* dest = strcat(src, " click here");

    printf("%s ,sizeof(dest) = %lu\n", dest, strlen(dest));

}


void strcmpTest () {
    char* src = "wxw.fanhehe.com";
    char* srd = "wyw.fanhehe.com";


    printf("%d \n", strcmp(src, srd));
}

void strcpyTest () {
    char dest[30];
    char* src = "www.fanhehe.com";

    char* temp = strcpy(dest, src);

    printf("%s \n", temp);
}

void strcspnTest () {
    char* str = "www.fanhehe.com";
    char* test = "xyza";


    printf("strcspn: %lu \n", strcspn(str, test));
}

void strspnTest () {
    char* str = "xww.fanhehe.com";
    char* test = "xyza";


    printf("strspn: %lu \n", strspn(str, test));
}


void strstrTest () {

    char* str = "www.fanhehe.com";
    char* test = "fanhehe";

    char* temp = strstr(str, test);

    printf("%s \n", temp);

}

void strtokTest () { // 垃圾 不用
    char str[100] = "api.vip.fanhehe.com";
    char* delim = ".";

    char *token = strtok(str, delim);

    while (token != NULL) {
        printf("%s \n", token);

        token = strtok(NULL, str);
    }
}

int main () {

    strchrTest(); // char* subchr(const char* str, int c)

    strcatTest(); // char* strcat(char* dest, char* src) || strncat(char* dest, char* src, size_t n)

    strcmpTest(); // int strcmp (char* str, char* sts);

    strcpyTest();

    strcspnTest(); // size_t strcspn(const char* str1, const char* str2); // 检测str1 从头开始，不含str2中字符的字符个数

    strspnTest();  // size_t strspn(const char* str1, const char* str2);  // 检测str1 从头开始, 第一个不在字符串str2中出现的字符下标

    strstrTest();

    strtokTest(); // 垃圾不用
}
