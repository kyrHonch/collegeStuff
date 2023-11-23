#include <stdio.h>
#include <stdlib.h>

#define SIZE 100
#define BUCKETS 16
#define DIGITS 8

void countSort(unsigned int *input, int len, int num) {
    int count[BUCKETS] = {0};
    unsigned int *output = malloc(len * sizeof(unsigned int));

    for (int i = 0; i < len; i++) {
        int index = (input[i] >> num) & 0xF;
        count[index]++;
    }

    for (int i = 1; i < BUCKETS; i++) {
        count[i] += count[i - 1];
    }

    for (int i = len - 1; i >= 0; i--) {
        int index = (input[i] >> num) & 0xF;
        output[count[index] - 1] = input[i];
        count[index]--;
    }

    for (int i = 0; i < len; i++) {
        input[i] = output[i];
    }

    free(output);
}

void radixSort(unsigned int *input, int len) {
    for (int i = 0; i < DIGITS; i++) {
        countSort(input, len, i * 4);
    }
}

int main() {
    unsigned int input[SIZE];
    int len;
    scanf("%d", &len);

    if (len > SIZE) {
        printf("Incorrect array size\n");
        return 1;
    }

    for (int i = 0; i < len; i++) {
        scanf("%u", &input[i]);
    }

    radixSort(input, len);

    printf("Sorted:\n");
    for (int i = 0; i < len; i++) {
        printf("%u\n", input[i]);
    }

    return 0;
}
