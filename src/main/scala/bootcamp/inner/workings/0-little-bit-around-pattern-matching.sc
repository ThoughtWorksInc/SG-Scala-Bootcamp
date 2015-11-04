val min = 10
val MAX = 100

def range(marks: Int) = marks match {
  case min => "just passed"
  case MAX => "Ace"
  case _ => "somewhere in between"
}

//what is the output if i uncomment below lines?
//range(20)
