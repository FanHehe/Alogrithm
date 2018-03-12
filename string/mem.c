#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main ()
{
    char str[] = "memmove can be very useful......";
    memcpy (str+20,str+15,11);
    puts (str);
    system("pause");
    return 0;
}
