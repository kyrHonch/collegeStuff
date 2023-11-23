#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

#define SIZEPTR sizeof(char*)
#define ALIGN 8

void hexReverse(unsigned char *p, int size) 
{
    for (int i = size - 1; i >= 0; i--) 
    {
        printf("%02hhx ", *(p + i));
    }
}

void memory(unsigned char *start, unsigned char *end) 
{
    for (unsigned char *p = start; p < end; p += ALIGN) 
    {
        printf("        |");
        for (int i = 0; i < ALIGN; i++) 
        {
            printf("%02hhx(%c) ", p[i], isprint(p[i]) ? p[i] : '.');
        }
        printf("|%p\n", p);
    }
}

int main(int argc, char *argv[]) 
{
    unsigned char *p = (unsigned char *)&argv;

    printf("argv    | ");
    hexReverse(p, SIZEPTR);
    printf("|%p\n\n", p);

    for (int i = 0; i < argc; i++) 
    {
        printf("argv[%d] | ", i);
        p = (unsigned char *)(argv + i);
        hexReverse(p, SIZEPTR);
        printf("|%p\n", p);
    }
    printf("\n");

    unsigned char *start = (unsigned char *)(((size_t)argv[0]) & ~(ALIGN - 1));
    unsigned char *end = (unsigned char *)(((size_t)argv[argc - 1] + strlen(argv[argc - 1]) + ALIGN) & ~(ALIGN - 1));

    memory(start, end);

    return 0;
}