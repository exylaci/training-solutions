package controlselection.accents;

public class WithoutAccents {

    public char convertToCharWithoutAccents(char c){
        switch (c){
            case 'á': return 'a';
            case 'Á': return 'A';
            case 'é': return 'e';
            case 'É': return 'E';
            case 'í': return 'i';
            case 'Í': return 'I';
            case 'ó','ö','ő': return 'o';
            case 'Ó','Ö','Ő': return 'O';
            case 'ú','ü','ű': return 'u';
            case 'Ú','Ü','Ű': return 'U';
            default: return c;
        }
    }
}
