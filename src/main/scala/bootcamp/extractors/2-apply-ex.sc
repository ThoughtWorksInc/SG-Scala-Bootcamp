object IpAddress {
  def apply(first: Int, second: Int, third: Int, fourth: Int) = {
    new IpAddress(first + "." + second + "." + third + "." + fourth)
  }
}
class IpAddress(val ipString: String)


//Please implement the following method to ensure the asserts pass
def whatIp(ipAddress: IpAddress): String = ???

assert(whatIp(IpAddress(127,0,0,1)) == "localhost")
assert(whatIp(IpAddress(192,168,0,1)) == "Local: 0 . 1")
assert(whatIp(IpAddress(192,168,255,168)) == "Local: 255 . 168")
assert(whatIp(IpAddress(312,54,255,256)) == "Regular Ip")
assert(whatIp(new IpAddress("Willie Wonka")) == "Not Ip!")