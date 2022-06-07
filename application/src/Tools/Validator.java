package Tools;

public class Validator {

    public boolean stringEntry(String entry) {
        boolean result = false;
        int lenght = entry.length();
        if (lenght <2) {
            System.out.println("trop petit");
        } else if(lenght>150) {
            System.out.println("nop");
        } else {
            result = true;
        }
        return result;
    }
    
    public boolean numericEntry(float entry) {
        boolean result = false;
        if (entry <= 0) {
            System.out.println("valeur négative ou nulle impossible");
        } else if(entry>1000000) {
            System.out.println("trop élevée");
        } else {
            System.out.println("ok");
            result = true;
        }
        return result;
    }
    
}
