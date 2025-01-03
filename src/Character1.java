import java.util.Random;

public abstract class Character1 extends Entity{
    public String name;
    public String profession;
    public int XP;
    public int level;
    public int Strength;
    public int Charisma;
    public int Dexterity;
    public Enemy currentEnemy;
    public Character1(String name, String profession, int XP, int level, int strength, int charisma, int dexterity) {
        super(100, 100, 10, false, false, false);
        this.name = name;
        this.profession = profession;
        this.XP = XP;
        this.level = level;
        this.Strength = strength;
        this.Charisma = charisma;
        this.Dexterity = dexterity;
    }

    public String getDetails() {
        return this.name + " " + this.profession + " " + this.currentHealth + " " + this.currentMana + " " + this.level + " " + (this.ice?"Ice":"") + " " + (this.earth?"Earth":"") + " " + (this.fire?"Fire":"");
    }

   public String toString() {
        return this.name + " " + this.profession + " " + this.XP + " " + this.level;
   }
    public void UpdateLevel() {
        if(this.XP >= 10) {
            this.level++;
            this.XP = 0;
        }
    }

    public void UpdateAttributes() {
            this.Strength += 2;
            this.Dexterity += 2;
            this.Charisma += 2;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void receiveDamage(int damage) {
        Random rand = new Random();
        int x = rand.nextInt(2);
        if(this.Strength >= 5 && x == 1) {//injumatatesc daca are ca atribute secundare
            damage = damage / 2;
            this.currentHealth = this.currentHealth - damage;
        }
        else
            this.currentHealth = this.currentHealth - damage;
        System.out.println("Player took " + damage + " damage");
    }
    @Override
    public int getDamage(Entity enemy, Spell ability) {
        Random rand = new Random();
        int x = rand.nextInt(2);
        int damage = 0;
        damage = damage + this.DefaultDamageGiven;
        if (this.Dexterity >= 5 && x == 1)
            damage = damage * 2;
        if(this.level > 7)
            damage = damage + 5;
        if(ability == null) {
            return damage;
        }

        enemy.accept(ability);
        damage = damage + ability.damage;
        if(damage > 100)
            damage = 100;
        this.XP = this.XP + 2;
        return damage;
    }

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }
    public int getExperience() {
        return this.XP;
    }
    public int getLevel() {
        return this.level;
    }
}
