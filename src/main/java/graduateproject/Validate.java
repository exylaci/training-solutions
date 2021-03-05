package graduateproject;


import javax.sql.DataSource;

public class Validate {
    public static final String EMAIL_PATTERN = "[a-z0-9]+[a-z0-9\\.-]*@([a-z0-9-]+\\.)+[a-z]{2,4}";
    public static final String TAJ_PATTERN = "[0-9]{9}";
    public static final int ASCII_CODE_OF_ZERO = 48;

    private DataSource source;

    public Validate(DataSource source) {
        this.source = source;
    }

    public boolean checkAll(Citizen citizen) {
        return checkName(citizen.getName()) ||
                checkZip(citizen.getZip()) ||
                checkAge(String.format("%d", citizen.getAge())) ||
                checkEmail(citizen.getEmail()) ||
                checkTaj(citizen.getTaj());
    }

    public boolean checkName(String name) {
        return name.isBlank() || !name.contains(" ");
    }

    public boolean checkAge(String ageString) {
        if (!ageString.matches("[0-9]{1,3}")) {
            return true;
        }
        int age = Integer.parseInt(ageString);
        return age < 11 || age > 149;
    }

    public boolean checkZip(String zip) {
        return new Logic(source).getCity(zip).equals("");
    }

    public boolean checkEmail(String email) {
        return !email.toLowerCase().matches(EMAIL_PATTERN)
                || email.contains(".@");
    }

    public boolean checkTaj(String taj) {
        if (!taj.matches(TAJ_PATTERN)) {
            return true;
        }

        int sum = 0;
        for (int i = 0; i < taj.length() - 1; ++i) {
            sum += (taj.charAt(i) - ASCII_CODE_OF_ZERO) * (i % 2 * 3 + (i + 1) % 2 * 7);
        }
        return sum % 10 != taj.charAt(8) - ASCII_CODE_OF_ZERO;
    }

    boolean isRegistered(String taj) {
        if (taj.isBlank()) {
            return false;
        }
        try {
            CitizensDao dao = new CitizensDao(source);
            return dao.isRegistered(taj);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Can't read from to CITIZENS data table!", e);
        }
    }
}
