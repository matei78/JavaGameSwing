public abstract class Spell implements Visitor {
    public String name;
    public int minMana;
    public int damage;
    public Spell(String name, int minMana, int damage) {
        this.name = name;
        this.minMana = minMana;
        this.damage = damage;
    }

    public boolean equals(Object obj) {
        Spell spell = (Spell)obj;
        return this.name.equals(spell.name);
    }

    public String toString() {

        return this.name + " " + this.minMana + " " + this.damage;
    }
}
