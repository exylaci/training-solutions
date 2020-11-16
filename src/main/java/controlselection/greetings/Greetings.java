package controlselection.greetings;

public class Greetings {

    public void greetings(int hour,int minute){
        if ( hour<5 || (hour==5 && minute>0) || hour>20 || (hour==20 && minute>0) ){
            System.out.println("Jó éjt!");
        }else if( hour<9 ){
            System.out.println("Jó reggelt!");
        }else if( hour<18 || (hour==18 && minute<=30)) {
            System.out.println("Jó napot!");
        }else {
            System.out.println("Jó estét!");
        }
    }

}
//Írj egy metódust, mely paraméterként megkapja az órát és a percet, és
// amennyiben 5:00 után van, köszönjön jó reggelttel,
// 9:00 és 18:30 között jó napottal,
// 20:00-ig jó estéttel,
// majd jó éjttel.