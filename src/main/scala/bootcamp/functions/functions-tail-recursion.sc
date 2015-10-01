import scala.annotation.tailrec

def factorial(n: BigDecimal): BigDecimal =
  if (n == 0) 1
  else ( n * factorial(n-1) );

try {
  factorial(1000000)
} catch {
  case _: StackOverflowError => "expected"
}

def factorial2(n: BigDecimal): BigDecimal = {
  @tailrec
  def factInner(n: BigDecimal, acc: BigDecimal): BigDecimal = {
    if (n == 0) acc
    else factInner(n - 1, n * acc)
  }
  factInner(n, 1)
}

assert(
  factorial2(0) == 1
)
assert(
  factorial2(1) == 1
)
assert(
  factorial2(3) == 6
)

try {
  factorial2(1000000)
} catch {
  case e: StackOverflowError => throw e
}


//implement with tail recursion
def filter(L: Set[Int], pred: Int => Boolean): Set[Int] = ???

// write your own tests this time!


