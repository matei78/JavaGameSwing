public class Test {
    public static void main(String[] args) throws Exception {
        Game game = Game.getInstance();
        //boolean quit = false;
        while (game.quitProgram == false) {

            try {
                game.run();
            } catch (InvalidCommandException e) {
                System.out.println("Invalid command");
            }
            if (game.gameOver == false)
                game.Play("Test");
            game.w = null;
            game.m = null;
            game.r = null;
            //game.gameOver = false;
        }
    }
}