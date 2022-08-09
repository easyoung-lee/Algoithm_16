def gcd(a, b):
    if(a%b == 0):
        return b
    else:
        return gcd(b, a%b)

def solution(arr):
    answer = arr[0]
    for a in range(1, len(arr)):
        answer = a*answer / gcd(answer, a)
    return answer