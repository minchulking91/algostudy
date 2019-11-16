#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the encryption function below.
def encryption(s):   
    result = ''
    row = 0
    col = 0

    myStr = s.replace(' ','')
    str_len = len(myStr)
    str_len_sqrt = math.sqrt(str_len)

    if(int(str_len_sqrt) == str_len_sqrt):
        row = col = int(str_len_sqrt)
    else:
        row = int(str_len_sqrt)
        col = row + 1

    for i in range(col):
        for j in range(i,str_len,col):
            if(myStr[j]):
                result += myStr[j]
        result += ' '

    return result
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()
