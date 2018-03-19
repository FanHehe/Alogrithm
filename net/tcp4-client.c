#include <unistd.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>

#define BUFFER_MAX 4096

void str_cli(FILE*, int);

int main (int argc, char** argv) {

    int sock = socket(AF_INET, SOCK_STREAM, 0);

    struct sockaddr_in target;

    memset(&target, 0, sizeof(target));

    target.sin_family = AF_INET;
    target.sin_port = htons(8093);
    inet_pton(AF_INET, argv[1], &target.sin_addr.s_addr);

    connect(sock, (struct sockaddr*) &target, sizeof(target));

    str_cli(stdin, sock);
}

void str_cli (FILE* in, int sock) {

    char buffer_send[BUFFER_MAX];
    char buffer_recv[BUFFER_MAX];

    while (fgets(buffer_send, BUFFER_MAX, in) != NULL) {
        write(sock, buffer_send, strlen(buffer_send));

        if (read(sock, buffer_recv, BUFFER_MAX) != 0) {
            fputs(buffer_recv, stdout);
        }
    }
}
