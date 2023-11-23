#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Function to swap the pointers of two strings
void swap(char **a, char **b) {
    char *temp = *a;
    *a = *b;
    *b = temp;
}

// Function to sort the environment variables
void sort_env(char **envp) {
    int i, j;
    char *name1, *name2, *temp;
    for (i = 0; envp[i] != NULL; i++) {
        for (j = 0; envp[j + 1] != NULL; j++) {
            name1 = strdup(envp[j]);
            name2 = strdup(envp[j + 1]);

            // Split the strings on '=' to get the names
            strtok(name1, "=");
            strtok(name2, "=");

            // Compare and swap if out of order
            if (strcmp(name1, name2) > 0) {
                swap(&envp[j], &envp[j + 1]);
            }

            // Free the duplicated strings
            free(name1);
            free(name2);
        }
    }
}

// Main function
int main(int argc, char **argv, char **envp) {
    // Sort the environment variables
    sort_env(envp);

    // Print the sorted environment variables
    for (int i = 0; envp[i] != NULL; i++) {
        printf("%s\n", envp[i]);
    }

    return 0;
}