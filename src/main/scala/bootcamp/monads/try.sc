
import scala.concurrent.Future

case class User(name: String)
case class UserData()

def doAuth(id: String): Future[User]

def lookupUser(user: User): Future[User]

def getUserData(user: User): Future[UserData]

Future("foo").flatMap(doAuth).flatMap(lookupUser).flatMap(getUserData)


