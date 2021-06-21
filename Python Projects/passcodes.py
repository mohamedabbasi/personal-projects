import random

alphabets = "abcdefghijklmnopqrstuvwxyz"
numbers = "0123456789"
symbols = "~!@#$%^&*()_-+={[}]|<,>.?/"

mix = alphabets + alphabets.upper() + numbers + symbols
passcodes = []
accounts = ["Twitter", "Instagram", "Facebook", "Github", "Netflix"]

for i in range(len(accounts)):
    passcodes.append("".join(random.sample(mix, 15)))
    print(f"{accounts[i]}'s password: {passcodes[i]}")
