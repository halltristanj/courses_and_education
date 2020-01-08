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


if __name__ == '__main__':
    arr = [98, 5, 3, 1, 2, 24, 12, 56, 15]

    # bubble_sort(arr)
    # selection_sort(arr)
    insertion_sort(arr)
