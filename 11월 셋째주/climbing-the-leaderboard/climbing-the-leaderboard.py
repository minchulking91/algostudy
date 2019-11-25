#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    result = []
    new_scores = []

    #filter scores
    scores = list(set(scores))
    scores.sort(reverse=True)

    #search ranks of alice
    for curr in alice:
        result.append(search(curr, scores))

    return result

#binary search
def search(target, data):
    result = 0
    start = 0
    end = len(data) - 1

    while start <= end:
        if start == end:
            if data[end] <= target:
                result = end
            else:
                result = end + 1
            break

        mid = (start + end) // 2

        if data[mid] == target:
            result = mid
            break
        elif data[mid] > target:
            start = mid + 1
        else:
            end = mid

    result += 1
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
