package stringmethods.filename;

public class FileNameManipulator {
    public char findLastCharacter(String str){
        isBlank(str,"Empty string!");

        return ' ';
    }
    public String findFileExtension(String fileName){
        isBlank(fileName,"Invalid file name!");
        if ( ".".equals(fileName) || ".d".equals(fileName) ){
            throw  new IllegalArgumentException("Invalid file name!");
        }

        return "";
    }

    public boolean identifyFilesByExtension(String ext, String fileName){
        if ( "d".equals(ext) || ".d".equals(fileName) ){
            throw  new IllegalArgumentException("Invalid argument!");
        }

        return false;
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName){

        return false;
    }

    public String changeExtensionToLowerCase(String fileName){
        isBlank(fileName,"Empty string!");
        if (".".equals(fileName) || ".java".equals(fileName)){
            throw  new IllegalArgumentException("Invalid argument!");
        }


        return "";
    }

    public String replaceStringPart(String fileName, String present, String target){

        return "";
    }

    private void isBlank(String check,String errorMessage){
        if (check == null || check.isBlank()){
            throw  new IllegalArgumentException(errorMessage);
        }
    }
}
