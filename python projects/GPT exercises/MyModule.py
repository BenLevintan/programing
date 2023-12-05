def reverse_string(input_str):
    new_str = ''
    length = len(input_str) 
    while length:
        new_str = new_str + input_str[length - 1]
        length -= 1
    return new_str

def find_missing_number(nums):
    n = len(nums) + 1
    expected_sum = (n+1) * int(n/2) + n%2 * int((n+1)/2)
    print(expected_sum , sum(nums))
    return expected_sum - sum(nums)

def fizz_buzz():   #make better with %3 %5 flags 
    for i in range (1,100):
        if i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        else:
            print(i)

def is_palindrome(s):
    n = len(s)
    for i in range (n // 2):
        if s[i] != s[n - i - 1]:
            return False
    return True