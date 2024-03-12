package Characters.Knights;

import Characters.Categories.Marshlander;

public class Squire extends Knight implements Marshlander {
    public static Squire squire;
    private Squire() {
        super("Squire",85,8,9,7,8);
    }

    public static Squire getInstance(){
        if (squire==null){
            squire = new Squire();
        }
        return squire;
    }
    
    
}
