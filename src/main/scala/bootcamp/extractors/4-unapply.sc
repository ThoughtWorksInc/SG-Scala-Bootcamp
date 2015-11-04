object IpAddress {
  def apply(first: Int, second: Int, third: Int, fourth: Int) = {
    new IpAddress(first + "." + second + "." + third + "." + fourth)
  }

  def unapply(ipAddress: IpAddress): Option[(Int, Int, Int, Int)] = {
    val parts = ipAddress.ipString.split('.')
    if (parts.length != 4 || !parts.forall(part => part.matches("\\d+"))) {
      return None
    }
    val nums = parts.map(part => Integer.parseInt(part))
    Some(nums(0), nums(1), nums(2), nums(3))
  }
}
class IpAddress(val ipString: String)


IpAddress(127, 0, 0, 1)
IpAddress.unapply(new IpAddress("127.0.0.1"))
IpAddress.unapply(new IpAddress("Itsy Bitsy Spider"))
IpAddress.unapply(new IpAddress("One.Two.Three.Four"))