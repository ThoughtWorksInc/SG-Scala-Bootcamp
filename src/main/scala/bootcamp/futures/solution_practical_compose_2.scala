import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global

object solution_practical_compose_2 extends App {

  def longCompute(x: Int):Future[Int] = Future {
    val randomNumber = new Random(1000)
    val seconds: Int = randomNumber.nextInt(10) * 10
    Thread.sleep(seconds)
    x + 1
  }

  def convert(listOfFutures: List[Future[Int]]): Future[List[Int]] = Future {
    val result = scala.collection.mutable.Map[Int, Int]()
    listOfFutures.zipWithIndex.foreach {
      case (future, index) => {
        future.onSuccess {
          case msg => result.put(index, msg)
        }
      }
    }

    listOfFutures.foreach(Await.ready(_, Duration.Inf))
    result.toList.sortBy(_._1).map(_._2)
  }

  val list_of_futures = for {
    x <- List(1,2,3)
  } yield longCompute(x)

  val futureResult = convert(list_of_futures)
  val result = Await.result(futureResult, Duration.Inf)
  println(result)

}

