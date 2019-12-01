#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the biggerIsGreater function below.
def biggerIsGreater(w):
    
    # search
    value_chosen = -1
    value_target = -1
    idx_chosen = -1
    idx_target = -1

    for chosen in range(len(w)-1, -1, -1):
        for target in range(chosen-1, -1, -1):
            if w[chosen] > w[target]:
                if target > idx_target:
                    # note: what if target is equal to idx_target? => No need to check. cuz current chosen must be greator than previous chosen.
                    value_chosen = w[chosen]
                    value_target = w[target]
                    idx_chosen = chosen
                    idx_target = target
                    continue;

        if chosen == idx_target: # no need to find anymore
            break

    # check 'no answer'
    if idx_target == -1:
        return 'no answer'

    # make sortTarget
    sortTarget = []
    
    for idx in range(idx_target + 1, len(w)):
        if idx == idx_chosen:
            sortTarget.append(value_target)  # The target value move to the chosen index
        else:
            sortTarget.append(w[idx])

    # sort
    sortTarget.sort()

    # make unsortedStr
    unsortedStr = ""

    for idx in range(idx_target):
        unsortedStr += w[idx]

    unsortedStr += value_chosen  # The chosen value move to the target index

    # make sortedStr
    sortedStr = ""
    for idx in range(len(sortTarget)):
        sortedStr += sortTarget[idx]

    # make result
    result = unsortedStr + sortedStr

    return result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    T = int(input())

    for T_itr in range(T):
        w = input()

        result = biggerIsGreater(w)

        fptr.write(result + '\n')

    fptr.close()
