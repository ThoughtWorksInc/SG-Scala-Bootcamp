//Scala Option[T] is a container for zero or one element of a given type.
//An Option[T] can be either Some[T] or None object, which represents a missing value.
object Animal {
  //apply method give you a nice syntactic sugar for when a class or object has one main use
  def apply(animalType:String, name: String): Option[Animal] = {
    if(animalType.toLowerCase == "cat") return Some(new Cat(name))
    if(animalType.toLowerCase == "dog") return Some(new Dog(name))
    None
  }
}

abstract class Animal(val name: String)
class Cat(override val name: String) extends Animal(name)
class Dog(override val name: String) extends Animal(name)

//Calling code, note how we construct the animal... this is the result of using apply
val cat = Animal("cat", "Felix")
cat.isDefined //true

val unknownAnimal = Animal("Car", "Lightning McQueen")
unknownAnimal.isEmpty //true
unknownAnimal.isDefined //false
unknownAnimal.get //will throw NoSuchElementException
