import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = Game.getInstance();
        JFrame frame = new JFrame();
        LoginSwing l = new LoginSwing(frame);
        l.show();
        while(l.c == null)
            Thread.sleep(100);
        System.out.println(l.c.toString());
        //boolean quit = false;
/*
        while (game.quitProgram == false) {

            try {
                game.run();
            } catch (InvalidCommandException e) {
                System.out.println("Invalid command");
            }
            if (game.gameOver == false)g
                game.Play("Main");
            game.w = null;
            game.m = null;
            game.r = null;
            //game.gameOver = false;
        }*/

    }
}
