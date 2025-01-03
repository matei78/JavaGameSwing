public class CharacterFactory {
    public static Character1 getType(String profession, String name, int XP, int level) {
        if(profession.equals("Rogue"))
            return new Rogue(name, XP, level);
        else
            if(profession.equals("Mage"))
                return new Mage(name, XP, level);
            else
                return new Warrior(name, XP, level);
    }

}
