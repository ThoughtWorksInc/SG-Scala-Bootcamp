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
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree
case object EmptyTree extends IntTree

// 2. Use the companion object of Node to allow you to create one element trees easily
// Here is how you could start testing your code

object Node{
  def apply(elem: Int): Node =
    Node(elem, EmptyTree, EmptyTree)
}

assert( Node(1) == Node(1, EmptyTree, EmptyTree) )

// 3. Write an insert function
// The tree should be sorted:
// left subtree elems <= node elem <= right subtree elem

def insert(t: IntTree, v: Int): IntTree = t match {
  case EmptyTree => Node(v)
  case Node(e, l, r) if v < e => Node(e, insert(l, v), r)
  case Node(e, l, r) if e < v => Node(e, l, insert(r, v))
  case _ => t
}


assert(
  insert(EmptyTree, 1) != EmptyTree
)
assert(
  insert(Node(5), 4) == Node(5, Node(4), EmptyTree)
)
assert(
  insert(Node(5), 6) == Node(5, EmptyTree, Node(6))
)
assert(
  insert(Node(1), 1) == Node(1)
)

// 4. Write a contains function
def contains(t: IntTree, v: Int): Boolean = t match {
  case EmptyTree => false
  case Node(e, l, r) => e == v || contains(l, v) || contains(r, v)
}

assert(
  !contains(EmptyTree, 1)
)
assert(
  contains(Node(1), 1)
)
assert(
  contains(Node(3, Node(2), Node(4)), 4)
)
assert(
  !contains(Node(3, Node(2), Node(4)), -1)
)
