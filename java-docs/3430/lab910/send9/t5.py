

import thread
import time
import datetime
from time import gmtime, strftime
import threading

#use the lock function to mutex the variable
lock = threading.Lock()
global index
index=0
		
#writes the time of day as an HH:MM:SS string into a global variable 100 times per second
def thread1():
	while True:
		time.sleep(0.1)
		global currentTime 
		lock.acquire()
		try:
			currentTime = strftime("%H:%M:%S", gmtime())
		finally:
			lock.release()
		
def thread2():
	while True:
		#read the time of day string from global variable twice per second
		time.sleep(0.5)
		global index
		index = index +1
		#really displays to screen only once per second
		if index % 2 == 0:
			continue
		lock.acquire()
		try:
			print currentTime
		finally:
			lock.release()
		

t1 = threading.Thread(target=thread1)
t1.setDaemon(True)
t2 = threading.Thread(target=thread2)
t2.setDaemon(True)
t1.start()
t2.start()

#killing both threads before the main program thread exits
try:
	while 1:
		time.sleep(0.01)
except KeyboardInterrupt:
	t1.kill_received = True
	t2.kill_received = True
	print "shut the application threads down gracefully!"