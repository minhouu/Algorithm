
# 가짜인풋
# input1 = '1'
# input2 = '5 1000'
# input3 = '100 200'
# input4 = '300 500'
# input5 = '250 300'
# input6 = '500 1000'
# input7 = '400 400'

# list_cal = [[100, 200], [300, 500], [250, 300], [500, 1000], [400, 400]]


# T = int(input())
# for test_case in range(1, T+1) :
#     # 2번째 줄 input 저장
#     detail = list(map(int, input().split(" ")))
#     n = detail[0]
#     max_cal = detail[1]

#     # 음식 정보 input 저장
#     list_cal = []
#     for i in range(n) :
#         list_cal.append(list(map(int, input().split(" "))))
    list_cal = [[100, 200], [300, 500], [250, 300], [500, 1000], [400, 400]]
    cal = 0
    max_score = 0
    def maxScore(cases : list, cal, score) -> int :
        if cal > max_cal :
            return score
        for i in range(len(cases)) :
            score += cases[i][0]
            cal += cases[i][1]
            temp_score = maxScore(cases[:i], score, cal) - cases[i][0]
            score -= cases[i][0]
            cal -= cases[i][1]
            max_score = max(max_score, temp_score)
        return
    maxScore(list_cal, cal, max_score)
    print(f"#{test_case} {max_score}")





    # # 단위 칼로리 높은 순으로 먹는다
    # sum_cal = 0
    # sum_score_1 = 0
    # for i in range(len(list_cal)) :
    #     if sum_cal + list_cal[i][1] <= max_cal :
    #         sum_cal += list_cal[i][1]
    #         sum_score_1 += list_cal[i][0]
    
    # # 그냥 점수 높은 순으로 먹는다
    # list_cal.sort(key=lambda x:x[0], reverse=True)
    # sum_cal = 0
    # sum_score_2 = 0
    # for i in range(len(list_cal)) :
    #     if sum_cal + list_cal[i][1] <= max_cal :
    #         sum_cal += list_cal[i][1]
    #         sum_score_2 += list_cal[i][0]

    # # 그냥 칼로리 낮은 순으로 먹는다
    # list_cal.sort(key=lambda x:x[1], reverse=False)
    # sum_cal = 0
    # sum_score_3 = 0
    # for i in range(len(list_cal)) :
    #     if sum_cal + list_cal[i][1] <= max_cal :
    #         sum_cal += list_cal[i][1] 
    #         sum_score_3 += list_cal[i][0]
