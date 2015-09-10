abstract class MyParentClass {
  def stringRepresentation: String
}

class MyClass(argument1: Int, argument2: String) extends MyParentClass {
  val myField = 1 //public field

  private[bootcamp] val packagePrivateField = 2 //can be accessed from within bootcamp

  private val myPrivateField = 3 //private field

  protected val myProtectedField = 4 //protected field, available for subclasses

  //a method, executed everytime it is called
  def add(number1: Int, number2: Int): Int = number1 + number2

  def subtract(number1: Int, number2: Int): Int = {
    number1 - number2
  }

  //overriding a super class method
  override def stringRepresentation: String = s"${argument1} and ${argument2}"
}

val myClass = new MyClass(123, "Some String")
myClass.toString