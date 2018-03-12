#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void printCwd () {
    char * cwd = getcwd(NULL, 0);
    if (cwd) printf("%s \n", cwd);
    free(cwd);
}


int main () {

    int pid = getpid();

    printCwd();

    int tmp_one = creat("../tmp/test", 0644);

    if (tmp_one < 0) printf("tmp_one error \n");

    int tmp_two = open("../tmp/test2", O_RDWR | O_CREAT | O_TRUNC, 0644);

    if (tmp_two < 0) printf("tmp_two error \n");

    if (tmp_two) close(tmp_two);

    return 0;
}
