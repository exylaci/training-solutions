package week04;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.isBlank()){
            throw new IllegalArgumentException("Invalid name: "+fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName){
        int pos = fullName.indexOf(' ');
        if ( pos > 0 ) {
            fullName = firstName + fullName.substring(pos);
        }
    }

    public String getFullName() {
        return fullName;
    }
}
