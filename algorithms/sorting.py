"""
sorting.py
~~~~~~~~~~
Use various sorting techniques.
"""


def bubble_sort(arr=None):
    """
    Perform a bubble sort.

    For each index, check the next value. If it is greater than the current index, we're sorted.

    Returns
    -------
    list
        The sorted list
    """
    is_sorted = True
    while is_sorted:
        is_sorted = False
        for i in range(len(arr) - 1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                is_sorted = True
    print(f'Bubble Sorted array: {arr}')
    return arr


def selection_sort(arr=None):
    """
    Performs a selection sort

    For entire array, find smallest value and place in lowest index.

    Parameters
    ----------
    arr

    Returns
    -------
    list
        The sorted list
    """
    for i in range(len(arr)):
        low_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[low_index]:
                low_index = j
        arr[i], arr[low_index] = arr[low_index], arr[i]
    print(f"Selection Sorted array: {arr}")
    return arr


def insertion_sort(arr=None):
    """
    Performs an insertion sort.

    For every element of a list, place it in the smallest spot it can go.

    Parameters
    ----------
    arr

    Returns
    -------

    """
    for i in range(len(arr)):
        item_to_insert = arr[i]

        j = i - 1

        while j >= 0 and arr[j] > item_to_insert:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = item_to_insert
    print(f"Insertion Sorted array: {arr}")
    return arr


def partition(xs, start, end):
    """
    The partioner needed for ``quicksort``
    Borrowed from:
    https://www.codementor.io/@garethdwyer/
        quicksort-tutorial-python-implementation-with-line-by-line-explanation-p9h7jd3r6
    """
    follower = leader = start
    pivot_value = xs[end]
    while leader < end:
        if xs[leader] <= pivot_value:
            xs[follower], xs[leader] = xs[leader], xs[follower]
            follower += 1
        leader += 1
    xs[follower], xs[end] = xs[end], xs[follower]
    return follower


def _quicksort(xs, start, end):
    """The quicksort recursive algorithm."""
    if start >= end:
        return

    p = partition(xs, start, end)
    _quicksort(xs, start, p-1)
    _quicksort(xs, p+1, end)
    return xs


def quicksort(xs):
    """The public quicksort method."""
    a = _quicksort(xs, 0, len(xs) - 1)
    print(f"Quick Sorted array: {a}")
    return a


def _mergesort(arr):
    """
    Perform a merge sort on ``arr``

    1. Break down the list into individual components.
    2. Compare left and right cursors with who is smaller
    3. Progress through until the end.

    Parameters
    ----------
    arr

    Returns
    -------
    list:
        The sorted ``arr``.
    """
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        _mergesort(left)
        _mergesort(right)

        i = 0
        j = 0
        k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1


def mergesort(arr):
    """Perform the merge sort recursion."""
    _mergesort(arr)
    print(f"Merge Sorted array: {arr}")
    return arr


if __name__ == '__main__':
    # arr = [98, 5, 3, 1, 2, 24, 12, 56, 15]
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    print(f"Sorting: {arr})")
    print(f"Sorted: {_sorted}\n")
    assert bubble_sort(arr.copy()) == _sorted
    assert selection_sort(arr.copy()) == _sorted
    assert insertion_sort(arr.copy()) == _sorted
    assert quicksort(arr.copy()) == _sorted
    assert mergesort(arr.copy()) == _sorted
