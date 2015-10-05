import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Try}

val output = scala.collection.mutable.Seq("start")
case class User(id: Int, name: String, friendsIds: Seq[Int])

object UserStore {
  private val users = Map(
    1 -> User(1, "Obi One", Seq(2)),
    2 -> User(2, "Number 2", Seq.empty),
    3 -> User(3, "Trinity", Seq(1))
  )

  def load(id: Int): Future[User] = {
    Future {
      Thread.sleep(100)
      users(id)
    }
  }
}

def out(s: String) = output :+ s
//
//def printFuture(future: Future[User]) = {
//  future.value match {
//    case None => println("not completed")
//    case Some(Failure(e)) => println(s"future completed with exception: $e")
//    case Some(Success(u)) => println(s"future completed with user: $u")
//  }
//}
//val unknownUser = UserStore.load(123)
//printFuture(unknownUser)
Thread.sleep(200)
//printFuture(unknownUser)

UserStore.load(2)
         .map( u => out(u.name) )
         .onFailure{case e => out(e.toString)}

Thread.sleep(200)
output.foreach(println)
output.toList
//val user = UserStore.load(1)
//printFuture(user)
//Thread.sleep(200)
//printFuture(user)
//
//
//val userName: Future[String] = user.map( u => u.name ).recover{ case e => "unknown" }
//
//user.onSuccess({ u})
//
//user.map(j => print("Loaded user " + j.name) )
