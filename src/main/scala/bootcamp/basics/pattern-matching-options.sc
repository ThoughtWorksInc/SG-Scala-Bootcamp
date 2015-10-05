//pattern matching with options
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

def myAnimal(animalType: String, name: String) = {
  val myAnimal = Animal(animalType, name)
  myAnimal match {
    case Some(animal) => s"An animal called ${animal.name} was created"
    case None => "No animals were created"
  }
}
myAnimal("dog", "Toto")
myAnimal("cat", "Felix")
myAnimal("car", "Mater")