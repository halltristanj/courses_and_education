"""
anagram.py
~~~~~~~~~~
how to anagram
"""


def anagram(str1, str2):
    """Returns an anagram of 'any' string"""
    if len(str1) != len(str2):
        raise ValueError("len(str1) != len(str2)")

    results = {}
    for i in range(len(str1)):
        c1 = str1[i].lower()
        c2 = str2[i].lower()

        if c1 not in results.keys() or c2 not in results.keys():
            results[c1] = 0
            results[c2] = 0

        results[c1] += 1
        results[c2] -= 1

    print(results)
    for c, count in results.items():
        if count != 0:
            return False

    return True




if __name__ == "__main__":
    print(anagram('string1ssR', 'stringss1r'))
