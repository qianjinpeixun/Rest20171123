/* File: a6q3.c
Author: Firstname Lastname, Banner_number
Date: Nov 15, 2017
Purpose: Solution to problem A6Q3 of CSCI2132
Description: The program removes C-style comments
*/
#include <stdio.h>
int main(){
	char c;
	int state;
	state=0;
	char c1=' ';
	int comment=0;
	int count=0;
	int newline=0;
	while( (c = getc(stdin)) != EOF){
		if(state==0 && c=='/') //[/]
			state=1;
		else if(state ==1 && c=='*')  //[/*]
			state=2;
		else if(state ==1 && c=='/'){  //[////]
			putchar('/');
			state=1;
		}
		else if(state ==2 && c=='*')  //[*xx*]
			state=3;
		else if(state ==2)  //[*xxxx]
			state=2;
		else if(state ==3 && c=='/')  //[/*xxx*/]
			state=0;
			
		if((state==0 && c!='/')||c=='\n')
			putchar(c);
	}
	if(state!=0){
		printf("\n<COMMENT NOT FINISHED>");
	}
	return 0;
}