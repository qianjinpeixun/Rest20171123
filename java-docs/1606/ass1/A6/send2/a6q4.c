/* File: a6q4.c
Author: Firstname Lastname, Banner_number
Date: Nov 15, 2017
Purpose: Solution to problem A6Q4 of CSCI2132
Description: partition for quick sort
*/
#include <stdio.h>

int* partition(int *lo, int *hi){
	int* first = lo;
	int tmp=*lo;
	//The pivot must be chosen as the middle element
	*lo=*(lo+(hi-lo)/2);
	*(lo+(hi-lo)/2)=tmp;
	int* last = hi;
	int key = *lo;        
	while (first < last)
	{
		while (first < last && *last >= key)
			last--;
		*first = *last;
		while (first < last && *first <= key)
			first++;
		*last = *first;
	}
	*first = key; 
	return first;
}