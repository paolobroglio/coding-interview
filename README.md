# Data Structures
## Array
- [x] Implement a vector (mutable array with automatic resizing):
  - [x] Practice coding using arrays and pointers, and pointer math to jump to an index instead of using indexing.
  - [x] New raw data array with allocated memory
    - can allocate int array under the hood, just not use its features
    - start with 16, or if starting number is greater, use power of 2 - 16, 32, 64, 128
  - [x] size() - number of items
  - [x] capacity() - number of items it can hold
  - [x] is_empty()
  - [x] at(index) - returns item at given index, blows up if index out of bounds
  - [x] push(item)
  - [x] insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
  - [x] prepend(item) - can use insert above at index 0
  - [x] pop() - remove from end, return value
  - [x] delete(index) - delete item at index, shifting all trailing elements left
  - [x] remove(item) - looks for value and removes index holding it (even if in multiple places)
  - [x] find(item) - looks for value and returns first index with that value, -1 if not found
  - [x] resize(new_capacity) // private function
    - when you reach capacity, resize to double the size
    - when popping an item, if size is 1/4 of capacity, resize to half

## Linked List
- [x] size() - returns number of data elements in list
- [x] empty() - bool returns true if empty
- [x] value_at(index) - returns the value of the nth item (starting at 0 for first)
- [x] push_front(value) - adds an item to the front of the list
- [x] pop_front() - remove front item and return its value
- [x] push_back(value) - adds an item at the end
- [x] pop_back() - removes end item and returns its value
- [x] front() - get value of front item
- [x] back() - get value of end item
- [x] insert(index, value) - insert value at index, so current item at that index is pointed to by new item at index
- [x] erase(index) - removes singleLinkNode at given index
- [x] value_n_from_end(n) - returns the value of the singleLinkNode at nth position from the end of the list
- [x] reverse() - reverses the list
- [x] remove_value(value) - removes the first item in the list with this value
- [x] Doubly linked list
## Queue
- [x] Implement using linked-list, with tail pointer:
    - enqueue(value) - adds value at position at tail
    - dequeue() - returns value and removes least recently added element (front)
    - empty()
- [x] Implement using fixed-sized array:
    - enqueue(value) - adds item at end of available storage
    - dequeue() - returns value and removes least recently added element
    - empty()
    - full()