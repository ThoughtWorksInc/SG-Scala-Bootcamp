//abstract class DistanceUnit(val inMetres: Double)
//
//object Metre extends DistanceUnit(1.0)
//object Kilometre extends DistanceUnit(1000.0)
//object Inch extends DistanceUnit(0.0254)
//object Foot extends DistanceUnit(0.3048)
//
//case class Distance(value: Double, unit: DistanceUnit) extends Ordered[Distance] {
//  override def compare(that: Distance) = this.toMetres.compare(that.toMetres)
//  def toMetres: Double = value * unit.inMetres
//}
//
//assert(
//  Distance(1.0, Metre) < Distance(2.0, Metre)
//)
//
//assert(
//  Distance(13, Inch) > Distance(1, Foot)
//)
//
//assert(
//  Distance(12, Inch).toMetres - Distance(1, Foot).toMetres < 1e-10
//)

abstract class Unit[T](val scale: Double)

abstract class Measure[T] extends Ordered[Measure[T]] {
  def value: Double
  def unit: Unit[T]

  def compare(that: Measure[T]): Int =
    this.toStandard.compare(that.toStandard)

  def toStandard: Double =
    value * unit.scale
}

case class Distance(value: Double, unit: Unit[Distance]) extends Measure[Distance]

object Metre extends Unit[Distance](1.0)
object Kilometre extends Unit[Distance](1000.0)
object Inch extends Unit[Distance](0.0254)
object Foot extends Unit[Distance](0.3048)

implicit class DistanceSugar(value: Double) {
  def metre = Distance(value, Metre)
  def kilometre = Distance(value, Kilometre)
  def inch = Distance(value, Inch)
  def foot = Distance(value, Foot)
}

case class Time(value: Double, unit: Unit[Time]) extends Measure[Time]

object Second extends Unit[Time](1.0)
object Minute extends Unit[Time](60.0)
object Hour extends Unit[Time](3600)

implicit class TimeSugar(value: Double) {
  def second = Time(value, Second)
  def minute = Time(value, Minute)
  def hour = Time(value, Hour)
}

//*** Work through by uncommenting each test line by line...
//*** Design objects, classes and traits to give a DSL
//*** for working with different measures
//*** NOTE: You can use a different syntax if you like!

assert(Distance(1.0, Metre) < Distance(2.0, Metre))

assert(Distance(13, Inch) > Distance(1, Foot))

assert(Distance(12, Inch).toStandard - Distance(1, Foot).toStandard < 1e-10)

//*** Extend your type system to allow other measures

assert(Time(30.0, Second) < Time(1, Minute))

//*** Use the type system to prevent different measures (time and distance) from being compared


//*** SHOULD NOT COMPILE:
//Distance(1.0, Metre) < Time(1.0, Second)

//*** Bonus points - use the "pimp my library pattern"

assert(2000.0.metre > 1.0.kilometre)

