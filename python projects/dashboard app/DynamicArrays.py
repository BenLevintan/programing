class DynamicArray:
    
    def __init__(self, capacity: int):
        self.length = 0
        self.capacity = capacity
        self.array = [0] * self.capacity

    def get(self, i: int) -> int: 
        return self.array[i]
        

    def set(self, i: int, n: int) -> None:
        self.array[i] = n

    def pushback(self, n: int) -> None:
        if self.capacity == self.length:   #check if there enough capacity for another int
            self.resize()
        self.array[self.length] = n
        self.length += 1

    def popback(self) -> int:         #popback but in 'soft delete' method
        if self.length > 0:
            self.length -= 1
            return self.array[self.length]     

    def resize(self) -> None:
        newArray = [0] * (2 * self.capacity)
        for i in range(self.length):
            newArray[i] = self.array[i]
        self.array = newArray
        self.capacity = 2 * self.capacity

    def getSize(self) -> int: 
        return self.length
        
    def getCapacity(self) -> int:
        return self.capacity