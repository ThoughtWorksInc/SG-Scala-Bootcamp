import com.sun.tools.javac.code.TypeTag

import scala.reflect.runtime.universe._

// this method generate warning during compilation
//def getType[A](xs: List[A]) = xs match {
//  case _: List[String] => "list of strings"
//  case _: List[Int] => "list of integers"
//}

//def getType[A](list:List[A])(implicit tag:TypeTag[A]) = tag.tpe.toString
def getType[A : TypeTag](xs: List[A]) = typeOf[A].erasure.toString

getType(List("a", "b", "c"))
getType(List(1,2,3))
//getType(List(1,2,3))(typeTag[Int])
