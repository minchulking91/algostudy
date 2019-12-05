int surfaceArea(vector<vector<int>> A) {

    //dimension surface
    int xy=0, xz=0, yz=0;
    int row, col;
    
    //initialize
    row = A.size();
    col = A[0].size();

    xy = col * row;

    for(int i = 0; i < row; i++)
    {
        for(int j = 0; j < col; j++)
        {
            if(j==0) xz += A[i][j];
            else xz += max(A[i][j] - A[i][j-1], 0);
        }
    }

    for(int j = 0; j < col; j++)
    {
        for(int i = 0; i<row; i++)
        {
            if(i==0) yz += A[i][j];
            else yz += max(A[i][j]-A[i-1][j], 0);
        }
    }

    return (xy+yz+xz)*2;
}
