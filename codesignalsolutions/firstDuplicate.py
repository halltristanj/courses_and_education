def firstDuplicate(a):

    exists = set()
    for i, num in enumerate(a):
        if num in exists:
            return num
        exists.add(num)
    return -1
