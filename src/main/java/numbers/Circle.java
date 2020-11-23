package numbers;

public class Circle {
    public static final float PI = 3.14f;
    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter(){
        return PI * diameter;
    }

    public double area(){
        return PI * Math.pow( diameter / 2. , 2);
    }
}


// Készíts két metódust: az egyik a kör kerületét adja vissza (perimeter()), a másik a területét (area())! Ezek visszatérési típusa lebegőpontos legyen!
//
//Próbáld ki az osztály működését a CircleMain main() metódusában! Készíts két kört és írd ki mindkét kör kerületét és területét! A körök átmérőjét konzolról olvasd be!