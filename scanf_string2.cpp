#include <stdio.h>

//Baekjoon 11719번 문제 공백을 포함한 문자열을 받고 그대로 출력하기
// getchar()을 통해 한 글자씩 입력받고 입력받은 값을 그대로 출력함
int main() {
    char c;
    while ((c = getchar()) && c != EOF) {
        printf("%c", c);
    }
}