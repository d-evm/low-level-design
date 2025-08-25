// Prototype
interface GameCharacter extends Cloneable{
    GameCharacter clone();
}

// Concrete Prototype
class NPC implements GameCharacter{
    private String type;
    private String weapon;
    private int health;

    NPC (String type, String weapon, int health){
        this.health = health;
        this.type = type;
        this.weapon = weapon;
    }

    @Override
    public GameCharacter clone(){
        return new NPC(this.type, this.weapon, this.health);
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "type='" + type + '\'' +
                ", weapon='" + weapon + '\'' +
                ", health=" + health +
                '}';
    }
}

// Client
public class GamePrototype {
    public static void main(String[] args) {
        NPC soldier = new NPC("Army", "Assault Rifle", 100);

        NPC sniper = (NPC) soldier.clone(); // typecasting because clone() return GameCharacter
        sniper.setWeapon("Rifle");

        System.out.println("Soldier: " + soldier.toString());
        System.out.println("Sniper: " + sniper.toString());
    }
}
