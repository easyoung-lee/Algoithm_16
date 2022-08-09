def gcd(a,b):
    if(a%b==0):
        return b
    else:
        return gcd(b,a%b)
def solution(arr):
    answer = 0
    temp_lcm=arr[0]*arr[1]/gcd(arr[0],arr[1])
    for i in range(2,len(arr)):
        temp_lcm=temp_lcm*arr[i]/gcd(temp_lcm,arr[i])
    answer=temp_lcm
    return answer