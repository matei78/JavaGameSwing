import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
    public JLabel action;
    public boolean ver;

    public MainMapSwing(JFrame frame) {
        this.ver = false;
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
        this.action = new JLabel("");



        this.North.setBounds(10, 10, 100, 25);
        this.East.setBounds(10, 40, 100, 25);
        this.South.setBounds(10, 70, 100, 25);
        this.West.setBounds(10, 100, 100, 25);

        this.showLevel.setBounds(10, 180, 100, 25);
        this.showXP.setBounds(10, 210, 100, 25);
        this.showHealth.setBounds(10, 240, 100, 25);
        this.showMana.setBounds(10, 270, 100, 25);

        this.action.setBounds(10, 300, 200, 25);

        this.frame.add(this.North);
        this.frame.add(this.East);
        this.frame.add(this.South);
        this.frame.add(this.West);
        this.frame.add(this.showLevel);
        this.frame.add(this.showXP);
        this.frame.add(this.showHealth);
        this.frame.add(this.showMana);
        this.frame.add(this.action);



        this.North.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ver = false;
                try {
                    System.out.println("x: " + Game.getInstance().Map.cell.ox + " y: " + Game.getInstance().Map.cell.oy);
                    Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox - 1
                    ).get(Game.getInstance().Map.cell.oy).type;
                    Game.getInstance().Map.GoNorth();
                    ver = true;
                } catch (ImpossibleMoveException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    //MapPanel.revalidate();
                    //MapPanel.repaint();
                    frame.repaint();
                } catch (IndexOutOfBoundsException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                //Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox - 1).get(Game.getInstance().Map.cell.oy).type;
                if(ver == true)
                    direction(Game.getInstance().nextCell);

                labelCells();
                MapPanel.revalidate();
                MapPanel.repaint();
                frame.repaint();


            }
        });
        this.East.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ver = false;
                try {
                    System.out.println("x: " + Game.getInstance().Map.cell.ox + " y: " + Game.getInstance().Map.cell.oy);
                    Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox).get(Game.getInstance().Map.cell.oy + 1).type;
                    Game.getInstance().Map.GoEast();
                    ver = true;
                } catch (ImpossibleMoveException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (IndexOutOfBoundsException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                if(ver == true)
                    direction(Game.getInstance().nextCell);

                labelCells();
                MapPanel.revalidate();
                MapPanel.repaint();
                frame.repaint();

            }
        });

        this.South.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ver = false;
                try {
                    System.out.println("x: " + Game.getInstance().Map.cell.ox + " y: " + Game.getInstance().Map.cell.oy);
                    Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox + 1
                    ).get(Game.getInstance().Map.cell.oy).type;
                    Game.getInstance().Map.GoSouth();
                    ver = true;

                } catch (ImpossibleMoveException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (IndexOutOfBoundsException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                //Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox - 1).get(Game.getInstance().Map.cell.oy).type;
                if(ver == true)
                    direction(Game.getInstance().nextCell);

                labelCells();
                MapPanel.revalidate();
                MapPanel.repaint();
                frame.repaint();


            }
        });

        this.West.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ver = false;
                try {
                    System.out.println("x: " + Game.getInstance().Map.cell.ox + " y: " + Game.getInstance().Map.cell.oy);
                    Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox
                    ).get(Game.getInstance().Map.cell.oy - 1).type;
                    Game.getInstance().Map.GoWest();
                    ver = true;

                } catch (ImpossibleMoveException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (IndexOutOfBoundsException ex) {
                    action.setText("Impossibler move");
                    action.revalidate();
                    action.repaint();
                    frame.repaint();
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                    action.setText("Impossibler move");
                }
                //Game.getInstance().nextCell = Game.getInstance().Map.get(Game.getInstance().Map.cell.ox - 1).get(Game.getInstance().Map.cell.oy).type;
                if(ver == true)
                    direction(Game.getInstance().nextCell);

                labelCells();
                MapPanel.revalidate();
                MapPanel.repaint();
                frame.repaint();


            }
        });


    }
    public void direction(CellEntityType c) {
        int px = 5;
        int xx = 5, yy = 5;
        int py = 5;
        switch (c) {
            case CellEntityType.SANCTUARY -> {
                //System.out.println("you landed on sanctuary");
                this.action.setText("You landed on sanctuary");
                Random random = new Random();
                int ran = random.nextInt(9) + 1;
                Game.getInstance().player.RegenHealth(ran);
                Game.getInstance().player.RegenMana(ran);
            }
            case CellEntityType.ENEMY -> {
                this.action.setText("Battle begin");
                BattleSwing b = new BattleSwing(frame);
                b.show();
                if(Game.getInstance().player.currentHealth > 0)
                    action.setText("You won the battle");
            }
            case CellEntityType.PORTAL -> {
                this.action.setText("You landed on portal");
                Game.getInstance().Map = Grid.Generation(Game.getInstance().Map.length, Game.getInstance().Map.width);
                for (int i = 0; i < px; i++)
                    for (int j = 0; j < py; j++) {
                        if (Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER) {
                             xx = i;
                             yy = j;
                        }
                    }

                Game.getInstance().Map.cell = new Cell(xx, yy, CellEntityType.PLAYER, 2);
                Game.getInstance().player.XP = Game.getInstance().player.XP + Game.getInstance().levelReached * 5;
                Game.getInstance().levelReached++;
                Game.getInstance().player.UpdateLevel();
                if (Game.getInstance().player.level > 50)
                    Game.getInstance().player.UpdateAttributes(); ////Grija
            }
            case CellEntityType.VOID -> {
                this.action.setText("You landed on void");
            }
        }
    }
    public void labelCells() {
        int x = Game.getInstance().Map.getLength();
        int y = Game.getInstance().Map.getWidth();
        for (int i = 0; i < x; i++) {
            gridCells.add(new ArrayList<>());
            for (int j = 0; j < y; j++) {
                gridCells.get(i).add(new JLabel());
                this.MapPanel.add(gridCells.get(i).get(j));
                if (Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER)
                    this.gridCells.get(i).get(j).setText("P");
                if (Game.getInstance().Map.get(i).get(j).type == CellEntityType.VOID && Game.getInstance().Map.get(i).get(j).status == 1)
                    this.gridCells.get(i).get(j).setText("V");
                if (!(Game.getInstance().Map.get(i).get(j).type == CellEntityType.PLAYER) && !(Game.getInstance().Map.get(i).get(j).type == CellEntityType.VOID && Game.getInstance().Map.get(i).get(j).status == 1))
                    this.gridCells.get(i).get(j).setText("N");

            }
        }
    }

    public void show() {
        this.frame.setVisible(true);
    }

}
