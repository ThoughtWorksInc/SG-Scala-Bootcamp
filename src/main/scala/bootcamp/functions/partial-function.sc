case class Req(url: String)
case class Res(body: String, status: Int = 200)

type Controller = PartialFunction[Req, Res]

val homeController: Controller = {
  case Req("/home") => Res("Welcome to Scala boot camp!")
}

val userController: Controller = new PartialFunction[Req, Res] {
  override def isDefinedAt(req: Req): Boolean =
    req.url.startsWith("/users")

  override def apply(req: Req): Res = {
    val name = req.url.stripPrefix("/user/")
    Res(s"Hello $name")
  }
}

val articleController: Controller = Map(
  Req("/articles/scala") -> Res("Scala is taking over the world!"),
  Req("/articles/java") -> Res("Java attempts to stay relevant with lambdas")
)

val notFoundController: Controller = {
  case _ => Res("This is not the page you were looking for", 404)
}

val appController: Controller =
  homeController orElse
    userController orElse
    articleController orElse
    notFoundController

appController(Req("/users/fun"))
appController(Req("/articles/scala"))
appController(Req("/articles/java-is-good"))

//translate to normal function with options with "lift"

val normalFunction: Req => Option[Res] =
  articleController.lift

