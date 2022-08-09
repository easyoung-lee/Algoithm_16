
# 8월 1주차
# https://www.acmicpc.net/problem/9663

global result

def perm(index):    # index : 다음 행
    global result, queen
    if(index == N):
        result += 1
        return

    for next in range(N):   # cnt 행에 퀸 들어갈 위치
        flag = True
        for i in range(index):
            if next == queen[i]:   # 같은 열이 있으면
                flag = False
                break
            elif next == queen[i] + (index-i):    # 대각선 체크1
                flag = False
                break
            elif next == queen[i] - (index-i):    # 대각선 체크2
                flag = False
                break
        if(flag):
            queen.append(next)
            perm(index+1)
            queen.pop()


N = int(input())
result = 0
queen = []
for i in range(N):
    queen.clear()
    queen.append(i)
    perm(1)     # 1 행의 퀸 위치 0~N-1
print(result)

