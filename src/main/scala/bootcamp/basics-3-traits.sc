//Traits are similar to Java Interface but can be partially implemented
trait Comparable {
  def compareTo(other: Comparable): Int = 2
  def isTheSame(other: Comparable) = compareTo(other) == 0
}

class Centipede(val numberOfLegs:Int) extends Comparable {
  override def compareTo(other: Comparable): Int = {
    if (other.isInstanceOf[Centipede]) {
      val otherCentipede: Centipede = other.asInstanceOf[Centipede]
      return numberOfLegs - otherCentipede.numberOfLegs
    }
    1
  }
}

val myCentipede = new Centipede(3)
val otherCentipede = new Centipede(4)
myCentipede.isTheSame(otherCentipede) //returns false
