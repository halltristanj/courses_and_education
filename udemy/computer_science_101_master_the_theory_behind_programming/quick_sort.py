"""
quick_sort.py
~~~~~~~~~~~~~
Performs a Quick Sort
"""


def partition(xs, start, end):
    """
    The partioner needed for ``quick_sort``
    Borrowed from:
    https://www.codementor.io/@garethdwyer/
        quick_sort-tutorial-python-implementation-with-line-by-line-explanation-p9h7jd3r6
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


def _quick_sort(xs, start, end):
    """The quick_sort recursive algorithm."""
    if start >= end:
        return

    p = partition(xs, start, end)
    _quick_sort(xs, start, p - 1)
    _quick_sort(xs, p + 1, end)
    return xs


def quick_sort(xs):
    """The public quick_sort method."""
    a = _quick_sort(xs, 0, len(xs) - 1)
    print(f"Quick Sorted array: {a}")
    return a


if __name__ == "__main__":
    from random import sample
    arr = sample(range(100), 10)
    _sorted = sorted(arr.copy())

    print(f"Sorting: {arr})")
    print(f"Sorted: {_sorted}\n")
    assert quick_sort(arr.copy()) == _sorted
