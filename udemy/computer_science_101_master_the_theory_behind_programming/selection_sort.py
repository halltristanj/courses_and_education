"""
selection_sort.py
~~~~~~~~~~~~~~~~~
Perform a selection sort
"""


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


if __name__ == "__main__":
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    print(f"Sorting: {arr})")
    print(f"Sorted: {_sorted}\n")
    assert selection_sort(arr.copy()) == _sorted
