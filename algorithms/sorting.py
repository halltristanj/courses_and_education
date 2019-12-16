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


if __name__ == '__main__':
    arr = [98, 5, 3, 1, 2, 24]

    bubble_sort(arr)
