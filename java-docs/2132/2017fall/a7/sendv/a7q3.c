/* File: a7q3.c
Author: Firstname Lastname, Banner_number
Date: Nov 24, 2017
Purpose: Solution to problem A7Q3 of CSCI2132
Description: The program prints a list of all distinct words in a lexicographic order.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
In order to test the more than 10000 distinct words, I create a test file by generate string randomly, name test2.in

*/

//check if the input is a word, only include characters not digital or others
int isword(char * w){
	//if the end of char is enter 
	int j=strlen(w)-1;
	for(j=strlen(w)-1;j>0;j--){
		if(w[j]=='\r' || w[j]=='\n'){
			w[j]='\0';
		}
	}
	//if only one enter character
	if(strlen(w)==2 && w[strlen(w)-1]=='\n')
		return 0;
	
	char c=w[strlen(w)-1];
	if(c=='\n'){
		w[strlen(w)-1]='\0';
	}
	//if the end is other characters
	c=w[strlen(w)-1];
	if(c<65 || (c>90&&c<97)|| c>122){
		w[strlen(w)-1]='\0';
	}
	int i=0;
	for(i=0;i<strlen(w);i++){
		char c=*(w+i);
		if(c<65 || (c>90&&c<97)|| c>122){
			return 0;
		}
	}
	return 1;
}

//distinct the words in the array
int existword(char ww[][26] ,char * w, int index){
	int i=0;
	for(i=0;i<index;i++){
		if(strcmp(ww[i],w)==0)
			return 1;
	}
	return 0;
}

int main(){

	char *line = NULL;  
	size_t len = 0;  
	int read;
	char word[26];
	char * w=word;
	char *delim = " ";
	char *p;
	int max_words=10000;
	char words[10000][26];
	int index=0;
	int longword=0;
	int more=0;
	//start to get input line from stdin
	while ((read = getline(&line, &len, stdin)) != -1) {  
		if(index==10000){
			more=1;
			break;
		}
		w=strtok(line, delim);
		if(strlen(w)>25){
			longword=1;
			continue;
		}
		
		if(strlen(w)==2 && w[strlen(w)-1]=='\n'){
			continue;
		}
		
		if(isword(w)==1){
		
			int k=0;
			for(k=0;k<strlen(w);k++){
				if(*(w+k) >= 65 &&  *(w+k)<91){
					*(w+k)=*(w+k)+32;
				}
			}
			if(existword(words,w,index)==0){		
				strcpy(words[index],w);
				index++;
			}
		}else{
			continue;
		}
		//get more than one word in one line
		while((w = strtok(NULL, delim))){
			if(strlen(w)>25){
				longword=1;
				continue;
			}
			if(isword(w)==1){
				
				int k=0;
				//convert to lower letters
				for(k=0;k<strlen(w);k++){
					if(*(w+k) >= 65 &&  *(w+k)<91){
						*(w+k)=*(w+k)+32;
					}
				}
				//add to the array
				if(existword(words,w,index)==0){
					strcpy(words[index],w);
					index++;
				}
			}
			
		}
	}  

	int i=0;
	
	
	//order the array by idea of bubble sort algorithm
	for(i=0;i<index;i++){
		int k=0;
		char temp[26];
		for(k=i+1;k<index;k++){
			if(strcmp(words[i],words[k])>0){
				strcpy(temp,words[i]);
				strcpy(words[i],words[k]);
				strcpy(words[k],temp);
			}
		}
	}
	
	
	for(i=0;i<index;i++){
		printf("%s\r\n",words[i]);
	}
	
	if(longword==1){
		printf("\r\nWARNING: Words longer than 25 characters were ignored.");
	}
	
	if(more==1){
		printf("\r\nWARNING: More than 10,000 words. Some words are ignored.");
	}
}