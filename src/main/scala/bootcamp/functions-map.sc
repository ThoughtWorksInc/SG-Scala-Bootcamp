
def map(l: List[Int], transform: Int => Int): List[Int] = ???

def double(num: Int) = num * 2

// tests might be incomplete!
assert(
  map(List(1,2,3), double) == List(2,4,6)
)

assert(
  map(List(1,2,3), _ * 3) == List(3,6,9)
)