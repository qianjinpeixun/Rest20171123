program Sum;
var a : integer;
function Sum(num : integer) : integer;
begin
  if num = 1 
  then Sum := 1
  else Sum := Sum(num-1) + num
end;
begin
a := Sum(3);
writeln(a);
end.