class Vehicle(val brand: String) {
}
class Car(brand: String) extends Vehicle(brand) {}

class Workshop[-T <: Vehicle] {
  def repair(v: T) ={}
}

val vehicleWorkShop = new Workshop[Vehicle]

val car = new Car("Honda")
val vehicle = new Vehicle("Ford")

vehicleWorkShop.repair(vehicle)
vehicleWorkShop.repair(car)

val carWorkShop: Workshop[Car] = vehicleWorkShop
