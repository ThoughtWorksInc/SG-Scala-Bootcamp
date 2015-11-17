trait BinaryTree[T <: Ordered[T]] {

  def insert(value: T): BinaryTree[T]

  def find(value: T): Option[T]
}

class EmptyTree[T <: Ordered[T]] extends BinaryTree[T] {
  override def insert(value: T): BinaryTree[T] = new NonEmptyTree[T](value, new EmptyTree, new EmptyTree)

  override def find(value: T): Option[T] = None
}

class NonEmptyTree[T <: Ordered[T]](value: T, leftChild: BinaryTree[T], rightChild: BinaryTree[T]) extends BinaryTree[T] {
  override def insert(newValue: T): BinaryTree[T] =
    if (newValue == value) {
      this
    }
    else if (newValue < value) {
      new NonEmptyTree(value, leftChild.insert(newValue), rightChild)
    } else {
      new NonEmptyTree(value, leftChild, rightChild.insert(newValue))
    }

  override def find(targetValue: T): Option[T] =
    if (targetValue == value) {
      Some(targetValue)
    } else if (targetValue < value) {
      leftChild.find(targetValue)
    } else {
      rightChild.find(targetValue)
    }
}