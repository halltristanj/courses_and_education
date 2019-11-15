def sumInRange(nums, queries):

    final_sum = [0]
    summ = 0
    for n in nums:
        summ += n
        final_sum.append(summ)
    summ = 0
    for i, j in queries:
        summ += final_sum[j+1] - final_sum[i]
    return summ % (pow(10,9) + 7)
