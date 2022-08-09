import math

def solution(arr):
    answer = 1
    prime = [2]
    for i in range(3, max(arr)+1):
        flag = True
        for p in prime:
            if i % p == 0:
                flag = False
                break
        if flag:
            prime.append(i)
    prime_count = [0 for _ in range(len(prime))]

    for i in arr:
        idx = 0
        count = 0
        while(True):
            if(i==1):
                break
            if(i % prime[idx] == 0):
                count += 1
                prime_count[idx] = max(prime_count[idx], count)
                i /= prime[idx]
            else:
                idx += 1
                count = 0
                continue

    for i in range(len(prime_count)):
        if(prime_count[i] != 0):
            answer *= prime[i] ** prime_count[i]

    return answer

arr = [100,99,98,97,96,95,94,93,92,91]
print(solution(arr))