#!/bin/python3

import math
import os
import random
import re
import sys

def reverseTopBottom(mtx):
    result = [[0]*3 for i in range(3)]

    for i in range(3):
        for j in range(3):
            result[i][j] = mtx[2-i][j]

    return result

def reverseLeftRight(mtx):
    result = [[0]*3 for i in range(3)]

    for i in range(3):
        for j in range(3):
            result[i][2-j] = mtx[i][j]

    return result

def rotate90(mtx):
    result = [[0]*3 for i in range(3)]

    result[0][0] = mtx[2][0]
    result[0][1] = mtx[1][0]
    result[0][2] = mtx[0][0]
    result[1][0] = mtx[2][1]
    result[1][1] = mtx[1][1]
    result[1][2] = mtx[0][1] 
    result[2][0] = mtx[2][2]
    result[2][1] = mtx[1][2]
    result[2][2] = mtx[0][2]  

    return result

def calculate(s, mtx):
    result = 0
    for i in range(3):
        for j in range(3):
           result += abs(mtx[i][j] - s[i][j])

    return result

# Complete the formingMagicSquare function below.
def formingMagicSquare(s):
    result = 0
    minResult = 100
    mtx = [[4,9,2],[3,5,7],[8,1,6]]

    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = reverseLeftRight(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    mtx = rotate90(mtx)
    result = calculate(s, mtx)
    if(minResult > result):
        minResult = result

    return minResult
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = []

    for _ in range(3):
        s.append(list(map(int, input().rstrip().split())))

    result = formingMagicSquare(s)

    fptr.write(str(result) + '\n')

    fptr.close()
