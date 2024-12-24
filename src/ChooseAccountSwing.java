import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ChooseAccountSwing {
    public JFrame frame;
    public JButton Warrior;
    public JButton Mage;
    public JButton Rogue;
    //public Warrior warrior;
    //public Mage mage;
    //public Rogue rogue;

    public ChooseAccountSwing(JFrame frame) {
        this.frame = frame;
        this.Warrior = new JButton(Game.getInstance().selectedAccount.characters.get(0).toString());
        this.Mage = new JButton(Game.getInstance().selectedAccount.characters.get(1).toString());
        this.Rogue = new JButton(Game.getInstance().selectedAccount.characters.get(2).toString());
        this.Warrior.setBounds(30, 100, 300, 25);
        this.Mage.setBounds(30, 130, 300, 25);
        this.Rogue.setBounds(30, 160, 300, 25);
        frame.add(this.Warrior);
        frame.add(this.Mage);
        frame.add(this.Rogue);
        frame.setLayout(null);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                frame.dispose();
            }
        });

        this.Warrior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().w = new Warrior(Game.getInstance().selectedAccount.characters.get(0).name, Game.getInstance().selectedAccount.characters.get(0).level, Game.getInstance().selectedAccount.characters.get(0).XP);
                Game.getInstance().player = Game.getInstance().w;
                genMap("Main");

                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                MainMapSwing m = new MainMapSwing(frame);
                m.show();
            }
        });
        this.Mage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().m = new Mage(Game.getInstance().selectedAccount.characters.get(1).name, Game.getInstance().selectedAccount.characters.get(1).level, Game.getInstance().selectedAccount.characters.get(1).XP);
                Game.getInstance().player = Game.getInstance().m;
                genMap("Main");
            }
        });
        this.Rogue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.getInstance().r =  new Rogue(Game.getInstance().selectedAccount.characters.get(2).name, Game.getInstance().selectedAccount.characters.get(2).level, Game.getInstance().selectedAccount.characters.get(2).XP);
                Game.getInstance().player = Game.getInstance().r;
                genMap("Main");
            }
        });

    }

    public void genMap(String s) {
        int xx = -1;
        int yy = -1;
        boolean ver = false;
        boolean exit = false;
        Random rand = new Random();
        int px = rand.nextInt(5) + 5;
        int py = rand.nextInt(5) + 5;

        if(s.equals("Main"))
            Game.getInstance().Map = Grid.Generation(px, py);
        else {
            px = 5;
            py = 5;
            Game.getInstance().Map = Grid.Generation(5, 5);
            for (int i = 0; i < px; i++)
                for (int j = 0; j < py; j++)
                    Game.getInstance().Map.get(i).get(j).type = CellEntityType.VOID;
            Game.getInstance().Map.get(0).get(0).type = CellEntityType.PLAYER;
            Game.getInstance().Map.get(0).get(3).type = CellEntityType.SANCTUARY;
            Game.getInstance().Map.get(3).get(0).type = CellEntityType.SANCTUARY;
            Game.getInstance().Map.get(1).get(3).type = CellEntityType.SANCTUARY;
            Game.getInstance().Map.get(4).get(3).type = CellEntityType.SANCTUARY;
            Game.getInstance().Map.get(3).get(4).type = CellEntityType.ENEMY;
            Game.getInstance().Map.get(4).get(4).type = CellEntityType.PORTAL;
        }



        for (int i = 0; i < px; i++)
            for (int j = 0; j < py; j++) {
                if(Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER) {
                    xx = i;
                    yy = j;
                }
            }

        Game.getInstance().Map.cell = new Cell(xx, yy, CellEntityType.PLAYER, 2);
    }

    public void show() {
        frame.setVisible(true);
    }

}
