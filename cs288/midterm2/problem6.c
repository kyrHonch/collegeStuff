#include <stdio.h>
int bitsCount(float num1, float num2)
{
    unsigned int *p1 = (unsigned int *)&num1;
    unsigned int *p2 = (unsigned int *)&num2;
    unsigned int xorResult = *p1 ^ *p2;
    int count = 0;

    /*00111111100000000000000000000000*/
    /*xorResult 010101*/
    /*010101*/
    /*000010*/
    
    /*000001*/
    /*000100*/
    /*001000*/
    /*010000*/
    /*100000*/

    for (int i = 0; i < 32; i++)
    {
        if ((xorResult & (1 << i)) == 0)
        {
            count++;
        }
    }
    return count;
}

int main()
{
    float num1, num2;
    printf("Enter two floating point numbers: ");
    scanf("%f %f", &num1, &num2);
    unsigned int xorResult = *(unsigned int *)&num1 ^ *(unsigned int *)&num2;
    
    int count=0;
    for (int i = 0; i < 32; i++){
        if((xorResult & (1 << i)) != 0){
            count++;
        }
    }
    printf("# of same bits: %d\n", 32-count);
}
