def sumOfTwo(a, b, v):    
    
    b = set(b)
    
    for n in a:
        if v - n in b:
            return True
    return False
