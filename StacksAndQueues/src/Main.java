
/* Stacks and queues are some of the simplest forms of data structures in Computer Science.
* They are used in many different algorithms and knowing when and how to use both will help you solve many interview problems.
*
* A stack is a data structure that lets you organize data items only in a certain way.
* Stacks only let you operate on the top. Think about a stack of papers where you can only place a new sheet of paper
* on the top. Similarly, you can only remove items from the top of the stack of papers.
* A stack in Computer Science is similar to this in that it only allows you to place and remove things from the top.
* In technical speak we say we push X to mean adding X to the top of the stack.
* Removing X from the top of the stack is done by calling the pop operation.
* There are two main stack implementations.
* In the first an array can be used as a base to hold the data items. A pointer is then kept pointing
* to the element at the top-most item. Pushing onto the stack, we write an element position represented
* by the pointer and then increment this pointer by 1.
* Popping the stack we read the element just before the pointer position and reduce the value by 1.
* An array implementation of a stack is quite simple to implement. However it's limited in size by the length
* of the array. Once the array is full you cannot add any more items on the stack.
* The solution is to use a linked list based stack which allows the stack to grow dynamically.
* Using a linked list we only allow our creations at the head of the list. Pushing an item results
* in creating a new node at the front or head of the linked list. The popping operation reads
* the node at the head of the list and removes it.
*
* A queue also has two main operations.
* We can add a data item at the tail of the queue or consume an item from the head of the queue.
* We call these two operations simply enqueue and dequeue.
* The main difference between a stack and a queue is the mode in which data is consumed from the data structure.
* In a stack the data that is most recently added is the one that gets read first.
* We call this "lifo" which stands for Last In First Out. In a queue data structure this is the opposite.
* The most recently enqueued is the last one to be dequeued. We say that a queue is "fifo" or First In First Out.
* Implementing a queue is simple and easy if a double linked list is used. The enqueue operation involves
* adding a node containing the data item on the tail of the queue. The dequeue operation is just the opposite.
* It removes the first item at the head of the linked list.
* */


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}