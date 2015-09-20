case class MyBase2Number(x: Int) {
  def +(y: Int) = (x+y) % 2
  def value() = x % 2
  def print() = println(value)
}
//Arity-0 (method with no arguments)
MyBase2Number(3).value()
// then it can be written as
MyBase2Number(3) value

//Arity-1
//Any method which takes a single parameter can be used as an infix operator in Scala
val test = MyBase2Number(3).+(4) //infix notation
val test2 = MyBase2Number(3) + 4 //infix notation
//Scala Integer operators:
1 + 2
1.+(2)

//General guidance
//Infix notations should only be used if there are NO side effects,
//i.e. the function call is purely functional

MyBase2Number(3).value //is OK
MyBase2Number(3).print //is not OK

val myObject = "string"
myObject.toString //OK
println //not OK