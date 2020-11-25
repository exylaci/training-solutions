package week05.d3;

import java.util.List;

public class UserValidator {

    public boolean validate(List<User> users){
        for ( User user : users ){
            if ( user.getName()==null || user.getName().isBlank() ){
                throw new IllegalArgumentException("Name cannot be empty!");
            }
            if ( user.getAge()<0 || user.getAge()>120 ){
                throw new IllegalArgumentException("Age must be between 0 and 120!");
            }
        }
        return true;
    }
}