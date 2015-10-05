//*** Work through by uncommenting each test line by line...
//*** 1) Design objects, classes and traits to give a DSL for working with different measures

//assert(Distance(1.0, Metre) < Distance(2.0, Metre))

//assert(Distance(13, Inch) > Distance(1, Foot))

//assert(Distance(12, Inch).toMetres - Distance(1, Foot).toMetres < 1e-10)


//*** 2) Use the type system to prevent different measures (time and distance) from being compared
//*** The following should not compile

// Distance(1.0 Metre) < Time(1.0, Second)

//*** 3) Bonus points - use the "pimp my library pattern"

//assert(2000 Metre > 1 Kilometre)