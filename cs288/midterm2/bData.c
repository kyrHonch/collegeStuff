#include <stdio.h>
#include <stdlib.h>

int main(){
   int i[20], value, j;
   float f[20];

   value = -10;
   for( j = 0; j < 20; j++) {
      i[j] = value;
      f[j] = value;
      value = value + 1;
   }
   printf("Examine memory now.\n");
}
