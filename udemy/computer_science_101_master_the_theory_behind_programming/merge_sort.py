"""
merge_sort.py
~~~~~~~~~~~~~
Performs a Merge Sort
"""

import logging

LOGGER = logging.getLogger(__name__)


def _merge_sort(arr):
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

        _merge_sort(left)
        _merge_sort(right)

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


def merge_sort(arr):
    """Perform the merge sort recursion."""
    _merge_sort(arr)
    LOGGER.info(f"Merge Sorted array: {arr}")
    return arr


if __name__ == '__main__':
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    LOGGER.info(f"Sorting: {arr})")
    LOGGER.info(f"Sorted: {_sorted}\n")
    assert merge_sort(arr.copy()) == _sorted
