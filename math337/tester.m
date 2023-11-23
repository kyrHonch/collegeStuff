clc
A=[1 2 3; 4 5 6; 7 8 9]; 
%minor(1) = A
%d=rdet(A)

for j=1:n
%            [minor(j), count] = rdet(A(2:n,[1:j-1 j+1:n]), count + 1)
    minor(j) = A(2:n, [1 : j-1 j+1: n])
end