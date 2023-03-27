import random

secretNumber = random.randint(1, 100)
guessCount = 0

while True:
    guessed = int(input('Guess a number: '))
    guessCount += 1
    if guessed < secretNumber:
        print('Your number is lower')
    elif guessed > secretNumber:
        print('Your number is greater')
    else:
        print(f'Yeah, you found the secret number in {guessCount} guesses!')
        break
