package ColorTester;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RestartPage extends JPanel {
  public RestartPage(int score) {
    setBackground(Color.YELLOW);
    JTextArea finalscore = new JTextArea("Your Score Was: " + score);
    finalscore.setMargin(new Insets(Page.size.height / 3, 0, 0, 0));
    finalscore.setBackground(Color.YELLOW);
    add(finalscore);
  }
}
