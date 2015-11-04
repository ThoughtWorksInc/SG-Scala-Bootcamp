object VersionNumber {
  def apply(parts: Int*) = {
    parts.mkString(".")
  }
  def unapplySeq(versionNumber: String): Option[Seq[Int]] ={
    val parts = versionNumber.split('.')
    if(!parts.forall(part => part.matches("\\d+"))) return None
    Some(parts.map(part => Integer.parseInt(part)))
  }
}

VersionNumber(1,2,3,4,5,6)
VersionNumber.unapplySeq("1.2.3.4.5.6")
VersionNumber.unapplySeq("Joey Tribiani")

def whatVersion(versionNumber: String):String = {
  versionNumber match {
    case VersionNumber(0, _*) => "In Beta!"
    case VersionNumber(major, nums @ _*) => s"Version ${major} - ${nums.mkString(".")}"
    case _ => "Huh?!?"
  }
}

whatVersion("0.1.2.3")
whatVersion("2")
whatVersion("3.12.34")
whatVersion("Jar Jar Binks")