#include <stdio.h>
int main()
{
    printf("Sum = %d",addNumbers(3));
}
int addNumbers(int n)
{
        if(n!=0)        return n + addNumbers(n-1);
        else return n;
}