#include <stdio.h>
// Baekjoon 11718, scanf���� ���ڿ� �Է¹��� �� %[] ����غ���
int main() {
    char s[111];
    while (scanf("%[^\n]\n", s)==1) {
        printf("%s\n", s);
    }
    return 0;
}