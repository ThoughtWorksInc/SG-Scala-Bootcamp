//if/else statement
def isOddNumber(x: Int): Boolean = {
  if(x%2==0) {
    return false
  }
  else {
    return true
  }
}
//short hand if/else
def isEvenNumber(x: Int): Boolean = {
  if(x%2==0) return true
  else return false
}

//nested if/else
def isEvenMultipleOfThree(x: Int): Boolean = {
  if(x%2==0) {
    if(x%3==0) return true
    else return false
  }
  else {
    return false
  }
}

//excercise