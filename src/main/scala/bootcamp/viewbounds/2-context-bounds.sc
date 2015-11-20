//this code converts the view bounds to context bounds

case class BlogPost(title: String, text: String)

class WebPublisher[T : Publishable] {
  def publish(p: T) = {
    val publishable = implicitly[Publishable[T]]
    publishable.asWebMarkup(p)
  }
}

trait Publishable[T] {
  def asWebMarkup(item: T) : String
}

object BlogPostPublishable extends Publishable[BlogPost] {
  def asWebMarkup(item: BlogPost): String = {
    """
      |<h1>%s</h1>
      |<div>%s</div>
    """.stripMargin format(item.title, item.text)
  }
}
