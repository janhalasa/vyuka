#
# Iteratívna implementácia funkcie faktoriál
#

def factorial(n: int) -> int:
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

print(factorial(int(input('Enter number: '))))
