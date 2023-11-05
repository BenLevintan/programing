class ListNode:
    def __init__(self, val, next_node=None):
        self.val = val
        self.next = next_node

class LinkedList:
    
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = self.head
    
    def get(self, index: int) -> int:


    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)      # creating a new node with given val
        new_node.next = self.head     # pushing the head nude as the next node to the new nude
        self.head = new_node          # setting the new node as head of the list

    def insertTail(self, val: int) -> None:
        new_node = ListNode(val)      # creating a new node with given val
        self.tail.next = new_node     # putting the new node at the end of the list (after the tail)
        self.tail = new_node          # making the new node at the tail of the list

    def remove(self, index: int) -> bool:
        

    def getValues(self) -> List[int]: