def notprime(x):  
    for i in range(2,x):  
        if x%i==0:  
            return True  
        if i==x-1:  
            return False  

def fNonPrimes(maxnumber):
	output=filter(notprime,range(2,maxnumber+1))  
	print(list(output))  
	
fNonPrimes(10)