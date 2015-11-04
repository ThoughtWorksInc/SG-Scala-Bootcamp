class MyList{
  def get(index:Int) = { }
  def apply(index:Int) = get(index)
}

val a = new MyList()

//Then the following calls are equivalent:
a.apply(7)
a(7)
a.get(7)

//Some more examples:
def reverse1( word: String ) = word.reverse

val reverse2 = (word:String) => word.reverse

val reverse3 = new Function1[String, String] {
  def apply(word: String):String = word.reverse
}

(reverse1 _).apply("abc")
reverse2.apply("abc")
reverse3.apply("abc")

reverse1("abc")
reverse2("abc")
reverse3("abc")