class ListNode:
    def __init__(self, val, next_node=None):
        self.val = val
        self.next = next_node

class LinkedList:
    
    def __init__(self):
        self.head = ListNode(-1)      #fake node (dummy node), makes removeing node easier
        self.tail = self.head
    
    def get(self, index: int) -> int:
        current = self.head.next      #current is the fisrt node (after the dummy node)
        for i in range(index):        #jump nodes till you reach the wanted index
            if i == index:
                return current.val
            else:                     #current is set to be the next node
                current = current.next        
        return -1                     #if node was now found (index error)    

    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)      # creating a new node with given val
        new_node.next = self.head     # pushing the head nude as the next node to the new nude
        self.head = new_node          # setting the new node as head of the list

    def insertTail(self, val: int) -> None:
        new_node = ListNode(val)      # creating a new node with given val
        self.tail.next = new_node     # putting the new node at the end of the list (after the tail)
        self.tail = new_node          # making the new node at the tail of the list

    def remove(self, index: int) -> bool:
        current = self.head.next      #current is the fisrt node (after the dummy node)
        for i in range(index):        #jump nodes till you reach the wanted index
            if i == index:
                current = current.next

        if current and current.next:
            if current.next == self.tail:
                self.tail = current
            current.next = current.next.next
            return True
        return False

    def getValues(self) -> List[int]:
        curr = self.head.next
        res = []
        while curr:
            res.append(curr.val)
            curr = curr.next
        return res