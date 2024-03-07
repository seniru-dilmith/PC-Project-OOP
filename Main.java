import Charactors.Archers.*;
import Charactors.Healers.*;
import Charactors.Knights.*;
import Charactors.Mages.*;
import Charactors.MythicalCreatures.*;

public class Main {
    public static void main(String[] args) {
        Warlock warlock = new Warlock();
        Soother soother = new Soother();
        Dragon dragon = new Dragon();
        Squire squire = new Squire();
        Shooter shooter = new Shooter();

        System.out.println(warlock.getAttack());
        System.out.println(warlock.getSpeed());
        System.out.println();
        System.out.println(soother.getAttack());
        System.out.println(soother.getSpeed());
        System.out.println();
        System.out.println(dragon.getAttack());
        System.out.println(dragon.getSpeed());
        System.out.println();
        System.out.println(squire.getAttack());
        System.out.println(squire.getSpeed());
        System.out.println();
        System.out.println(shooter.getAttack());
        System.out.println(shooter.getSpeed());

    }
}



