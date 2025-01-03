public class Fire extends Spell {
    public Fire() {
        super("Fire", 20, 30);
    }
    @Override
    public void visit(Entity e) {
        if(e.fire == true) {
            this.damage = 0;
            System.out.println("Entity dodged Fire");
        }
        else
            this.damage = 30;
    }
}
