


from collections import deque



def bfs(pos):
    global N,M
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    queue = deque()
    isPossible =False
    ans =0
    queue.append(pos)
    wall_map[pos[0]][pos[1]][0]=2
    while queue:
        curNode=queue.popleft()
        if curNode[0]==M-1 and curNode[1]==N-1:
            ans = wall_map[M-1][N-1][curNode[2]]
            isPossible=True
            break
        for i in range(4):
            nextNode = [curNode[0]+dx[i],curNode[1]+dy[i],curNode[2]]
            if(nextNode[0]<0 or nextNode[0]>=M or nextNode[1]<0 or nextNode[1]>=N) : continue
            if curNode[2]==1 :
                if wall_map[nextNode[0]][nextNode[1]][1]>=1 : continue
                queue.append(nextNode)
                wall_map[nextNode[0]][nextNode[1]][1]=wall_map[curNode[0]][curNode[1]][1]+1
            else :
                if wall_map[nextNode[0]][nextNode[1]][0]==1 :
                    nextNode[2]=1
                    queue.append(nextNode)
                    wall_map[nextNode[0]][nextNode[1]][1]=wall_map[curNode[0]][curNode[1]][0]+1
                elif wall_map[nextNode[0]][nextNode[1]][0]==0:
                    queue.append(nextNode)
                    wall_map[nextNode[0]][nextNode[1]][0]=wall_map[curNode[0]][curNode[1]][0]+1    
    if not isPossible : ans=0
    return ans




M,N = map(int,input().split());
wall_map = [[[0 for i in range(2)] for i in range(N)]for i in range(M)];


for i in range(M):
    temp =list(map(int,list(input())))
    for j in range(N):
        wall_map[i][j][0]=temp[j]
        wall_map[i][j][1]=temp[j]
        
        


temp=[0,0,0];

print(bfs(temp)-1)