import Charactors.Healers.Soother;
import Charactors.Mages.Mage;
import Charactors.Mages.Warlock;
import Charactors.MythicalCreatures.Dragon;

public class Main {
    public static void main(String[] args) {
        Warlock warlock = new Warlock();
        Soother soother = new Soother();
        Dragon dragon = new Dragon();

        System.out.println(warlock.getAttack());
        System.out.println(warlock.getSpeed());
        System.out.println();
        System.out.println(soother.getAttack());
        System.out.println(soother.getSpeed());
        System.out.println();
        System.out.println(dragon.getAttack());
        System.out.println(dragon.getSpeed());
    }
}



