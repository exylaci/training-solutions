package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    ClassRecords classRecords;
    List<Subject> subjects = new ArrayList<>();
    List<Tutor> tutors = new ArrayList<>();


    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();

        Scanner scanner = new Scanner(System.in);
        String selection;
        do {
            schoolRecordsController.showMenu();
            selection = scanner.nextLine().trim();
            switch ( selection ){
                case "1":
                    schoolRecordsController.listStudentNames();
                    break;
                case "2":
                    schoolRecordsController.findStudentByName();
                    break;
                case "3":
                    schoolRecordsController.addStudent();
                    break;
                case "4":
                    schoolRecordsController.removeStudent();
                    break;
                case "5":
                    schoolRecordsController.repetition();
                    break;
                case "6":
                    schoolRecordsController.calculateClassAverage();
                    break;
                case "7":
                    schoolRecordsController.calculateClassAverageBySubject();
                    break;
                case "8":
                    schoolRecordsController.listStudyResults();
                    break;
                case "9":
                    schoolRecordsController.calculateAverage();
                    break;
                case "10":
                    schoolRecordsController.calculateSubjectAverage();
                    break;
            }
        }while ( !"11".equals(selection) );
    }

    private void listStudentNames(){
        try {
            System.out.println( classRecords.listStudentNames() );
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void findStudentByName(){
        try {
            System.out.println( askStudent() );
        }catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private Student askStudent() throws IllegalArgumentException, IllegalStateException{
        System.out.printf("diák neve (%s): ",classRecords.listStudentNames());
        return classRecords.findStudentByName( new Scanner(System.in).nextLine().trim() );
    }

    private void addStudent(){
        System.out.println("diák neve:");
        try {
            if ( classRecords.addStudent( new Student( new Scanner(System.in).nextLine().trim() ))){
                System.out.println("Sikeresen felvettük.");
            }else{
                System.out.println("Már van ilyen nevű diák!");
            }
        }catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void removeStudent(){
        try {
            System.out.printf("diák neve (%s): ",classRecords.listStudentNames());
            if ( classRecords.removeStudent( new Student( new Scanner(System.in).nextLine().trim() ))){
                System.out.println("Sikeresen töröltük.");
            }else{
                System.out.println("Nem tudtam törölni.");
            }
        }catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void repetition(){
        Student student = null;
        try {
            student = classRecords.repetition();
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
            return;
        }
        System.out.println("A vizsgázó: " + student.getName());

        MarkType markType = askMarkType();
        Subject subject = askSubject();
        Tutor tutor = askTutor();

        try {
            student.grading( new Mark( markType,subject,tutor) );
        } catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private MarkType askMarkType(){
        Scanner scanner = new Scanner(System.in);
        MarkType markType = null;
        do {
            System.out.printf("Osztályzat %s: ",Arrays.deepToString( markType.values() ));
            String answer = scanner.nextLine().toUpperCase().trim();
            try {
                markType = MarkType.valueOf(answer);
            }catch (IllegalArgumentException exception){
                System.out.println("Nincs ilyen osztályzat!");
            }
        } while (markType==null);
        return markType;
    }

    private Subject askSubject(){
        Scanner scanner = new Scanner(System.in);
        Subject subject = null;
        do {
            System.out.printf("Tantárgy %s: ",subjects);
            String answer = scanner.nextLine().trim();
            for ( Subject one : subjects ){
                if( one.getSubjectName().equals(answer)){
                    subject=one;
                    break;
                }
            }
        } while (subject==null);
        return subject;
    }

    private Tutor askTutor(){
        Scanner scanner = new Scanner(System.in);
        Tutor tutor = null;
        do {
            System.out.printf("Tanár %s: ",tutors);
            String answer = scanner.nextLine().trim();
            for ( Tutor one : tutors ){
                if( one.getName().equals(answer)){
                    tutor=one;
                    break;
                }
            }
        } while (tutor==null);
        return tutor;
    }

    private void calculateClassAverage(){
        try {
            System.out.println("Az osztály átlaga: "+ classRecords.calculateClassAverage() );
        }catch (ArithmeticException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void calculateClassAverageBySubject(){
        Subject subject = askSubject();
        try {
            System.out.println("Az osztály átlaga: "+ classRecords.calculateClassAverageBySubject(subject) );
        }catch (ArithmeticException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void listStudyResults(){
        try {
            System.out.println(classRecords.listStudyResults());
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void calculateAverage(){
        try {
            System.out.println("Tanulmányi átlaga: " + askStudent().calculateAverage() );
        }catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void calculateSubjectAverage(){
        try {
            Student student = askStudent();
            Subject subject = askSubject();
            System.out.println("Tanulmányi átlaga: " + student.calculateSubjectAverage(subject) );
        }catch (IllegalArgumentException exception){
            System.out.println("Hiba: "+exception);
        }catch (IllegalStateException exception){
            System.out.println("Hiba: "+exception);
        }
    }

    private void showMenu(){
        System.out.println("\n" +
                " 1. Diákok nevének listázása\n" +
                " 2. Diák név alapján keresése\n" +
                " 3. Diák létrehozása\n" +
                " 4. Diák név alapján törlése\n" +
                " 5. Diák feleltetése\n" +
                " 6. Osztályátlag kiszámolása\n" +
                " 7. Tantárgyi átlag kiszámolása\n" +
                " 8. Diákok átlagának megjelenítése\n" +
                " 9. Diák átlagának kiírása\n" +
                "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "11. Kilépés");
    }

    private void initSchool(){
        subjects.add( new Subject("földrajz"));
        subjects.add( new Subject("matematika"));
        subjects.add( new Subject("zene"));
        subjects.add( new Subject("fizika"));
        subjects.add( new Subject("kémia"));

        Tutor tutor1 = new Tutor("Nagy Csilla",
                Arrays.asList(
                        new Subject("földrajz"),
                        new Subject("zene"),
                        new Subject("matematika"),
                        new Subject("biológia")
                ));
        tutors.add(tutor1);
        Tutor tutor2 = new Tutor("Németh László",
                Arrays.asList(new Subject("földrajz"),
                        new Subject("matematika"),
                        new Subject("fizika"),
                        new Subject("kémia")
                ));
        tutors.add(tutor2);

        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor1));
        firstStudent.grading(new Mark(MarkType.B, new Subject("matematika"), tutor1));
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor2));
        secondStudent.grading(new Mark(MarkType.B, new Subject("biológia"), tutor1));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor2));
        secondStudent.grading(new Mark(MarkType.F, new Subject("zene"), tutor1));
        thirdStudent.grading(new Mark(MarkType.B, new Subject("fizika"), tutor2));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("kémia"), tutor2));
        thirdStudent.grading(new Mark(MarkType.F, new Subject("földrajz"), tutor1));

        classRecords = new ClassRecords("Fourth Grade A", new Random() );
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }
}
