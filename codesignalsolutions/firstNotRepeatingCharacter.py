def firstNotRepeatingCharacter(s):

    are_dupes = {x: 0 for x in s}
    for c in s:
        are_dupes[c] += 1
    
    for key, val in are_dupes.items():
        if val == 1:
            return key
    
    return '_'
