package ColorTester;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Header extends JPanel  {
  static JTextArea texta = new JTextArea("Ready Player One");

  public Header() {
    texta.setBackground(Color.YELLOW);
    texta.setEditable(false);
    setPreferredSize(new Dimension(Page.size.width, 30));
    setBackground(Color.YELLOW);
    add(texta);
  }
}
