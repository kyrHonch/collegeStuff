#include <stdio.h>

int main(){

    int num;

    scanf("%d", &num);
    printf("%d\n", (num << 2));

    printf("%d\n", num);
    if(num & 1){
        printf("LSB is 1\n");
    }else{
        printf("LSB is 0\n");
    }
    return 0;
}