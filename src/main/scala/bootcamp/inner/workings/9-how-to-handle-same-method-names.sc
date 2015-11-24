//how to handle same method situations when mixing two traits with same method name(s)

object People {

  trait Chinese {
    def sayhi = "ni hao"
  }

  trait American {
    def sayhi = "howdy?"
  }
}

//approach 1: simple

class SimplePerson extends People.American {
  import People.Chinese
  def chinesehi = new Chinese {}.sayhi
}

new SimplePerson().sayhi
new SimplePerson().chinesehi

//approach 2: create two singleton objects for chinese and american

object Folks {
  object ChineseFolks extends People.Chinese
  object AmericanFolks extends People.American
}

class Person extends People.American {
  import Folks.ChineseFolks.{sayhi => saychinesehi}
  def chinesehi = saychinesehi
}

val american = new Person().chinesehi
