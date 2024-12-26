import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class BattleSwing {

    public JFrame frame;
    public JDialog dialog;
    public JLabel chHealth;
    public JLabel chMana;
    public JLabel enHealth;
    public JLabel enMana;
    public JLabel chImg;
    public JLabel enImg;
    public JButton defaultAttack;
    public JButton abilityAttack;
    public JButton exit;
    public JLabel status;
    public Enemy enemy;

    public BattleSwing(JFrame frame) {
        this.enemy = new Enemy();

        this.frame = frame;
        this.dialog = new JDialog(frame, "Battle", true);
        dialog.setSize(600,600);
        dialog.setLocationRelativeTo(frame);

        this.exit = new JButton("Exit");
        this.status = new JLabel("status");
        this.chHealth = new JLabel("Health: " + Game.getInstance().player.currentHealth);
        this.chMana = new JLabel("Mana: " + Game.getInstance().player.currentMana);
        this.enHealth = new JLabel("Health: " + this.enemy.currentHealth);
        this.enMana = new JLabel("Mana: " + this.enemy.currentMana);
        this.defaultAttack = new JButton("Default");
        this.abilityAttack = new JButton("Ability");
        this.chImg = new JLabel();
        this.enImg = new JLabel();
        ImageIcon chIcon = null;
        if(Game.getInstance().player.profession.equals("Warrior"))
            chIcon = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\warrior.jpg");
        else
            if (Game.getInstance().player.profession.equals("Mage")) {
                chIcon = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\mage.jpg");
        } else {
                chIcon = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\rogue.jpg");
        }
         ImageIcon enIcon = new ImageIcon("C:\\Users\\matei\\IdeaProjects\\Tema2\\img\\enemy.jpg");
         this.enImg.setIcon((enIcon));
         this.chImg.setIcon((chIcon));

         this.chHealth.setBounds(10, 500, 200, 25);
         this.chMana.setBounds(10, 530, 200, 25);
         this.enHealth.setBounds(350, 500, 200, 25);
         this.enMana.setBounds(350, 530, 200, 25);
         this.chImg.setBounds(10, 10, 200, 400);
         this.enImg.setBounds(350, 10, 200, 400);
         this.abilityAttack.setBounds(230, 10, 100, 25);
         this.defaultAttack.setBounds(230, 40, 100, 25);
         this.status.setBounds(230, 360, 150, 25);
         this.exit.setBounds(230,390,150,25);
         this.dialog.add(chHealth);
         dialog.add(exit);
         dialog.add(chMana);
         dialog.add(enHealth);
         dialog.add(enMana);
         dialog.add(chImg);
         dialog.add(enImg);
         dialog.add(abilityAttack);
         dialog.add(defaultAttack);
         dialog.add(status);
         dialog.setLayout(null);

         this.defaultAttack.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if(Game.getInstance().player.currentHealth > 0) {
                     status.setText("Executing Default");
                     int dmg = Game.getInstance().player.getDamage(enemy, null);
                     enemy.receiveDamage(dmg);
                     if(enemy.currentHealth > 0)
                         Game.getInstance().EnemyAttack(enemy);
                     if(Game.getInstance().player.currentHealth <= 0) {
                         status.setText("You died");

                     }
                     if(enemy.currentHealth <= 0) {
                         status.setText("You won");
                         dialog.dispose();


                     }

                     chHealth.setText("Health: " + Game.getInstance().player.currentHealth);
                     chMana.setText("Mana: " + Game.getInstance().player.currentMana);
                     enHealth.setText("Health: " + enemy.currentHealth);
                     enMana.setText("Mana: " + enemy.currentMana);

                     dialog.revalidate();
                     dialog.repaint();
                 }
             }
         });
         this.exit.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if(Game.getInstance().player.currentHealth <= 0) {
                     dialog.dispose();
                     frame.getContentPane().removeAll();
                     frame.revalidate();
                     frame.repaint();
                     ChooseAccountSwing c = new ChooseAccountSwing(frame);
                     c.show();
                 }
             }
         });
         this.abilityAttack.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 status.setText("Executing Ability");
                 AbilityChoiceSwing j = new AbilityChoiceSwing(frame);
                 j.show();
             }
         });


    }


    public void show() {
        dialog.setVisible(true);
    }
}
