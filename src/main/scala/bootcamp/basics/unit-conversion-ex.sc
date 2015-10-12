//*** Work through by uncommenting each test line by line...
//*** Design objects, classes and traits to give a DSL
//*** for working with different measures
//*** NOTE: You can use a different syntax if you like!

//assert(Distance(1.0, Metre) < Distance(2.0, Metre))

//assert(Distance(13, Inch) > Distance(1, Foot))

//assert(Distance(12, Inch).toStandard - Distance(1, Foot).toStandard < 1e-10)

//*** Extend your type system to allow other measures

//assert(Time(30.0, Second) < Time(1, Minute))

//*** Use the type system to prevent different measures (time and distance) from being compared


//*** SHOULD NOT COMPILE:
//Distance(1.0, Metre) < Time(1.0, Second)

//*** Bonus points - use the "pimp my library pattern"

//assert(2000.0.metre > 1.0.kilometre)

