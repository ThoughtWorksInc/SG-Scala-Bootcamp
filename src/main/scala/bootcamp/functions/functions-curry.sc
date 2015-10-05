// Partially applied function

def add(a: Int)(b: Int) = a + b

add(5)_

(1 to 2).map(add(5))

def mod(m: Int, x: Int) = x % m

val mod10 = mod(10, _)




