class DynamicArray:
    
    def __init__(self, capacity: int):
        self.length = 0
        self.capacity = 1
        self.array = [None] * self.capacity

    def get(self, i: int) -> int: 
        return self.array[i]
        

    def set(self, i: int, n: int) -> None:
        self.array[i] = n

    def pushback(self, n: int) -> None:
        if self.length == self.capacity:
            self.resize()
        self.array[self.length] = n
        self.length += 1

    def popback(self) -> int: 
        new_array = [None] * (2 * self.capacity)
        for i in range(self.length):
            new_array[i] = self.array[i]
        self.array = new_array
        self.capacity = 2 * self.capacity       

    def resize(self) -> None:
        self.capacity *= 2
        self.length *= 2

    def getSize(self) -> int: 
        return self.length
        
    def getCapacity(self) -> int:
        return self.capacity