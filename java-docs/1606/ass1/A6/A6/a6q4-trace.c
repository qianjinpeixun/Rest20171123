/* Program: a6q4-trace.c Author: Vlado Keselj */
#include <stdio.h>

void quicksort(int *lo, int *hi);
int* partition(int *lo, int *hi);

int main() {
  int n;

  scanf("%d", &n);
  if (n > 0) {
    int a[n], i;
    for (i=0; i<n; i++)
      scanf("%d", &a[i]);

    quicksort(a, a+n-1);

    for (i=0; i<n; i++)
      printf("%d\n", a[i]);

    return 0;
  }
  else
    return 1;
}

void quicksort(int *lo, int *hi) {
  if (lo < hi) {
    int *p, *q;

    printf("PARTITION  IN:");
    for(q=lo; q<=hi; q++)
      printf(" %2d", *q);
    putchar('\n');

    p = partition(lo, hi);

    printf("PARTITION OUT:");
    for(q=lo; q<=hi; q++)
      printf("%c%2d", q==p ? '*' : ' ', *q);
    putchar('\n');

    quicksort(lo, p);
    quicksort(p+1, hi);
  }
}
