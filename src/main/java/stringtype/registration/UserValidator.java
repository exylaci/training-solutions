package stringtype.registration;

public class UserValidator {

    public static boolean isValidUsername(String username){
        return username.length()>0?true:false;
    }

    public static boolean isValidPassword(String password1,String password2){
        return password1.equals(password2) && password1.length()>=8 ? true : false;
    }

    public static boolean isValidEmail(String email){
        if (email.length()<5 ||
            email.indexOf("@")<1 ||
            email.indexOf(".")-email.indexOf("@")<2 ||
            email.length()-email.indexOf(".")<2
            )
            {
                return false;
            }else
            {
                return true;
            }
    }
}
