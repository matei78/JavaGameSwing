import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginSwing {
    public JFrame frame;
    public Credentials c;
    public JLabel label;
    public JTextField email;
    public JPasswordField password;
    public JButton enter;
    public JButton quitProgram;
    public ArrayList<Account> a;





    public LoginSwing(JFrame f) {
        this.frame = f;
        this.frame.setSize(400,400);
        this.c = null;
        this.label = new JLabel("Enter credentials");
        this.label.setBounds(100, 30, 100, 25);
        this.enter = new JButton("Enter");
        this.enter.setBounds(100, 120, 100 , 25);
        this.quitProgram = new JButton("Quit program");
        this.quitProgram.setBounds(100, 150, 100 , 25);
        this.email = new JTextField();
        this.email.setBounds(100, 60, 200, 25);
        this.password = new JPasswordField();
        this.password.setBounds(100, 90, 200, 25);
        this.frame.add(label);
        this.frame.add(email);
        this.frame.add(password);
        this.frame.add(enter);
        this.frame.add(quitProgram);
        this.frame.setLayout(null);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                frame.dispose();
            }
        });

        this.quitProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCredentials(email.getText(), password.getText());
                a = Game.getInstance().getAccounts();
                for (int i = 0; i < a.size(); i++) {
                    Account b = a.get(i);
                    if (b.information.credentials.equals(c)) {
                        Game.getInstance().selectedAccount = b;
                    }
                }
                if (Game.getInstance().selectedAccount == null) {
                    email.setText("");
                    password.setText("");
                    email.requestFocus();
                }
                else {
                    frame.getContentPane().removeAll();
                    frame.revalidate();
                    frame.repaint();
                    ChooseAccountSwing c;
                    c = new ChooseAccountSwing(frame);
                    c.show();
                }
            }
        });


    }

    public void setCredentials(String email, String password) {
        this.c = new Credentials(email, password);
        //System.out.println(this.c.toString());
    }


    public void show() {
        email.requestFocus();
        this.frame.setVisible(true);
    }


}
