




from tabnanny import check


N = int(input())
ans=0

def isPossible(row,column):
    global N
    if checked[column] : return False
        
    nx = row-1
    ny = column-1
    while nx>=0 and ny>=0:
        if map[nx][ny]:
            return False
        nx-=1
        ny-=1
        
    nx = row-1
    ny = column+1
    while nx>=0 and ny<N:
        if map[nx][ny]:
            return False
        nx-=1
        ny+=1
        
    return True

def dfs(row,column):
    global ans
    if not isPossible(row,column): return
    checked[column]=True
    if(row==N-1):
        ans+=1
        checked[column]=False
        return
    for i in range(N):
            if checked[i] : continue
            map[row+1][i]=True
            
            dfs(row+1,i)
            map[row+1][i]=False
    checked[column]=False
            
map=[[False for i in range(N)]for i in range(N)]
checked=[False for i in range(N)]
for i in range(N):
    map[0][i]=True
    
    dfs(0,i)
    
    map[0][i]=False
print(ans)
