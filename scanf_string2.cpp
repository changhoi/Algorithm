#include <stdio.h>

//Baekjoon 11719�� ���� ������ ������ ���ڿ��� �ް� �״�� ����ϱ�
// getchar()�� ���� �� ���ھ� �Է¹ް� �Է¹��� ���� �״�� �����
int main() {
    char c;
    while ((c = getchar()) && c != EOF) {
        printf("%c", c);
    }
}