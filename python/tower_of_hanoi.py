#
# Implementácia známeho problému presunu veže, zloženej z krúžkov rôznej veľkosti, z jedného miesta na druhé.
# https://en.wikipedia.org/wiki/Tower_of_Hanoi
#

from typing import List

diskCount = int(input('Enter number of disks:'))

tower1 = [ *range(diskCount, 0, -1) ]
tower2 = []
tower3 = []

stepCount = 0

def swap_disks(firstTower: List[int], secondTower: List[int], firstName, secondName):
    global stepCount
    if len(firstTower) == 0 and len(secondTower) == 0:
        return
    stepCount += 1
    if len(firstTower) == 0 or len(secondTower) and firstTower[-1] > secondTower[-1]:
        print(secondName, '->', firstName)
        firstTower.append(secondTower.pop())
        return
    if len(secondTower) == 0 or len(firstTower) and secondTower[-1] > firstTower[-1]:
        print(firstName, '->', secondName)
        secondTower.append(firstTower.pop())

print(tower1, tower2, tower3)

while len(tower3) < diskCount:
    if diskCount % 2 == 1:
        swap_disks(tower1, tower2, 1, 2)
        if len(tower3) == diskCount:
            break
        swap_disks(tower1, tower3, 1, 3)
        
        if len(tower3) == diskCount:
            break
    else:
        swap_disks(tower1, tower3, 1, 3)
        if len(tower3) == diskCount:
            break
        swap_disks(tower1, tower2, 1, 2)
        if len(tower3) == diskCount:
            break

    swap_disks(tower2, tower3, 2, 3)

print(tower1, tower2, tower3, 'in', stepCount, 'steps')