package stringmethods.filename;

public class FileNameManipulator {
    public char findLastCharacter(String str){
        isBlank(str,"Empty string!");
        String trimmed = str.trim();
        return trimmed.charAt( trimmed.length()-1 );
    }
    public String findFileExtension(String fileName){
        isBlank(fileName,"Invalid file name!");
        isNoFileName(fileName,"Invalid file name!");
        String trimmed = fileName.trim();
        return trimmed.substring( trimmed.lastIndexOf('.') );
    }

    public boolean identifyFilesByExtension(String ext, String fileName){
        isBlank(ext,"Invalid argument!");
        isBlank(fileName,"Invalid argument!");
        isNoFileName(fileName,"Invalid argument!");
        return ext.trim().equals( findFileExtension(fileName).substring(1) );
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName){
        isBlank(searchedFileName,"Invalid argument!");
        isBlank(actualFileName,"Invalid argument!");
        return searchedFileName.toLowerCase().equals( actualFileName.toLowerCase() );
    }

    public String changeExtensionToLowerCase(String fileName){
        isBlank(fileName,"Empty string!");
        String trimmed = fileName.trim();
        isNoFileName(trimmed,"Invalid argument!");
        int pos = trimmed.lastIndexOf('.');

        return trimmed.substring(0,pos) + trimmed.substring(pos).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target){
        isBlank(fileName,"Empty string!");
        return fileName.replace(present,target);
    }

    private void isBlank(String check,String errorMessage){
        if (check == null || check.isBlank()){
            throw  new IllegalArgumentException(errorMessage);
        }
    }

    private void isNoFileName(String check,String message){
        if ( check.charAt(0) == '.' ){
            throw new IllegalArgumentException(message);
        }
    }
}


