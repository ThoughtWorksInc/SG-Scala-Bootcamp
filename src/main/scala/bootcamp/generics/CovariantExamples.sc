
class Vehicle(val brand: String) {
}
class Car(brand: String) extends Vehicle(brand) {}

class Factory[+T <: Vehicle] {

  def produce(brand: String): T =  new T(brand)
}

val carFactory = new Factory[Car]
val vehicle: Vehicle  = carFactory.produce("Ford")
val vehicleFactory : Factory[Vehicle] = new Factory[Car]


var getCarBrand: Function1[Car, String] = (c: Car) => c.brand
var getVehicleBrand: Function1[Vehicle, String] = (v: Vehicle) => v.brand

//getVehicleBrand = getCarBrand
getCarBrand = getVehicleBrand
