object IpAddress {
  def apply(first: Int, second: Int, third: Int, fourth: Int) = {
    new IpAddress(first + "." + second + "." + third + "." + fourth)
  }
}
class IpAddress(val ipString: String)




def whatIp(ipAddress: IpAddress): String = {
  val parts = ipAddress.ipString.split('.')
  if (parts.length != 4 || ! parts.forall(part => part.matches("\\d+"))) {
    return "Not Ip!"
  }
  if(ipAddress.equals("127.0.0.1")) return "localhost"
  if(ipAddress.startsWith("192.168")) return s"Local: ${parts(2)} . ${parts(3)}"
  return "Regular Ip"
}

assert(whatIp(IpAddress(127,0,0,1)) == "localhost")
assert(whatIp(IpAddress(192,168,0,1)) == "Local: 0 . 1")
assert(whatIp(IpAddress(192,168,255,168)) == "Local: 255 . 168")
assert(whatIp(IpAddress(312,54,255,256)) == "Regular Ip")
assert(whatIp("Willie Wonka") == "Not Ip!")