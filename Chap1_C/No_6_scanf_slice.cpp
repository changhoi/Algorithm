#include <stdio.h>

// Baekjoon 11721번 문제
// scanf("%10s") 사용해서 원하는 길이만큼 문자열 입력받기

int main() {
    char s[11];
    while (scanf("%10s", s) == 1) {
        printf("%s\n", s);
    }
}