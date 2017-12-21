from random import choice, randint

def quick_sort(lst):
    q_sort(lst, 0, len(lst) - 1)

def q_sort(lst, start, end):
    if start < end:
        print("Call with start = {} and end = {}".format(start, end))
        print(lst)
        pivot = lst[start]
        i = start
        j = end
        while i < j:
            while lst[i] <= pivot and i < end:
                i += 1
            while lst[j] >= pivot and j > start:
                j -= 1
            if i < j:
                lst[i], lst[j] = lst[j], lst[i]
                print(lst)
                print("i = {}, j = {}".format(i, j))
                i += 1
                j -= 1
        lst[j], lst[start] = lst[start], lst[j]
        print(lst)
        print("i = {}, j = {}".format(i, j))
        q_sort(lst, start, j - 1)
        q_sort(lst, i, end)

def main():
    numbers = [3, 4, 7]
    # lst = [choice(numbers) for i in range(10)]
    # lst = [randint(0, 10) for i in range(10)]
    lst = [i for i in range(10)]

    quick_sort(lst)

if __name__ == '__main__':
    main()
