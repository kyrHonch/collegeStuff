#include <stdio.h>

void hello(int, int);

int main(){

    hello(1,2);
    return 0;
}

void hello(int a, int b){
    int c = a + b;
    printf("%d", c);

    return;
}