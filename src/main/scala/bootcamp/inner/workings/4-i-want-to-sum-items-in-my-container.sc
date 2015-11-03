def sumOfSizes(container: Iterable[Iterable[_]]) = {
  container.map(x => x.size).sum
}

//sumOfSizes(List(Array(1,2,3), List(2,4), Set(10,12)))
//sumOfSizes(Set(Array(1,2,3), List(2,4), Set(10,12)))

