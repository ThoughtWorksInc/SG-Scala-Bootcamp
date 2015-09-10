//constants
def matchingWithConstants(number: Int): String = {
  number match {
    case 1 | 2 | 3 | 4 => "less than 5"
    case 5 => "5"
    case _ => "greater than 5" //wildcard - catch all
  }
}

//pattern guard
def matchingWithGuard(number: Int): String = {
  number match {
    case i if i>0 && i<5 => "less than 5" //guard condition
    case 5 => "5"
    case _ => "greater than 5"
  }
}

println(matchingWithConstants(3))
println(matchingWithGuard(3))

