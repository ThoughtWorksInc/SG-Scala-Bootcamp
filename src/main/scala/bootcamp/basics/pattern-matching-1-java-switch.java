package main.scala.bootcamp.basics;
//Pattern matching can be thought of as generalized switch
class JavaSwitch {
    public String doSomething(int number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "less than 5";
            case 5:
                return "5";
            default:
                return "greater than 5";
        }
    }
}