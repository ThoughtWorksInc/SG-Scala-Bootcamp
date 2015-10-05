// Write a recursive function that implements exists
// returns true if any element passes the truth-test

def exists(list: List[Int], pred: Int => Boolean): Boolean = ???


def isEven(num: Int) = num % 2 == 0


// these test cases might not be complete!

assert(
  exists(List(1,2,3), isEven)
)
assert(
  !exists(1 :: 3 :: 5 :: Nil, isEven)
)

