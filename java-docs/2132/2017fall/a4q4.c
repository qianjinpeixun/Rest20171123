//
//  a4q4.c
//  
//
//  Created by Vax on 2017-10-19.
//
#include <stdio.h>
int main(){
    int input,i,j,k,m=0,n=0,a[32][32],b[32];
    while(!EOF){
        scanf("%d",&input);
        b[m]=input;
        for(n=31;n>=0;n--){
            while(input!=0){
                j=input%2;
                a[m][n]=j;
                input=input/2;
                n++;
            }
            a[m][n]=0;
        }
        m++;
    }
    
    for(j=0;j<32;j++){
        printf("10%d: ",b[j]);
        for(k=31;k>=0;k--){
            if (k==23||k==15||k==7) {
                printf(" ");
            }
            printf("%d ",a[j][k]);
        }
        printf("\n");
    }
    return 0;
}
