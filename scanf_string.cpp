#include <stdio.h>
// Baekjoon 11718, scanf에서 문자열 입력받을 때 %[] 사용해보기
int main() {
    char s[111];
    while (scanf("%[^\n]\n", s)==1) {
        printf("%s\n", s);
    }
    return 0;
}