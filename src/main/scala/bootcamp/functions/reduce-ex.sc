def reduce(list: List[Int], reducer: (Int, Int) => Int): Int = ???

def max(a: Int, b: Int) =
  if (a > b) a
  else b

// tests might be incomplete!

assert(
  reduce(List(1,2,3), max) == 3
)

assert(
  reduce(1 :: 2 :: 3 :: Nil, _ + _) == 6
)

