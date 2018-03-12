#include <string.h>
#include <stdio.h>
#include <time.h>

/**
 * struct tm {
 *      int tm_sec; // [0, 59]
 *      int tm_min; // [0, 59]
 *      int tm_hour; // [0, 23]
 *
 *      int tm_wday;  // [0, 6]  一周的第几天
 *      int tm_mday;  // [1, 31] 一个月的第几天
 *      int tm_yday;  // [0,365] 一个年的第几天
 *
 *      int tm_mon;   // [0, 11] 月份
 *      int tm_year;  // [1990, +] 从1990年起的年份
 *
 *      int tm_isdst;  // 夏令时
 *
 * }
 */



int main (void) {

    clock_t start = clock();
    time_t now = time(NULL); // 获取当前时间戳


    struct tm tim;

    memset(&tim, 0, sizeof(tim));

    tim.tm_year = 2018 - 1900;
    tim.tm_mday = 1;

    time_t tim_time = mktime(&tim);

    char str[80];
    strftime(str, sizeof(str), "%Y-%m-%d %H:%M:%S ", &tim);

    printf("%s", str);

    return 0;

}
