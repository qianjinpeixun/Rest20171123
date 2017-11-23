
def fOnly( mylist ):mylist = [b for b in mylist if isinstance(b, float)];print mylist;return;
mylist = [1.0, 2, 3.0, "cat", "a", 4, 5];
fOnly(mylist);


