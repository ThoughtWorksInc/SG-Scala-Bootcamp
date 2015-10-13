def isIntIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}

isIntIntMap(Map(1 -> 2))
isIntIntMap(Map("1" -> "2"))


def isStringArray(x:Any) = x match {
  case x:Array[String] => true
  case _ => false
}

isStringArray(Array("hello"))
isStringArray(Array(1))


//hint: type erasure happened at runtime.
//but arrays in java/scala both have type system information
