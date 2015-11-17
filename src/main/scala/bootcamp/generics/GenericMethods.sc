
// this works, it's a normal generic method
//def first[A](t: Tuple2[A, _]): A = t._1

// this does not work, function values cannot have generic types
//val first :Tuple2[A,_] => A  =  ( pair :Tuple2[A,_] ) => pair._1

// this works but we lost type information
//val first :Tuple2[_,_] => _ = ( pair :Tuple2[_,_] ) => pair._1

// this works, it's a method as a function generator
// each call to the method generate a function object with concrete type
def first[A]: Tuple2[A, _] => A = (pair: Tuple2[A, _]) => pair._1

val person = ("Anne", 27)

val name = first(person)
