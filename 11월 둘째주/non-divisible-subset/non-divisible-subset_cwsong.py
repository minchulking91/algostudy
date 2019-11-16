#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'nonDivisibleSubset' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY s
#

def nonDivisibleSubset(k, s):
    result = 0
    arr = [0] * k
    half_idx = k // 2 + k % 2

    # count mods
    for i in range(len(s)):
        seed = s[i] % k
        arr[seed] += 1

    # when idx is 0
    result += min(arr[0],1) 

    # when idx is 1~
    for i in range(1, half_idx): 
        result += max(arr[i], arr[k-i])

    # when k is even
    if k % 2 == 0: 
        result += min(arr[half_idx],1)

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    s = list(map(int, input().rstrip().split()))

    result = nonDivisibleSubset(k, s)

    fptr.write(str(result) + '\n')

    fptr.close()
