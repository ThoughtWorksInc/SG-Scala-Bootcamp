//this code converts the view bounds to context bounds

case class BlogPost(title: String, text: String)

class WebPublisher[T : Publishable] {
  def publish(p: T) = {
    val publishable = implicitly[Publishable[T]]
    //publishable is an object i can pass to other methods as well
    //publishable object can be composed with other objects
    //more importantly unlike viewbounds multiple wrapper objects need not be created.
    publishable.asWebMarkup(p)
  }
}

trait Publishable[T] {
  def asWebMarkup(item: T) : String
}

object PublishableBlogPost extends Publishable[BlogPost] {
  def asWebMarkup(item: BlogPost): String = {
    """
      |<h1>%s</h1>
      |<div>%s</div>
    """.stripMargin format(item.title, item.text)
  }
}

implicit val publishableBlogPost = PublishableBlogPost
val post = new BlogPost(title = "hi there", text = "large body of text")
val webPublisher = new WebPublisher[BlogPost]

webPublisher.publish(post)
