package introcontrol;

public class IntroControl {
    public int substractTenIfGreaterThanTen(int number){
        return number>10 ? number-10 : number;
    }

    public String describeNumber(int number){
        return number == 0 ? "zero" : "not zero";
    }

    public String greetingToJoe(String name){
        return name.equals("Joe") ? "Hello Joe" : "";
    }

    public int calculateBonus(int sale){
        return sale>=1000000 ? sale/10 : 0;
    }

    public int calculateConsumption(int prev, int next){
        return next<prev ?
                10000 + next - prev:
                next - prev ;
    }

    public void printNumbers(int max){
        for (int i=0 ; i<=max ; ++i){
            System.out.printf(i + ", ");
        }
        System.out.println();
    }

    public void printNumbersBetween(int min, int max){
        for (int i=min ; i<=max ; ++i){
            System.out.printf(i + ", ");
        }
        System.out.println();
    }

    public void printNumbersBetweenAnyDirection(int a, int b){
        int step;
        if (a<b) {
            step=1;
        } else {
            step=-1;
        }
        for (int i=a+step ; a<b ? i<b : i>b ; i+=step){
            if (i>0){
                System.out.printf(i +", ");
            }
        }
        System.out.println();
    }

    public void printOddNumbers(int max){
        for (int i=1 ; i<=max ; ++i){
            if(i%2!=0){
                System.out.printf(i + ", ");
            }
        }
        System.out.println();
    }
}
