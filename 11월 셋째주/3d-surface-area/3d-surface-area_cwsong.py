#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the surfaceArea function below.
def surfaceArea(A):
    cnt = 0

    # top
    for i in range(H):
        for j in range(W):
            cnt += min(A[i][j], 1)

    # bottom
    cnt *= 2

    # direction 1
    for i in range(H):
        prev = 0
        for j in range(W):
            if A[i][j] > prev:
                cnt += A[i][j] - prev
            prev = A[i][j]    

    # direction 2
    for i in range(H):
        prev = 0
        for j in range(W-1,-1,-1):
            if A[i][j] > prev:
                cnt += A[i][j] - prev
            prev = A[i][j]

    # direction 3
    for j in range(W):
        prev = 0
        for i in range(H):
            if A[i][j] > prev:
                cnt += A[i][j] - prev
            prev = A[i][j]   

    # direction 4
    for j in range(W):
        prev = 0
        for i in range(H-1,-1,-1):
            if A[i][j] > prev:
                cnt += A[i][j] - prev
            prev = A[i][j]   


    return cnt


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    HW = input().split()

    H = int(HW[0])

    W = int(HW[1])

    A = []

    for _ in range(H):
        A.append(list(map(int, input().rstrip().split())))

    result = surfaceArea(A)

    fptr.write(str(result) + '\n')

    fptr.close()
