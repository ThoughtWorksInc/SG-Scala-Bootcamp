class Person {
  private var privateName = ""

  def name = privateName

  def name_=(value: String) = privateName = value
}

//
//author intended to create a private field, solution is to modify the access modifier
// from private var to private[this] var
//
