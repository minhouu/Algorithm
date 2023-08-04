T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    input_field = [[] for i in range(n)]
    for i in range(n) :
      for j in input() :
        input_field[i].append(int(j))

    result = 0
    for i in range(0, n//2) :
        result += sum(input_field[i][n//2-i:n//2+i+1])
    for i in range(n//2, n) :
        result += sum(input_field[i][i-n//2:n//2+(n-i)])
    print(f"#{test_case}", result)
