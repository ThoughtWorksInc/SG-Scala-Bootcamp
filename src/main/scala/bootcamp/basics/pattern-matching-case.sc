//pattern matching with case class
abstract class User
case class Teacher(name: String) extends User
case class Student(name: String, age: Int) extends User
case class Admin(user:User) extends User

def userMatch(user: User): String = user match {
  case Teacher("Mary") => s"Teacher Mary is created" //Case class constructor
  case Teacher(name) => s"Teacher created with name: ${name}" //Case class constructor with argument as a variable
  case Student(_, age) => s"Student created with age: ${age}"//Case class with constructor wildcard and variable
  case Admin(underAgeAdmin @ Student(_, age)) if age < 18 => s"Underage admin: ${underAgeAdmin}" //Variable binding using @ sign
  case somethingElse => s"User: ${somethingElse}"
}

userMatch(Teacher("Mary")) //res4: Any = Teacher Mary is created
userMatch(Teacher("John")) //res5: Any = Teacher created with name: John
userMatch(Student("Joe", 5)) //res6: Any = Student created with age: 5
userMatch(Admin(Student("Sue", 15))) //res7: Any = Underage admin: Student(Sue,15)
userMatch(Admin(Student("Nadia", 19))) //res8: Any = Something else altogether: Admin(Student(Sue,18))