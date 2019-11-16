string encryption(string s) {

    //get row, col
    int len = s.length();
    int row = sqrt(len);
    int col = 0;
    row * row < len ? col = row + 1 : col = row;

    string answer = "";
    for(int i = 0; i < col; i++)
    {
        int idx = i;
        while(idx < len)
        {
            answer += s.at(idx);
            idx += col;
        }
        answer += " ";
    }

    return answer;
}
