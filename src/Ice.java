public class Ice extends Spell{
    public Ice(){
        super("Ice", 10, 20);
    }
    @Override
    public void visit(Entity e) {
        if(e.ice == true) {
            this.damage = 0;
            System.out.println("Entity dodged Ice");
        }
        else
            this.damage = 20;

    }
}
