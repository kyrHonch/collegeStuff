#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    int opt;
    int cflag = 0, dflag = 0, uflag = 0;
    char *fvalue = NULL;
    char *svalue = NULL;

    // The ":" at the start of the option string is for distinguishing
    // between missing option values and unknown options.
    while ((opt = getopt(argc, argv, ":cdf:s:u")) != -1) {
        switch (opt) {
            case 'c':
                cflag = 1;
                printf("Option -c is set\n");
                break;
            case 'd':
                dflag = 1;
                printf("Option -d is set\n");
                break;
            case 'u':
                uflag = 1;
                printf("Option -u is set\n");
                break;
            case 'f':
                fvalue = optarg;
                printf("Option -f with value '%s'\n", fvalue);
                break;
            case 's':
                svalue = optarg;
                printf("Option -s with value '%s'\n", svalue);
                break;
            case ':':
                printf("Option -%c requires an operand\n", optopt);
                break;
            case '?':
                printf("Unknown option: '-%c'\n", optopt);
                break;
        }
    }

    // Output the remaining command line arguments (not options).
    if (optind < argc) {
        while (optind < argc) {
            printf("Non-option argument: %s\n", argv[optind++]);
        }
    }

    return 0;
}