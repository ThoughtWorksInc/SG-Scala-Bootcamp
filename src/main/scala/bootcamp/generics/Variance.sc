class Pet
class Cat extends Pet
class PetShop

val a: List[Pet] = List[Cat]()
val b: List[Cat] = List[Pet]()

val getCat: PetShop => Cat = ???
val getPet: PetShop => Pet = getCat



