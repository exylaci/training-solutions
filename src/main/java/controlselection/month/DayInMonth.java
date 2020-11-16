package controlselection.month;

public class DayInMonth {

    public int numberOfDays(int year, String month){
        switch (month.toLowerCase()){
            case "január": return 31;
            case "február": break;
            case "március": return 31;
            case "április": return 30;
            case "május": return 31;
            case "június": return 30;
            case "július": return 31;
            case "augusztus": return 31;
            case "szeptember": return 30;
            case "október": return 31;
            case "november": return 30;
            case "december": return 31;
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
        if ( year%4!=0 || (year%4==0 && year%100==0 && year%400!=0) ){
            return 28;
        }
        return 29;
    }

    public static void main(String[] args) {
        DayInMonth d = new DayInMonth();
        System.out.println(d.numberOfDays(2000,"jaNuár"));
        System.out.println(d.numberOfDays(2000,"feBruár"));
        System.out.println(d.numberOfDays(2000,"máRcius"));
        System.out.println(d.numberOfDays(2000,"áprIlis"));
        System.out.println(d.numberOfDays(2000,"májUs"));
        System.out.println(d.numberOfDays(2000,"júnIus"));
        System.out.println(d.numberOfDays(2000,"júliUs"));
        System.out.println(d.numberOfDays(2000,"augusZtus"));
        System.out.println(d.numberOfDays(2000,"szepteMber"));
        System.out.println(d.numberOfDays(2000,"októbeR"));
        System.out.println(d.numberOfDays(2000,"novEmber"));
        System.out.println(d.numberOfDays(2000,"December"));

        System.out.println();
        System.out.println(d.numberOfDays(1600,"fEbruár"));
        System.out.println(d.numberOfDays(1700,"feBruár"));
        System.out.println(d.numberOfDays(1800,"febRuár"));
        System.out.println(d.numberOfDays(1900,"febrUÁr"));

        System.out.println();
//        System.out.println(d.dayInMonth(2000,""));
    }
}
