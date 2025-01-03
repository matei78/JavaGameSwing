import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbilityChoiceSwing {
    public JButton fire;
    public JButton ice;
    public JButton earth;
    public JLabel iceCost;
    public JLabel earthCost;
    public JLabel fireCost;
    public JLabel iceDamage;
    public JLabel earthDamage;
    public JLabel fireDamage;
    public JLabel status;
    public JDialog dialog2;
    public String spell;

    public AbilityChoiceSwing(JFrame frame) {
        this.dialog2 = new JDialog(frame, "Ability", true);
        dialog2.setSize(600,600);
        dialog2.setLocationRelativeTo(frame);
        this.fire = new JButton();
        this.ice = new JButton();
        this.earth = new JButton();
        this.fireCost = new JLabel("Cost: 20");
        this.fireDamage = new JLabel("Damage: 30");
        this.iceCost = new JLabel("Cost: 10");
        this.iceDamage = new JLabel("Damage: 20");
        this.earthCost = new JLabel("Cost: 50");
        this.earthDamage = new JLabel("Damage: 50");
        this.status = new JLabel("");
        ImageIcon f, i ,e;
        f = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\fire.jpg");
        i = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\ice.jpg");
        e = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\earth.jpg");
        this.fire.setIcon(f);
        this.ice.setIcon(i);
        this.earth.setIcon(e);

        this.fire.setBounds(10,10,150,150);
        this.ice.setBounds(170,10,150,150);
        this.earth.setBounds(330,10,150,150);
        this.fireCost.setBounds(10, 180,100,25);
        this.fireDamage.setBounds(10,210,100,25);
        this.iceCost.setBounds(170,180,100,25);
        this.iceDamage.setBounds(170,210,100,25);
        this.earthCost.setBounds(330,180,100,25);
        this.earthDamage.setBounds(330,210,100,25);
        this.status.setBounds(10,450,100,25);
        this.dialog2.add(this.fire);
        this.dialog2.add(this.ice);
        this.dialog2.add(this.earth);
        this.dialog2.add(this.fireCost);
        this.dialog2.add(this.iceCost);
        this.dialog2.add(this.earthCost);
        this.dialog2.add(this.earthDamage);
        this.dialog2.add(this.fireDamage);
        this.dialog2.add(this.iceDamage);
        this.dialog2.add(this.status);
        this.dialog2.setLayout(null);

        this.fire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Game.getInstance().player.Abilities.contains(new Fire()) && Game.getInstance().player.currentMana >= 20) {
                    spell = "Fire";
                    dialog2.dispose();
                }
                else
                {
                    status.setText("Fire Not available");
                }
            }
        });
        this.ice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Game.getInstance().player.Abilities.contains(new Ice()) && Game.getInstance().player.currentMana >= 10) {
                    spell = "Ice";
                    dialog2.dispose();

                }
                else
                    status.setText("Ice Not available");
            }
        });
        this.earth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Game.getInstance().player.Abilities.contains(new Earth()) && Game.getInstance().player.currentMana >= 50) {
                    spell = "Earth";
                    dialog2.dispose();
                }
                else
                    status.setText("Earth Not available");
            }
        });


    }

    public void show(){
        this.dialog2.setVisible(true);
    }


}
