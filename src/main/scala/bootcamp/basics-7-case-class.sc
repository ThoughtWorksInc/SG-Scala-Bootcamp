sealed abstract class User //sealed keyword means the class cannot be further sub classed (except for cases in the same file)

case class Student(name: String, studentId: String) extends User //no need to use 'val' keyword
case class Admin(name: String, staffId: String) extends User
case class Lecturer(name: String, staffId: String, faculty: String) extends User

val student = Student("Joe Blog", "stu-1234") //don't need the new keyword
val admin = Admin("John Smith", "sta-1234")
val lecturer = Lecturer("Colin Tripp", "sta-1235", "Mathematical Sciences")