#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the biggerIsGreater function below.
def biggerIsGreater(w):
    """
    현재 문자열보다 더 커지려면(greator) 오른쪽에 위치한 더 큰 문자를 왼쪽에 위치한 더 작은 문자열과 바꿔주어야 한다. (왼쪽에 더 큰 글자가 있을 수록 더 크다고 판단되기 때문이다)
    문자열의 가장 오른쪽부터 한 글자씩 선택한 후, 왼쪽으로 진행하면서 선택한 문자(chosen)보다 값이 더 작은 문자(target)가 있는지 탐색한다.
    탐색이 성공하였다면 chosen과 target의 정보를 저장하고, 즉시 break 한 후 새로운 chosen 으로 다시 탐색을 시작한다. 
    - 바로 break를 하는 이유는, 더 왼쪽의 target 값을 탐색하면 안 되기 때문이다. 더 왼쪽의 target값을 사용하면 문제의 두번째 조건이 틀리게 된다.
    - 새로운 chosen으로 다시 검색하는 이유는, 이전에 찾은 target보다 더 오른쪽에 위치한 target을 찾을 수도 있기 때문이다. 바로 위에 서술했듯이 가장 오른쪽의 target을 사용하는 것이 문제의 두번째 조건을 충족시킬 수 있다.
    - 현재 탐색 중인 인덱스가 기존에 탐색한 target 인덱스에 도달하면, 더 찾을 필요가 없으므로 탐색을 강제 종료한다. (탐색을 속행해도 찾아지는 target은 기존에 찾은 target보다 왼쪽에 위치하므로 쓸모없다)
    
    만약 target이 하나도 발견되지 않았다면 'no answer'를 리턴한다.
    
    target의 인덱스를 기준으로 왼쪽의 문자열을 복사한다.
    target의 자리에 target 대신 chosen 값(value_chosen) 을 넣는다.
    target의 인덱스를 기준으로 오른쪽의 문자열을 오름차순으로 정렬한다. 오름차순으로 정렬하는 것이 가장 작은 문자열이 되기 때문이다.
    
    이 과정을 거치면, chosen 값보다 target 값이 작다는 조건을 만족하는 문자 중 최대한 오른쪽에 위치한 값을 chosen 값과 바꿔줌으로써 기존 문자열보다 커지는 조건을 만족하고, target의 오른쪽의 문자열을 오름차순으로 배열함으로써 가장 작은 값을 얻게 된다. 
    """

    
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
                    break

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
