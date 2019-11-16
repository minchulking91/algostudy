int formingMagicSquare(vector<vector<int>> s) {
    int magics[8][3][3] = { 
        {{4,9,2}, {3,5,7}, {8,1,6}},
        {{2,7,6}, {9,5,1}, {4,3,8}},
        {{6,1,8}, {7,5,3}, {2,9,4}},
        {{8,3,4,}, {1,5,9}, {6,7,2}},
        {{2,9,4}, {7,5,3}, {6,1,8}},
        {{4,3,8}, {9,5,1}, {2,7,6}},
        {{8,1,6}, {3,5,7},{4,9,2}},
        {{6,7,2}, {1,5,9}, {8,3,4}}
    };
    int min = 987654321;
    for(int shape = 0; shape <8; shape++)
    {
        int local_min = 0;
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                int diff = magics[shape][i][j] - s[i][j];
                diff < 0 ? local_min -= diff : local_min += diff;
            }
        }

        if(local_min < min) min = local_min;
    }
    return min;
}
