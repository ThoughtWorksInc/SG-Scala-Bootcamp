def isIntIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}

isIntIntMap(Map(1 -> 2))
isIntIntMap(Map("1" -> "2"))

//hint: type erasure happened at runtime.
