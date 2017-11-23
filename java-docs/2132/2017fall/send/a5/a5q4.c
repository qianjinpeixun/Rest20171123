/* File: a5q4.c
Author: Firstname Lastname, Banner_number
Date: Oct 27, 2017
Purpose: Solution to problem A5Q4 of CSCI2132
Description: The program calculates the counts and frequencies
*/
#include <stdio.h>
int main(){
	
	char c;
	int arr[27];
	int i=0;
	int index=0;
	for(i=0;i<27;i++){
		arr[i]=0;
	}
	while( (c = getc(stdin)) != EOF){
		if(c>=65 && c<=90){
			c=c+32;
		}
		if(c>=97&& c<=122){
			index=c-97;
			//printf("arr[%d]=%c=%d\n",index,c,arr[index]);
			arr[index]=arr[index]+1;
		}
		if(c==32){
			arr[26]=arr[26]+1;
		}
	}
	
	int total=0;
	for(i=0;i<27;i++){
		total=(total+arr[i]);
	}
	if(total==0) return 0;
	float f=0.0;
	printf("Letter occurences freq.\n-------------------------\n");
	f=((float)arr[26]/total)*100;
	printf("   _%9d%9.2f %%\n",arr[26],f);
	for(i=0;i<26;i++){
		f=((float)arr[i]/total)*100;
		printf("   %c%9d%9.2f %%\n",(97+i),arr[i],f);
	}
	printf("-------------------------");
	return 0;
}
