#include <stdio.h>
#include <string.h>
float searchArrayType[20];
void Introduction(){
        printf("This program reads numbers from a file called input.dat,\n");
        printf("sorts the numbers.\n");
}

void sort(){

        int min(int start){
                int i;
                int tempMin;
                tempMin=start;
                for(int i=(start+1);i<20;i++){
			if(searchArrayType[i]<searchArrayType[tempMin]){
				tempMin=i;	
			}
                }
                return tempMin;
        }
	void swap(float * l, float * r){
		float temp;
		temp=*l;
		*l=*r;
		*r=temp;
	}
	for(int i=0;i<19;i++){
		swap(&searchArrayType[i],&searchArrayType[min(i)]);
	}
}

void display(){
        for(int i=0;i<20;i++){
                printf("%.2f\n",searchArrayType[i]);
        }


}
void readInput(){
	char filename[100];
	printf("Please input the filename:");
	scanf("%s",filename);
	FILE *fp;
	fp=fopen(filename,"r");
	if(fp != NULL){
		for(int i=0;i<20;i++){
			float number;
			fscanf(fp,"%f",&number);
			searchArrayType[i]=number;
		}
	}else{
		printf("file not exist!");
	}
	fclose(fp);
}
int main(){
        Introduction();

        printf("Sorted numbers are as follows:\n");
	readInput();
	sort();
        display();
        return 0;
}
