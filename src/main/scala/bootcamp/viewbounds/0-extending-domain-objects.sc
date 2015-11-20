
trait Publishable {
  def asWebMarkup: String
}

case class BlogPost(title: String, text: String) extends Publishable{
  def asWebMarkup: String = {
    """
      |<h2>%s</h2>
      |<div>%s</div>
    """.stripMargin.format(title, text)
  }
}

class WebPublisher[T <: Publishable] {
  def publish(p: T) = {
    println(s"class - ${p.getClass}")
    println(p.asWebMarkup)
  }
}

val post = new BlogPost(title = "hi there", text = "large body of text")
val webPublisher = new WebPublisher[BlogPost]
webPublisher.publish(post)
