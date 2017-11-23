/* File: a5q3.c
Author: Firstname Lastname, Banner_number
Date: Oct 27, 2017
Purpose: Solution to problem A5Q3 of CSCI2132
Description: The program removes adjacent duplicates from a list of integers
*/
#include <stdio.h>
int main(){
	int num=0;
	int pre=-1;
	int flag=0;
	//start to get input integers from stdin
	while(scanf("%d", &num) != EOF){
		//The first number do not check
		if(flag==0){
			printf("%d\n",num);
			pre=num;
			flag=1;
		}else{// otherwise, check if the same with previous number
			if(num!=pre){
				printf("%d\n",num);
				pre=num;
			}
		}
	}
	return 0;
}
