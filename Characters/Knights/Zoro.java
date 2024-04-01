package Characters.Knights;

import Characters.Categories.Highlander;

public class Zoro extends Knight implements Highlander {
    public static Zoro zoro;
    public Zoro(){
        super("Zoro",180,17,16,13,14);
    }

    public static Zoro getInstance(){
        if (zoro == null){
            zoro= new Zoro();
        }
        return zoro;
    }


}
