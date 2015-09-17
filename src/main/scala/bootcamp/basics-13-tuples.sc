val t = new Tuple2(1, "Apple")
val t2 = (1, "Apple")
val t3 = 1 -> "Apple"

t == t2 // true
t == t3 // true

t._1 // 1
t._2 // "Apple"
t.swap // ("Apple", 1)

val map = Map(1 -> "Apple", 2 -> "Orange")
map.toSeq.head // (1, "Apple")



