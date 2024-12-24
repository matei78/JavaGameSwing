import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMapSwing {
    public JFrame frame;
    public JButton North;
    public JButton East;
    public JButton South;
    public JButton West;
    public JPanel MapPanel;
    public JLabel showLevel;
    public JLabel showXP;
    public JLabel showHealth;
    public JLabel showMana;
    public ArrayList<ArrayList<JLabel>> gridCells;

    public MainMapSwing(JFrame frame) {
        this.frame = frame;
        this.MapPanel = new JPanel();
        int x = Game.getInstance().Map.getLength();
        int y = Game.getInstance().Map.getWidth();
        this.gridCells = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            gridCells.add(new ArrayList<>());
            for (int j = 0; j < y; j++) {
                gridCells.get(i).add(new JLabel());
                this.MapPanel.add(gridCells.get(i).get(j));
                if(Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER)
                    this.gridCells.get(i).get(j).setText("P");
                if(Game.getInstance().Map.get(i).get(j).type == CellEntityType.VOID && Game.getInstance().Map.get(i).get(j).status == 1)
                    this.gridCells.get(i).get(j).setText("V");
                if(!(Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER) && !(Game.getInstance().Map.get(i).get(j).type == CellEntityType.VOID && Game.getInstance().Map.get(i).get(j).status == 1))
                    this.gridCells.get(i).get(j).setText("N");

            }
        }

        this.frame.setSize(600,600);
        this.North = new JButton("North");
        this.East = new JButton("East");
        this.South = new JButton("South");
        this.West = new JButton("West");
        this.MapPanel.setBounds(140, 10, 200, 200);
        this.MapPanel.setLayout(new GridLayout(x,y));
        this.frame.add(this.MapPanel);

        String lvl = "Level  " + Game.getInstance().player.level;
        this.showLevel = new JLabel(lvl);
        String xp = "XP  " + Game.getInstance().player.XP;
        this.showXP = new JLabel(xp);
        String health = "Health  " + Game.getInstance().player.currentHealth;
        this.showHealth = new JLabel(health);
        String mana = "Mana  " + Game.getInstance().player.currentMana;
        this.showMana = new JLabel(mana);


        this.North.setBounds(10, 10, 100, 25);
        this.East.setBounds(10, 40, 100, 25);
        this.South.setBounds(10, 70, 100, 25);
        this.West.setBounds(10, 100, 100, 25);

        this.showLevel.setBounds(10, 180, 100, 25);
        this.showXP.setBounds(10, 210, 100, 25);
        this.showHealth.setBounds(10, 240, 100, 25);
        this.showMana.setBounds(10, 270, 100, 25);

        this.frame.add(this.North);
        this.frame.add(this.East);
        this.frame.add(this.South);
        this.frame.add(this.West);
        this.frame.add(this.showLevel);
        this.frame.add(this.showXP);
        this.frame.add(this.showHealth);
        this.frame.add(this.showMana);


    }
    public void show() {
        this.frame.setVisible(true);
    }

}
