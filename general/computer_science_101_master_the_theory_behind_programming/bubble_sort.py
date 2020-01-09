"""
bubble_sort.py
~~~~~~~~~~~~~~
Perform a Bubble Sort
"""

import logging

LOGGER = logging.getLogger(__name__)

def bubble_sort(arr):
    """The Bubble Sort algorithm"""
    is_sorted = True
    while is_sorted:
        is_sorted = False
        for i in range(len(arr) - 1):
            if arr[i + 1] < arr[i]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                is_sorted = True
    LOGGER.info(f"Bubble Sort: {arr}")
    return arr


if __name__ == "__main__":
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    LOGGER.info(f"Sorting: {arr})")
    LOGGER.info(f"Sorted: {_sorted}\n")
    assert bubble_sort(arr.copy()) == _sorted
