from MyModule import reverse_string, find_missing_number, fizz_buzz, is_palindrome

class Main:
    
    print(reverse_string("abcde"))

    print(find_missing_number([1, 2, 4, 6, 3, 7, 8]))

    fizz_buzz()

    print(is_palindrome("aabba"))

    my_list = [10, 20, 30, 40, 50]
# Get elements from index 1 to 3
    result = my_list[1:4]
    print(result)  # Output: [20, 30, 40]


# Create an instance of the Main class to run the code inside __init__
main_instance = Main()