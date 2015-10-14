//what is the output of this code?

def guessMyAnimal(animal: String): Unit = {
  val myAnimal = "Cat"
  animal match {
    case myAnimal => println(s"Woo hoo!! It is a ${myAnimal}")
    case _ => println("Boo hoo hoo!! Try again!")
  }
}
