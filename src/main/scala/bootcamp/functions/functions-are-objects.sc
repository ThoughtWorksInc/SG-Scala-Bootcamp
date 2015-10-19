val add = (x: Int, y: Int) => x + y

val addFunc = new Function2[Int, Int, Int] {
  override def apply(x: Int, y: Int): Int = x + y
}

//Since functions are objects we can inherit from them

class Increment extends Function1[Int,Int] {
  override def apply(v1: Int): Int = v1 + 1
}

val increment = new Increment()

val x = increment(10)

//When you want to do something like above
//You are not adding new behavior to class
//Don't subclass when alias will do

type incrementor = Function[Int, Int]

val incrementByOne : incrementor = new Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 + 1
}

incrementByOne(1)
