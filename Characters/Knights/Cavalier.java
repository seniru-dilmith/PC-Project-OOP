package Characters.Knights;

import Characters.Categories.Highlander;

public class Cavalier extends Knight implements Highlander {
    public static Cavalier cavalier;
    public Cavalier() {
        super("Cavalier",110,10,12,7,10);
    }
    public static Cavalier getInstance(){
        if (cavalier == null){
            cavalier = new Cavalier();
        }
        return cavalier;
    }
}
