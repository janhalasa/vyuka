#
# Zoradenie náhodných celých čísel pomocou algoritmu Bubble sort.
# https://en.wikipedia.org/wiki/Bubble_sort
#

import random

numbers = []

for i in range(6):
    numbers.append(random.randint(0, 99))

print('Generated numbers:', numbers)

for i in range(len(numbers) - 1):
    for j in range(len(numbers) - 1 - i):
        if numbers[j] > numbers[j + 1]:
            numbers[j], numbers[j + 1] = numbers[j + 1], numbers[j]
            # Alternative:
            # numbers[j:j+2] = [numbers[j + 1], numbers[j]]
            

print('Ordered numbers:  ', numbers)
