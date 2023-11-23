#include <stdio.h>
#include <stdlib.h>

#define SIZE 100
#define BUCKETS 16
#define DIGITS 8

void flipSign(int *input, int len) 
{
    for (int i = 0; i < len; i++) 
    {
        input[i] ^= (1 << (sizeof(int) * 8 - 1));
    }
}

void radixSort(int *input, int len) {
    int output[SIZE];

    flipSign(input, len);

    for (int digitIndex = 0; digitIndex < DIGITS; digitIndex++) {
        int count[BUCKETS] = {0};

        for (int index = 0; index < len; index++) {
            int temp = (input[index] >> (4 * digitIndex)) & 0xF;
            count[temp]++;
        }

        for (int index = 1; index < BUCKETS; index++) {
            count[index] += count[index - 1];
        }

        for (int index = len - 1; index >= 0; index--) {
            int temp = (input[index] >> (4 * digitIndex)) & 0xF;
            output[--count[temp]] = input[index];
        }

        for (int index = 0; index < len; index++) {
            input[index] = output[index];
        }
    }

    flipSign(input, len);
}

int main() {
    int input[SIZE], len;

    scanf("%d", &len);

    if (len > SIZE) {
        printf("Incorrect array size\n");
        return 1;
    }

    for (int index = 0; index < len; index++) {
        scanf("%d", &input[index]);
    }

    radixSort(input, len);

    printf("Sorted:\n");
    for (int index = 0; index < len; index++) {
        printf("%d\n", input[index]);
    }

    return 0;
}
