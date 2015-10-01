case class Req(url: String)
case class Res(status: Int, body: String)

type Controller = PartialFunction[Req, Res]

def userController: Controller = {
  case Req("/user") => Res(200, "Hello intrepid user")
}

def articleController: Controller = {
  case Req("/article") => Res(200, "Scala takes over the world")
}

def notFoundController: Controller = {
  case _ => Res(404, "This is not the page you were looking for")
}

val appController: Controller =
  userController orElse articleController orElse notFoundController

val userReq = Req("/user")
val hackReq = Req("/trying/to/find/backdoor")

appController(userReq)
appController(hackReq)