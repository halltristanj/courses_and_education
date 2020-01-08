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
    print(f'Bubble sorted array: {arr}')
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
    print(f"Selection sorted array: {arr}")
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
    print(f"Pivot Value: {pivot_value}")
    while leader < end:
        if xs[leader] <= pivot_value:
            xs[follower], xs[leader] = xs[leader], xs[follower]
            follower += 1
        leader += 1
    xs[follower], xs[end] = xs[end], xs[follower]
    print(f"partioned: {xs}")
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


if __name__ == '__main__':
    arr = [98, 5, 3, 1, 2, 24, 12, 56, 15]

    print(f"Sorting: {arr})\n")
    bubble_sort(arr.copy())
    selection_sort(arr.copy())
    insertion_sort(arr.copy())
    quicksort(arr.copy())
