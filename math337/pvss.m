function [d,count] = pvss(A,count)
    n=size(A,1);
    count = count +1;
    if n>1

        for j=1:n
            [minor(j), count] = pvss(A(2:n,[1:j-1 j+1:n]),count);
            
        end

        d = 0.0;
        for j=1:n
            count = count + 1;
             d = d + (-1)^(j+1)*A(1,j)*minor(j);
        end

    else
        count = count +1;
        d = A(1,1);
    end    
end