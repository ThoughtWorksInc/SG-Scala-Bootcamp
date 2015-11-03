import collection.mutable.Buffer

val accessors1 = Buffer.empty[() => Int]
val accessors2 = Buffer.empty[() => Int]

val data = Seq(100, 110, 120)
var j = 0
for (i <- 0 until data.length) {
  accessors1 += (() => data(i))
  accessors2 += (() => data(j))
  j += 1
}

//accessors1.foreach(a1 => println(a1()))
//accessors2.foreach(a2 => println(a2()))
