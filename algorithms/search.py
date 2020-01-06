"""
search.py
~~~~~~~~~
Search algorithms
"""

from math import floor


def binary_search(arr, number, left=None, right=None):
    """
    Perform a binary search

    Parameters
    ----------
    left: int
        The leftmost array index
    right: int
        The rightmost array index
    arr: list
        The array we're searching through.
    number: int
        The number we're looking for

    Returns
    -------
    int
        The index of ``number``
    """

    if not left:
        left = 0
    if not right:
        right = len(arr)

    look_index = floor((left + right) / 2)
    val_at_index = arr[look_index]

    if number > val_at_index:
        left = look_index
        right = right
        return binary_search(arr, number, left=left, right=right)
    elif number < val_at_index:
        right = look_index
        left = left
        return binary_search(arr, number, left=left, right=right)
    elif number == val_at_index:
        return look_index

    return None


if __name__ == '__main__':
    #    0  1  2  3   4   5   6   7   8   9   10
    #    1  2  3  4   5   6   7   8   9   10  11
    l = [1, 2, 3, 10, 23, 32, 45, 50, 56, 79, 900]

    print(binary_search(l, 900))
