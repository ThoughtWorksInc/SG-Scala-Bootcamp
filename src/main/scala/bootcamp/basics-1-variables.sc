//Variable Declarations
var mutable = "abc" //Mutable, can be reassigned
mutable = "cde"
val immutable = "abc" //Immutable, cannot be reassigned

//Lazy Val can only be demonstrated in a repel, the worksheet evaluates it straight away.
//Lazy val is evaluated only when it is called, and only evaluated once, and never again
lazy val myLazyVal = s"The time is: ${System.currentTimeMillis()}"

//Type inference:
val aString: String = "huray!!"
val anotherString = "boo hoo hoo"

//Multiple assignments:
val (value1, value2) = ("some string", 123)

