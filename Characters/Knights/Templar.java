package Characters.Knights;

import Characters.Categories.SunChildren;

public class Templar extends Knight implements SunChildren {
    public static Templar templar;
    public Templar() {
        super("Templar",155,14,16,12,12);
    }

    public static Templar getInstance(){
        if (templar == null){
            templar=new Templar();
        }
        return templar;
    }


}
