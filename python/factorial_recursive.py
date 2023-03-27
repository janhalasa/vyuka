#
# Rekurzívna implementácia funkcie faktoriál.
#

def factorial(n: int) -> int:
    if n == 1:
        return 1
    return factorial(n - 1) * n

print(factorial(int(input('Enter number: '))))
