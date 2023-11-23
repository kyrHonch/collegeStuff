#include <stdio.h>

int main(){

    int a = -4434;
    int *b = &a;
    int **c = &b;


    printf("a: %p\n", a);
    printf("b: %d\n", b);
    printf("*b: %d\n", *b);
    printf("c: %d\n", c);
    printf("*c: %d\n", *c);
    printf("**c: %d\n", **c);


    return 0;
}