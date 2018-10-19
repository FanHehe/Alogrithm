#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* str1 = "abcdefghij";
char* str2 = "ABCDEFGHIJ";

int main () {

    char* str2k = (char*)malloc(sizeof(char) * 20480);

    memset(str2k, '1', 20480);

    int fd  = open("../tmp/hole", O_RDWR | O_CREAT | O_TRUNC, 0664);
    int fd2 = open("../tmp/nohole", O_RDWR | O_CREAT | O_TRUNC, 0664);


    int n = write(fd2, str2k, 20480);

    printf("write %d", n);

    if (fd < 0) puts("file open error \n");

    if (write(fd, str1, strlen(str1)) < strlen(str1)) puts("write1 error \n");

    if (lseek(fd,20480, SEEK_SET) == -1) puts("lseek error"); // 一定要测试它是否等于-1

    if (write(fd, str2, strlen(str2)) < strlen(str2)) puts("write2 error \n");

    if (fd) close(fd);
    return 0;
}


int name () {
    FILE* a = fopen("./assets/chinese.txt");
    fclose(a);
}
