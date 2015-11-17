abstract class Fruit (name: String)
class Apple extends Fruit("Apple")
class Orange extends Fruit("Orange")

class Box[T <: Fruit](content: T) {
  def get(): T = content
}

val appleBox = new Box[Apple](new Apple)
val orangeBox = new Box[Orange](new Orange)

val apple: Apple = appleBox.get()
val orange: Orange = orangeBox.get()

class UnsafeBox(content: Fruit) {
  def get(): Fruit = content
}

//val orange2: Orange = new UnsafeBox(new Orange()).get()
