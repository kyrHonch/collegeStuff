#include <stdio.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>

#define MAX_PATH_LENGTH 1000

int count_lines_in_file(const char *filename) {
    int count = 0;
    char ch;
    FILE *file = fopen(filename, "r");
    if (file == NULL) return 0;

    while ((ch = fgetc(file)) != EOF) {
        if (ch == '\n') {
            count++;
        }
    }

    fclose(file);
    return count;
}

int traverse_directory(const char *directory) {
    struct dirent *dp;
    DIR *dir = opendir(directory);
    int total_lines = 0;

    if (!dir) return 0;

    while ((dp = readdir(dir)) != NULL) {
        if (strcmp(dp->d_name, ".") != 0 && strcmp(dp->d_name, "..") != 0) {
            char path[MAX_PATH_LENGTH];
            snprintf(path, MAX_PATH_LENGTH, "%s/%s", directory, dp->d_name);

            if (opendir(path))
                total_lines += traverse_directory(path);
            else if (strstr(dp->d_name, ".txt"))
                total_lines += count_lines_in_file(path);
        }
    }

    closedir(dir);
    return total_lines;
}

int main() {
    char directory_path[MAX_PATH_LENGTH];
    printf("Directory: ");
    scanf("%s", directory_path);

    int total_lines = traverse_directory(directory_path);
    printf("Total number of lines in all files: %d\n", total_lines);
    return 0;
}
