//for loop with Range
for(i <- (1 to 10)) {
  println(i)
}

//for loop with multiple Ranges
for(i <- (1 until 3); j <- (1 to 2)) {
  println(i+j)
} //prints all combinations of i + j (i.e. 1+1, 1+2, 2+1, 2+2, 3+1, 3+2)

//for loop with collection
val letters = List('a', 'b', 'c', 'd')
for(letter <- letters) {
  println(letter)
}

//for loop with filters
for(i <- (1 to 10) if i%2 == 0) {
  println(i) //prints even numbers
}

//for loop with filters
for(i <- (2 to 10 by 2)) {
  println(i) //prints even numbers
}

//for loop with yield (aka for comprehension, syntactic sugar for "map" and "flatmap")
val evenNumbers = for(i <- (1 to 10) if i % 2 == 0) yield i
//returns a sequence of even numbers, more on for comprehension later
//note.. unlike C#, this is NOT lazy... see later


val condition = false
while(condition) {
  print("doing something")
}

do {
  print("doing something else")
}while(condition)