#include <stdio.h>

//BaekJoon 10951번 scanf의 리턴값 사용하기

int main() {
    int x, y;
    while (scanf("%i %i", &x, &y) == 2) {
        printf("%d\n", x + y);
    }
}