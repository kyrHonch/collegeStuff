function [A,pivot_cols,pivot_count] = rref337c(A)

% Computes the reduced row-echelon form of the input matrix (A)
% including a list (pivot_cols) and count (pivot_count) of the pivot columns.
% This code has a pedagogical purpose and ignores certain considerations important
% for practical implmentations including roundoff error and computational efficiency.
% Updated 1/10/2023

    [m n] = size(A);         % initialization of the number of rows and columns
    pivot_cols = zeros(1,0); % empty initialization of pivot column list
    pivot_count = 0;         % initialization of the count of pivots

    %  Forward phase (forward elimination using SUB and SWAP)

    for pcc = 1:n            % Process each column from 1 to n (left to right).
        for test_row=pivot_count+1:m     % Test each row below last pivot found.
            if A(test_row,pcc) ~= 0          % If the next pivot is found
                pivot_count = pivot_count + 1;      % count the pivot
                pivot_cols(pivot_count)=pcc;        % record the pivot column
                A = SWAP(A,test_row,pivot_count);   % position the pivot
                for tr= pivot_count+1:m             % eliminate below the pivot
                    A = SUB(A,pivot_count, A(tr,pcc)/A(pivot_count,pcc), tr);
                end
                break;       % Go on to the next column (pivot for column found)
            end
        end
    end

    %   Normalization of pivots to obtain row-echelon form (using SCALE)

    for r=1:pivot_count
        A = SCALE(A,r,1.0/A(r,pivot_cols(r)));
    end

    %  Backward phase--zero out entries above pivots (using SUB)

    for r = pivot_count:-1:1  % from the last pivot backwards to the first
        for tr = 1:r-1        % eliminate above the pivot
            A = SUB(A,r,A(tr,pivot_cols(r)),tr);
        end
    end
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Subfunctions performing row operations
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function A = SUB(A,p,multiplier,q)
%  Row q is replace by row q minus multiplier times Row p
    A(q,:) = A(q,:) - multiplier*A(p,:);
end

function A = SWAP(A,p,q)
%  Exchanges row p and row q of the matrix A
    temp_row = A(p,:);
    A(p,:) = A(q,:);
    A(q,:) = temp_row;
end

function A = SCALE(A,p,multiplier)
%   Multiplies row p by multiplier
    A(p,:) = multiplier*A(p,:);
end