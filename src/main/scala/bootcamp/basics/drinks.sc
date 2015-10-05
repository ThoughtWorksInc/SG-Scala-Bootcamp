trait Drink {
  def price: Float
}

class Kopi extends Drink {
  override def price = 1.0f
}

trait C extends Drink {
  abstract override def price = super.price + 0.2f
}

val kopiC = new Kopi with C
kopiC.price

