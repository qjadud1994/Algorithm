#include <stdio.h>
#include <string.h>
#include <math.h>
int Resist(char *color) {
	if (strcmp(color, "black") == 0) return 0;
	else if (strcmp(color, "brown") == 0) return 1;
	else if (strcmp(color, "red") == 0) return 2;
	else if (strcmp(color, "orange") == 0) return 3;
	else if (strcmp(color, "yellow") == 0) return 4;
	else if (strcmp(color, "green") == 0) return 5;
	else if (strcmp(color, "blue") == 0) return 6;
	else if (strcmp(color, "violet") == 0) return 7;
	else if (strcmp(color, "grey") == 0) return 8;
	else if (strcmp(color, "white") == 0) return 9;
}

int main() {
	long long result = 0;
	char color[10];
	scanf("%s", color);
	result += Resist(color) * 10;
	scanf("%s", color);
	result += Resist(color);
	scanf("%s", color);
	result *= pow(10, Resist(color));
	printf("%lld", result);
}