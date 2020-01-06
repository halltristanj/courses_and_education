"""
sorting.py
~~~~~~~~~~
Use various sorting techniques.
"""


def bubble_sort(arr):
    """Perform a bubble sort"""
    _sorted = True
    while _sorted:
        _sorted = False
        for i in range(len(arr) - 1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                _sorted = True
    print(f"Bubble sorted: {arr}")
    return arr


def selection_sort(arr):
    """Performs a selection sort"""
    for i in range(len(arr)):
        low_index = i
        for j in range(i + 1, len(arr)):
            # Continually find the smallest number left in our array and set it as the low_index
            if arr[j] < arr[low_index]:
                low_index = j
        # Now take the low_index's number and assign it to the the array index we are at (i)
        arr[i], arr[low_index] = arr[low_index], arr[i]

    print(f"Selection sorted: {arr}")
    return arr


def insertion_sort(arr):
    """Performs an insertion sort"""
    for i in range(1, len(arr)):
        item_to_insert = arr[i]

        j = i - 1

        while j >= 0 and arr[j] > item_to_insert:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = item_to_insert

    print(f"Insertion Sort: {arr}")
    return arr


if __name__ == '__main__':
    arr = [98, 5, 3, 1, 2, 24]

    # bubble_sort(arr)
    # selection_sort(arr)
    insertion_sort(arr)
