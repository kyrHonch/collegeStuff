#include <stdio.h>
#define MAX_SIZE 100

int readFile(const char* filename, int matrix[MAX_SIZE][MAX_SIZE]) {
    FILE* file = fopen(filename, "rb");
    if (!file) return -1;

    int n;

    fread(&n, sizeof(int), 1, file);
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
            fread(&matrix[x][y], sizeof(int), 1, file);
        }
    }
    fclose(file);
    return n;
}

int writeFile(const char* filename, int n, int matrix[MAX_SIZE][MAX_SIZE]) {
    FILE* file = fopen(filename, "wb");
    if (!file) return -1;

    fwrite(&n, sizeof(int), 1, file);
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
            fwrite(&matrix[x][y], sizeof(int), 1, file);
        }
    }
    fclose(file);
    return 0;
}



void multiplyMatrices(int n, int matrix1[MAX_SIZE][MAX_SIZE], int matrix2[MAX_SIZE][MAX_SIZE], int result[MAX_SIZE][MAX_SIZE]) {
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
            result[x][y] = 0;
            for (int k = 0; k < n; k++) {
                result[x][y] += (int)matrix1[x][k] * matrix2[k][y];
            }
        }
    }
}




int main() {
    int matrix1[MAX_SIZE][MAX_SIZE], matrix2[MAX_SIZE][MAX_SIZE], resultMatrix[MAX_SIZE][MAX_SIZE], n1, n2;

    n1 = readFile("matrix1.bin", matrix1);
    n2 = readFile("matrix2.bin", matrix2);
    if(n1 == -1) {
        printf("No matrix1.bin\n");
        return 1;
    } else if(n2 == -1) {
        printf("No matrix2.bin\n");
        return 1;
    } else if (n1 != n2) {
        printf("Mismatching matrix sizes.\n");
        return 1;
    } else if (n1 > MAX_SIZE || n2 > MAX_SIZE) {
        printf("The matrix size is too large.\n");
        return 1;
    }

    multiplyMatrices(n1, matrix1, matrix2, resultMatrix);

    return writeFile("result.bin", n1, resultMatrix);
}
