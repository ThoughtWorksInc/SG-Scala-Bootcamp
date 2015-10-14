// 1. Design a IntTree data structure.
// Each 'Node' has an an Int element, a left subtree, and a right subtree:
// There are 'EmptyTree' leaf nodes at the bottom of the tree.
// There are no duplicates
//
//   5
//  / \
// E   6
//    / \
//   E   E

abstract class IntTree

// 2. Use the companion object of Node to allow you to create one element trees easily
// Here is how you could start testing your code

//assert( Node(1) == Node(1, EmptyTree, EmptyTree) )

// 3. Write an insert function
// The tree should be sorted:
// left subtree elems <= node elem <= right subtree elem

//assert(
//  insert(EmptyTree, 1) != EmptyTree
//)
//assert(
//  insert(Node(5), 4) == Node(5, Node(4), EmptyTree)
//)
//assert(
//  insert(Node(5), 6) == Node(5, EmptyTree, Node(6))
//)
//assert(
//  insert(Node(1), 1) == Node(1)
//)

// 4. Write a contains function
// Add more tests this time!

//assert(
//  !contains(EmptyTree, 1)
//)