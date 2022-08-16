# def solution(n):
#     answer = 0
#     cnt = bin(n).count('1')
#     while True:                                                         
#         n=n+1
#         if bin(n).count('1')==cnt:
#             answer=n
#             break
#     return answer

def solution(n):
    answer=n+1
    oneCnt=0;
    for i in range(19):
        if n&1<<i!=0:
            oneCnt+=1
    while True:
        tempCnt=0
        for i in range(19):
            if answer&1<<i!=0:
                tempCnt+=1
        if tempCnt==oneCnt:
            return answer
        answer+=1