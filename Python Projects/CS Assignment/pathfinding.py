import math


def cocktailsort(item):
    swapped = True
    n = len(item)
    start = 0
    end = n - 1
    while swapped:
        swapped = False
        for i in range(start, end):
            if item[i] > item[i+1]:
                item[i], item[i+1] = item[i+1], item[i]
                swapped = True
        if swapped is False:
            break
        swapped = False
        end -= 1
        for i in range(end - 1, start - 1, -1):
            if item[i] > item[i+1]:
                item[i], item[i+1] = item[i+1], item[i]
                swapped = True
        start += 1


def closest_enemies(hero_position, enemy_position):
    calculations = []
    order = []
    ordered_list = []
    for i in (enemy_position):
        distance = math.sqrt(((i[0] - hero_position[0])**2 +
                             ((i[1] - hero_position[1])**2)))
        calculations.append(distance)
    for i in range(len(enemy_position)):
        index = calculations[i], enemy_position[i]
        order.append(index)
    cocktailsort(order)
    for i in range(len(order)):
        ordered_list.append(order[i][1])

    return ordered_list


def main():
    hero_position = (50, 10)
    unordered_list = [(10, 20), (55, 10), (52, 11), (23, -5), (0, 200)]
    print("\n ======= Cocktailsort and Enemies ======= \n")
    print("# Test 1: \n")
    print("Hero Position: {}".format(hero_position))
    print("Unordered List = {}".format(str(unordered_list)))
    print("Expected List = [(52, 11), (55, 10), (23, -5), (10, 20), (0, 200)]")
    print("Actual List:")
    print(closest_enemies(hero_position, unordered_list))


if __name__ == "__main__":
    main()
