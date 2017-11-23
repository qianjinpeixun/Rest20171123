limit = raw_input("Please enter the speed limt:")
speed = raw_input("Please enter your current speed:")
l = 0
s = 0
try:
	f = float(limit)
except ValueError:
	print 'string is not a number for limit speed'
	exit()
	
try:
	l = int(limit)
except ValueError:
	print 'for limit speed cannot be float'
	exit()

try:
	f = float(speed)
except ValueError:
	print 'string is not a number for current speed'
	exit()
	
try:
	s = int(speed)
	
except ValueError:
	print 'current speed cannot be float'
	exit()

if l < 0:
	print 'speed limit is less than zero'
	exit()
if s < 0:
	print 'current speed is less than zero'
	exit()
	
if s <= l:
	print '$0 because your current speed equal or below the speed limit'
	exit()
else:
	if s < l+5:	
		print '$200 becuase your current speed is less than 5 km per hour above the speed limit'
		exit()
	else:
		if s < l+20 :
			f = ( s - l -5 ) * 500
			print 'speeding fine is $' + str(f)
			exit()
		else:
			if s < 400:
				f = ( s - l - 20 ) * 1000
				print 'speeding fine is $' + str(f)
				print 'Because $1000 for every additional km per hour above over 20 km per hour above the speed limit'
			else:
				print 'speeding fine is 0 becuase yuou are in a bufatti so they can not catcy you!'