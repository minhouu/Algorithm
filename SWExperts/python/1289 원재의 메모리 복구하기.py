# 1에서 0, 0에서 1로 바뀔 때 마다 count를 증가

a = '0011'
b = '100'



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
  input_str = input()
  def minimumChange(num : str) -> int :
    key = '0'
    min = 0
    for i in num:
      if i == key:
        continue
      else :
        print(f"i : {i} and different case")
        key = i
        min += 1
        print("updated min : ", min)
    return min
  print(f"#{test_case} {minimumChange(input_str)}")

