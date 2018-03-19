#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>

void str_echo(int);

int main () {

    int sock = socket(AF_INET, SOCK_STREAM, 0);

    pid_t childFd = 0;

    struct sockaddr_in bindAddr;
    struct sockaddr_in clientAddr;

    memset(&bindAddr, 0, sizeof(bindAddr));

    bindAddr.sin_family = AF_INET;
    bindAddr.sin_addr.s_addr = htonl(INADDR_ANY);
    bindAddr.sin_port = htons(8093);

    bind(sock, (struct sockaddr*)&bindAddr, sizeof(bindAddr));

    listen(sock, 5);

    while (1) {
        socklen_t clientLength = sizeof(clientAddr);
        int clientSock = accept(sock, (struct sockaddr*) &clientAddr, &clientLength);

        if ((childFd = fork()) == 0) {
            close(sock);
            str_echo(clientSock);
            close(clientSock);
            exit(0);
        }
        close(clientSock);
    }
}


void str_echo (int sock) {
    write(sock, "hehe", sizeof("hehe"));
}
