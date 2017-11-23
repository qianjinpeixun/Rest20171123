/* Program: a6q4-main.c Author: Vlado Keselj */
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
    int *p = partition(lo, hi);
    quicksort(lo, p);
    quicksort(p+1, hi);
  }
}
