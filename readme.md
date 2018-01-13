# Data Structures and Algorithms #

<details>
<summary>Data Structure</summary>

<br>

---

<details>
<summary>1. Arrays</summary>

* 1st exercise 
    * Create LinearArray class
        * 2 instance variables (array of integers and integer)
        * method to insert an element at the beginning of the array
        * method to insert an element at the end of the array
        * method to delete an element from an array
        * method to search for an element in an array
        * method to display all array elements
* 2nd exercise 
    * Create Students class
        * 3 instance variables (String firstName, String lastName and integer ID)
    * Create LinearArrayStudents class
        * 2 instance variables (array of integers and integer)
        * method to insert a student at the beginning of the array
        * method to insert a student at the end of the array
        * method to delete a student from an array
        * method to search for an element in an array
        * method to display all array elements
* 3rd exercise
	* Create LinearSortedArray class
        * 2 instance variables (array of integers, integer)
        * method to insert an element in an ordered array
        * method to display all array elements
        * method to search for an element in an ordered array
            * iteratively
            * recursively
            * classic
        * method to delete an element from the ordered array
        
</details>
 
 ---

<details>
<summary>2. Stacks</summary>

* Implement ArrayStack class
* 1st exercise
	* Method to check the parenthese are matching or not
* 2nd exercise 
    * Search in a stack internal method
    * Search in a stack external method
    * display all stack elements
* 3rd exercise 
    *  Stack decompose method into stack of even no. and other for odd no.
* 4th exercise
	* stack sorting asc
* 5th exercise 
	* Cube game check, if the first half is equal to 2nd half of stack
* 6th exercise
	* Reverse a stack internally
	* Reverse a stack externally 
		* destroy original stack
		* keep original stack
		* return original stack reversed
* 7th exercise 
	* Remove elements starting from nth element
	* Remove elements the nth element
* 8th exercise
	* Sort a stack desc

</details>

---

<details>
<summary>3. Stack of Objects</summary>

* Implement StackObject class (like java.util.Stack)
* 1st exercise
	* Method to calculate average gpa for stack of students
* 2nd exercise 
    * transform infix expression to postfix expression **__[failed to implement]__**
* 3rd exercise 
    *  Evaluate a postfix expression **__[failed to implement]__**
* 4th exercise
	* Remove nth element __implemented earlier__
* 5th exercise 
	* Browsing history
        * delete url
        * insert url 
        * get most viewed url
        * remove last url
        * remove urls on date
        * get no. of urls
        * print all urls
* 6th exercise 
    * method to duplicate stack enteries depending upon another stack integers
* 7th exercise    
    * method to check if a word/sentence is palindrome or not
* 8th exercise
    * Implement a class called MySet
* Extras
    * reverse a string
    * check if a word is palindrome
</details>

--- 

<details>
<summary>4. Queues</summary>

* Implement a  Queue Object class
* 1st exercise
    * Mirror a queue (reversed + original)
* 2nd exercise
    * prefix evaluation of expressions
* 3rd exercise
    * implement a queue using stack
* 4th exercise
    * shift zeros in queues to the end
* 5th exercise
    * Extract every 3rd element
* 6th exercise
    * check if word is an anagram
* 7th exercise
    * check if a word is palindrome
* 8th exercise
    * Implement a Deque class
</details>

---

<details>
<summary>5. Priority Queues</summary>

* 1st Exercise 
    * implement YoghutProduct.class & SuperMarket.class
    * YoghurtProduct 3 instance vars (date[key], id, price)
    * SuperMarket insert new yoghurt, calculate discount depending upon its priority
* 2nd Exercise 
    * implement University.class 
    * 2 instance vars (Name, Rank)
    * Key is [rank], if ranks are equal then key is [name] 
* 3rd Exercise
    * Implement Patient.class & EmergencyRoom.class
    * patient instance vars (name, severity [desc])
    * key is severity
</details>

---

<details>
<summary>6. Linked Lists I</summary>

* 1st exercise 
    * implement method to insertLast (external method, internal recursive)
    * implement method to removeLast (external method)
* 2nd exercise 
    * reverse a LinkList (internal, external)
* 3rd exercise 
    * reverse in place (external)
* 4th exercise 
    * remove duplicates from linklist (external method)
* 5th exercise 
    * method to get size of linklist (internal recursive, iterative)
* 6th exercise 
    * mix elements of a linklist (external)
* 7th exercise 
    * cut a link list (external, internal)
* 8th exercise 
    * splitting a list (external)
* 9th exercise 
    * alternating split (external)
* 10th exercise 
    * get max of a list (external)
* 11th exercise 
    * check if linklist contains an obj (external, internal recursive)
* 12th exercise 
    * implement a method to merge two lists (external, internal)
    * implement a method to unite two lists (external, internal)
    * implement a method to get difference between two lists (external, internal)
    * implement a method to get intersection between two lists (external, internal)
    * implement a method to check if two lists are equal or not (external, internal)
    
</details>

---

<details>
<summary>Extra Recursion problems</summary>

* 01 - calculate factorial of a number
* 02 - implement a method to count down.
* 03 - calculate number power
* 04 - calculate natural logarithmic 
* 05 - calculate the multiply of a number
* 06 - calculate the divide of a number
* 07 - calculate the modulus of a number
* 08 - return sum of a number bigger than 2 digits
* 09 - count digits of a number 
* 10 - check if a number is a prime number or not 
* 11 - calculate cube of a number 
* 12 - calculate binominal coefficient 
* 13 - count the number of repitions of a character in string
* 14 - reverse a string 
* 15 - replace a character in a string with a whitespace
* 19 - search for a character in a string, return its index
</details>
 
 ---
 
<details>
<summary>8. LinkedLists II </summary>

* 1st exercise
    
    * implement a circular linked list class
    * implement a method to append a circular linked list to "this"
* 2nd exercise

    * implement a method to insert after a key
    * implement a method to insert before a key
    * implement a method to delete a certain key
    * apply insertion sort on a doubly linked list (iterative, external)
    * implement a method to reverse a doubly linked list (iterative, recursive)
    * implement a method to get count (iterative, recursive, external)
* 3rd exercise

    * implement Queues using DoublyLinkedLists
</details>

---

<details>
<summary>9. Trees I </summary>

* 1st exercise
    
    * implement a method to create a BST of an array
* 2nd  

    * implement a method to get max of a BST (recursive, iterative)
* 3rd exercise 

    * implement a method to get max of a BT (recursive, iterative)
* 4th exercise (recursive)
    
    * implement a method to get size of a BST
    * implement a method to get num of leaves of a BST
    * implement a method to get sum of nodes of BST
    * implement a method to check if the tree is a BST
    * implement a method to number of left nodes of a BST
    * implement a method to number of occurences of a key in BST
    * implement a method to get number of duplicates of a key in BST
    * implement a method to mirror a BST
    * implement a method to get the number of odd nodes in BST
* 5th exercise

    * implement a method to get level of a key in BST
* 6th exercise

    * implement a method to double value of nodes of a BST (recursive)
* 7th exercise

    * implement a method to check if two BSTs are identical (recursive)

</details>


 <br>
 
</details>

---
---

<br>

<details>
<summary>Algorithms</summary>
    Empty so far...
</details>

---
---

![Showing repository hierarchy](https://github.com/elsheikh21/Data-Structures-Algorithms/blob/master/img.png)