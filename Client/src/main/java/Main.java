import Menus.Initialize;
import View.MainProgramView;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        new Initialize().run();
//   new GameBoardView().run();
        MainProgramView.run();
//        new LoginMenu().run();
    }
}