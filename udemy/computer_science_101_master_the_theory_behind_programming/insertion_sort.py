"""
insertion_sort.py
~~~~~~~~~~~~~~~~~
Performs an Insertion Sort
"""

import logging

LOGGER = logging.getLogger(__name__)


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
    LOGGER.info(f"Insertion Sorted array: {arr}")
    return arr


if __name__ == "__main__":
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    LOGGER.info(f"Sorting: {arr})")
    LOGGER.info(f"Sorted: {_sorted}\n")
    assert insertion_sort(arr.copy()) == _sorted
