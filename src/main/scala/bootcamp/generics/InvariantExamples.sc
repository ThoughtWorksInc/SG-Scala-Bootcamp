abstract class Fruit (name: String)
class Apple extends Fruit("Apple")
class Orange extends Fruit("Orange")

class Box[T <: Fruit](var content: T) {
  def get(): T = content
  def put(f: T): Unit = {
    content = f
  }
}

val box = new Box[Apple](new Apple)
box.put(new Apple)
//box.put(new Orange)
