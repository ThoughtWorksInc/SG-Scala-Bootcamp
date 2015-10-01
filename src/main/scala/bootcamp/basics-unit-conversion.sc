abstract class DistanceUnit(val inMetres: Double)

object Metre extends DistanceUnit(1.0)
object Kilometre extends DistanceUnit(1000.0)
object Inch extends DistanceUnit(0.0254)
object Foot extends DistanceUnit(0.3048)

case class Distance(value: Double, unit: DistanceUnit) extends Ordered[Distance] {
  override def compare(that: Distance) = this.toMetres.compare(that.toMetres)
  def toMetres: Double = value * unit.inMetres
}

assert(
  Distance(1.0, Metre) < Distance(2.0, Metre)
)

assert(
  Distance(13, Inch) > Distance(1, Foot)
)

assert(
  Distance(12, Inch).toMetres - Distance(1, Foot).toMetres < 1e-10
)

