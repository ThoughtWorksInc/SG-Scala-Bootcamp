//Consider the following definitions representing trees of integers.
//These definitions can be seen as an alternative representation of IntSet:
abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree
//Complete the following implementations of function contains and insert for
//  IntTree’s.
def contains(t: IntTree, v: Int): Boolean = ???
def insert(t: IntTree, v: Int): IntTree = ???