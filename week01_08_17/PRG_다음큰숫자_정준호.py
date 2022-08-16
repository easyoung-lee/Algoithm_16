def solution(n):
    answer = 0
    x = list(map(int, list(str(bin(n))[2:])))
    
    if sum(x[:sum(x)]) == sum(x) :
        x.insert(1, 0)
        count = sum(x[2:])
        for j in range(-1, -len(x[1:]), -1):
            x[j] = 0
        for j in range(-1, -count-1, -1):
            x[j] = 1
    else :
        for i in range(-2, -len(x)-1, -1):   # -2번부터 처음까지
            if x[i] < x[i+1]:   # ~~01~~
                x[i], x[i+1] = x[i+1], x[i]
                count = sum(x[i:])
                for j in range(-1, -len(x[i:]), -1):
                    x[j] = 0
                for j in range(-1, -count, -1):
                    x[j] = 1
                break
    
    y = "0b" + "".join(map(str, x))
    return int(y, 2)

solution(124)