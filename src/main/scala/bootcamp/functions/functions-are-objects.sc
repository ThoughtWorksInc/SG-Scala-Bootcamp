val add = (x: Int, y: Int) => x + y

val addFunc = new Function2[Int, Int, Int] {
  override def apply(x: Int, y: Int): Int = x + y
}