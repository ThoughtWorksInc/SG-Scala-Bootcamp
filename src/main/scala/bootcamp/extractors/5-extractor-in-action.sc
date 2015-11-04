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




def whatIp(ipAddress: IpAddress): String = {
  ipAddress match {
    case IpAddress(127, 0, 0, 1) => "localhost"
    case IpAddress(192, 168, num1, num2) => s"Local: ${num1} . ${num2}"
    case IpAddress(_, _, _, _) => "Regular Ip"
    case _ => "Not Ip!"
  }
}


assert(whatIp(IpAddress(127,0,0,1)) == "localhost")
assert(whatIp(IpAddress(192,168,0,1)) == "Local: 0 . 1")
assert(whatIp(IpAddress(192,168,255,168)) == "Local: 255 . 168")
assert(whatIp(IpAddress(312,54,255,256)) == "Regular Ip")
assert(whatIp("Willie Wonka") == "Not Ip!")