function d = rdet(A)
    n=size(A,1);

    if n>1
        for j=1:n
            minor(j) = rdet(A(2:n,[1:j-1 j+1:n]));
        end

        d = 0.0;
        for j=1:n
             d = d + (-1)^(j+1)*A(1,j)*minor(j);
        end

    else
        d = A(1,1);
    end    
end