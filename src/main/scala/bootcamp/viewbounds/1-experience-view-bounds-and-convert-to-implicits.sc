trait Publishable[T] {
  def asWebMarkup: String
}
case class BlogPost(title: String, text: String, stars: Int)

import scala.language.implicitConversions

implicit def blogPostToPublishable(blogPost: BlogPost):Publishable = new Publishable {
  def asWebMarkup: String = {
    """
      |<h2>%s</h2>
      |<div>%s</div>
    """.stripMargin.format(blogPost.title, blogPost.text)
  }
}
trait Publishable2[T] {
  def get: T
  def asWebMarkup: String
}

implicit def blogPostToPublishable2(blogPost: BlogPost):Publishable2[BlogPost] = new Publishable2[BlogPost] {
  def asWebMarkup: String = {
    """
      |<h2>%s</h2>
      |<div>%s</div>
    """.stripMargin.format(blogPost.title, blogPost.text)
  }
  override def get: BlogPost = blogPost
}

class WebPublisher[T <% Publishable] {
  def publish(p: T) = {
    println(p.asWebMarkup)
    println(p.asWebMarkup)
  }
}

//alternatively we can write the above viewbound class as below retaining the
//same behavior
class WebPublisher2[T]
(implicit evidence : (T => Publishable[T])) {
  def publish(p: T) = {
    println(p.asWebMarkup)
    println(p.asWebMarkup)
  }
}

val post = new BlogPost(title = "hi there", text = "large body of text", stars = 10)
val webPublisher = new WebPublisher[BlogPost]
val webPublisher2 = new WebPublisher2[BlogPost]

webPublisher.publish(post)
webPublisher2.publish(post)


//Two problems
// 1. In high volume scenarios publish method creates too many wrapper publishable objects
// 2. Reduces ability to compose methods in interesting ways
