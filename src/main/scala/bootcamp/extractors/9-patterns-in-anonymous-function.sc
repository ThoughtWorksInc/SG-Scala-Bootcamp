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

def countVersionsOlderThan(major: Int, versionNumbers: Seq[String]) = {
  versionNumbers.filter {case VersionNumber(current_major, _*) => current_major < major }.size
}

assert(countVersionsOlderThan(3, List("1","2", "3.4")) == 2)