class DynamicArray:
    def __init__(self, capacity: int):
        # Initialize the array with the given capacity
        self.length = 0
        self.capacity = capacity
        self.array = [0] * self.capacity

    def get(self, i: int) -> int: 
        # Get the element at index i
        if 0 <= i < self.length:
            return self.array[i]
        else:
            raise IndexError("Index out of bounds")

    def set(self, i: int, n: int) -> None:
        # Set the element at index i to n
        if 0 <= i < self.length:
            self.array[i] = n
        else:
            raise IndexError("Index out of bounds")

    def pushback(self, n: int) -> None:
        # Append an element to the end of the array
        if self.capacity == self.length:
            self.resize()  # Resize the array if it's full
        self.array[self.length] = n
        self.length += 1

    def popback(self) -> int:
        # Soft delete: Remove and return the last element
        if self.length > 0:
            self.length -= 1
            return self.array[self.length]

    def resize(self) -> None:
        # Double the capacity and copy elements to a new array
        new_capacity = 2 * self.capacity
        new_array = [0] * new_capacity
        for i in range(self.length):
            new_array[i] = self.array[i]
        self.array = new_array
        self.capacity = new_capacity

    def getSize(self) -> int: 
        # Get the number of elements in the array
        return self.length
        
    def getCapacity(self) -> int:
        # Get the current capacity of the array
        return self.capacity