package classstructuremethods;

public class NotteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Gábor Áron");
        note.setTopic("Utolsó ütközet");
        note.setText("Körán sötétedik, még világosban le kell tenni a fegyvert.");

        System.out.println(note.getNoteText());
    }
}
