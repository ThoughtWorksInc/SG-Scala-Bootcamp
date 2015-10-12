//functions as method
def add(x: Int, y: Int) : Int = {
  x + y
}

//nested functions
def base2Add(i: Int, j: Int): Int = {
  def add(x: Int, y: Int) : Int = {
    x + y
  }
  add(i, j)%2
}

//first class function
val addition = (x: Int, y: Int) => x + y

//higher order function
def base5Operation(x: Int, y: Int, operation: (Int, Int) => Int) = {
  operation(x, y) % 5
}

base5Operation(2, 3, addition)
base5Operation(3, 3, (i: Int, j:Int) => i*j)
