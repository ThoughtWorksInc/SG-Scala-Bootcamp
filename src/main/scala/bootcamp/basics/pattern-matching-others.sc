
//other patterns
def matchTest(x: Any): Any = x match {
  case 1 => "one" //constant
  case y: Int => "scala.Int" //type
  case List(1, _, _) => s"List of size 3, starting with 1" //sequence matching of fixed size
  case List(1, _*) => s"List of variable size, starting with 1" //sequence matching of variable length
  case head::tail => s"Sequence with first element ${head}, and tail sequence: ${tail}"
  case _ => s"Something else altogether" //Wild card
  //and more...
}

matchTest(2) //res2: Any = scala.Int
matchTest(1) //res3: Any = one
matchTest(List(1,2,5)) //res9: Any = List of size 3, starting with 1
matchTest(List(1,2,3,4)) //res10: Any = List of variable size, starting with 1
matchTest(List('a', 'b', 'c')) //Sequence with first element a, and tail sequence: List(b, c)