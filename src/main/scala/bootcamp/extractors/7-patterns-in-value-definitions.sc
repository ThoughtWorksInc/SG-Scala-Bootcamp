object VersionNumber {
  def apply(parts: Int*) = {
    parts.mkString(".")
  }
  def unapplySeq(versionNumber: String): Option[(Int, Seq[Int])] ={
    val parts = versionNumber.split('.')
    if(!parts.forall(part => part.matches("\\d+"))) return None

    val version_parts = parts.map(part => Integer.parseInt(part)).toSeq
    Some(version_parts.head, version_parts.tail)
  }
}

val VersionNumber(major, _*) = "1.2.3"
s"My version is ${major}"

val (first, last) = ("John", "Smith")
