/* File: a4q4.c
Author: Firstname Lastname, Banner_number
Date: Oct 20, 2017
Purpose: Solution to problem A4Q4 of CSCI2132
Description: The program prints binary representation for integers
*/
#include <stdio.h>
#include <stdlib.h>
int main(){
	//the maximum support 100 integers
	int numbers[100];
	//in order to store each integer
	char number[10];
	//how many input integers 
	int index=0;
	//start to get input integers from stdin
	while(fgets(number,10,stdin)!=NULL){
		int num = atoi(number);
		numbers[index]=num;
		index++;
	}
	//start to convert each integer to binary format
	for(int i=0;i<index;i++){
		printf("%10d:",numbers[i]);
		unsigned int x=numbers[i];
		//need a format with 32 bits 
		for(int j=31;j>=0;j--){
			//The bitwise AND operator & working  on the bits of the operands 
			//the left shift operator can shift each bit in its left-hand operand to the left
			//after the below loop, get the binary value
			int b=(x>>j&1);
			//grouped in groups of 8 (per byte)
			if(((j+1)%8)==0) printf(" ");
			printf("%d",b);
		}
		printf("\n");
	}
    return 0;
}
