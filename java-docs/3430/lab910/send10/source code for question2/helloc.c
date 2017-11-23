#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <Hello.h>
#include <string.h> // memcpy


JNIEXPORT jint JNICALL Java_Hello_operate
  (JNIEnv * env, jclass jc, jbyteArray s1, jbyteArray s2, jbyteArray s3){
	jbyte *b1 = (*env)->GetByteArrayElements(env, s1, 0); 
	jsize n1 = (*env)->GetArrayLength(env, s1);
	char* c1 = malloc(n1 + 1) ;
	memcpy(c1, b1, n1);    
    c1[n1] = '\0';    
	
	
	jbyte *b2 = (*env)->GetByteArrayElements(env, s2, 0); 
	jsize n2 = (*env)->GetArrayLength(env, s2);
	char* c2 = malloc(n2 + 1) ;
	memcpy(c2, b2, n2);    
    c2[n2] = '\0';    
	
	jbyte *b3 = (*env)->GetByteArrayElements(env, s3, 0); 
	jsize n3 = (*env)->GetArrayLength(env, s3);
	char* c3 = malloc(n3 + 1) ;
	memcpy(c3, b3, n3);    
    c3[n3] = '\0';   

	int f1=199;
	f1=atoi(c1);

	int f2=199;
	f2=atoi(c2);

	int f3=199;
	f3=atoi(c3);
	
	int ret=0;
	if(f2==0)
		return (jint)ret;
	
	ret=((f1/f2)-f3);
	
	return (jint)ret;
	  
  }
