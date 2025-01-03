public class Earth extends Spell{
    public Earth() {
        super("Earth", 50, 50);
    }
    @Override
    public void visit(Entity e) {
        if(e.earth == true) {
            this.damage = 0;
            System.out.println("Entity dodged Earth");
        }
        else
            this.damage = 50;
    }
}
