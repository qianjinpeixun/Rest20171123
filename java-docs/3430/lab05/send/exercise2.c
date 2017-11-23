//the line 1, #include command is moer than Pascal language
#include <stdio.h>
int main()
{
    	int num;
    	printf("Enter an integer: ");
    	scanf("%d", &num);
	// in Pascal language, the for loop has less sentences
	for(int i=num;i>0;i--){
		printf("%d\n",i*i*i);
	}
    	printf("Well that was easy!");
	//in Psacal language, the return sentence is not a must
    	return 0;
}