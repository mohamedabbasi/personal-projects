def cachedfibonacci(N, fibonacci_dict={}):
    if N <= 1:
        return N

    if N not in fibonacci_dict:
        value = cachedfibonacci(N - 1) + cachedfibonacci(N - 2)
        fibonacci_dict[N] = value
    return fibonacci_dict[N]


def main():
    print("======= Fibonacci Sequence =======")
    print("Expected value for sequence at N = 2 is 1 \nActual Value is: {}"
          .format(cachedfibonacci(2)))
    print("\nExpected value for sequence at N = 10 is 55 \nActual Value is: {}"
          .format(cachedfibonacci(10)))
    print("\nExpected value for sequence at N = 50 is 12586269025 \nActual Value is: {}"
          .format(cachedfibonacci(50)))
    print("\nExpected value for sequence at N = 100 is 354224848179261915075 \nActual Value is: {}"
          .format(cachedfibonacci(100)))
    print("\nExpected value for sequence at N = 150 is 9969216677189303386214405760200 \nActual Value is: {}"
          .format(cachedfibonacci(150)))


if __name__ == "__main__":
    main()
