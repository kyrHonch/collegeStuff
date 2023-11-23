#include <stdio.h>

int sameNumber(float num1, float num2)
{

    unsigned int *ptr1 = (unsigned int *)&num1;
    unsigned int *ptr2 = (unsigned int *)&num2;

    unsigned int xORfinal = *ptr1 ^ *ptr2;

    int count = 0;

    for (int i = 0; i < 32; i++)
    {
        if ((xORfinal & (1 << i)) != 0)
        {
            count++;
        }
    }
    return count;
}

int main()
{
    float num1, num2;

    scanf("%f %f", &num1, &num2);

    printf("# of same bits: %d", sameNumber(num1, num2));
    return 0;
}
