//Scala does not have the concept of static, instead it offers singleton objects to group the behaviours

object MyObject {
  def addIntegers(number1: Int, number2: Int): Int = {
    number1 + number2
  }
}

MyObject.addIntegers(1, 2) //Returns 3