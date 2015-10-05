case class User(val id: Int, val name: String)

def parseUser1(input: String): User = {
  val parts: Array[String] = input.split("-")
  if (parts.length != 2) return null

  val idPart = parts(0)
  val namePart = parts(1)
  User(Integer.parseInt(idPart.trim), namePart.trim)
}

def printUser1(user: User): Unit = {
  if (user != null) println(user)
  else println("Invalid User")
}

val obi = parseUser1("1 - Obi One")
val invalid = parseUser1("123 * Joker")

printUser1(obi)
printUser1(invalid)


//rewrite with options
def parseUser2(input: String): Option[User] = ???
def printUser2(maybeUser: Option[User]) = ???

