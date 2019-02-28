#include <stdio.h>

// Baekjoon 11720
// scanf("%1d") 사용해보기, (원하는 숫자 길이만큼 입력받기)
int main() {
    int sum = 0, test_case, val;
    scanf("%d", &test_case);
    for (int i = 0; i < test_case; i++) {
        scanf("%1d", &val);
        sum += val;
    }
    printf("%d", sum);
        
    return 0;
}