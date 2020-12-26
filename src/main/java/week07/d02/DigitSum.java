package week07.d02;

public class DigitSum {
    public static int sumOfDigits(int value){
        int result=0;
        value=Math.abs(value);

        while(value>0){
            result+=value%10;
            value/=10;
        }
        return result;
    }

    public static int sumOfDigitsWithString(int value) {
        String valueInString = String.valueOf(Math.abs(value));

        int result=0;
        for(int i=0;i< valueInString.length();++i){
            result+=(valueInString.charAt(i)-'0');
        }
        return result;
    }
}
//Készíts egy DigitSum osztályt és benne
// sumOfDigits(int x) metódus
// mely visszaadja a paraméterül kapott szám számjegyeinek összegét!
//
// pl.: 123 esetén a visszatérési érték 6.