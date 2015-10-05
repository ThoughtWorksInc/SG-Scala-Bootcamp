//Companion objects are declared in the same file and with the same name as the class
//Companion objects can access fields of the normal class (even private one)
object Animal {
  def create(animalType:String, name: String): Animal = {
    if(animalType.toLowerCase == "cat") return new Cat(name)
    if(animalType.toLowerCase == "dog") return new Dog(name)
    throw new IllegalArgumentException("No such animals")
  }
}

abstract class Animal(val name: String)
class Cat(override val name: String) extends Animal(name)
class Dog(override val name: String) extends Animal(name)

//Calling code, note how we construct the animal... this is the result of using apply
val cat = Animal.create("cat", "Felix")
