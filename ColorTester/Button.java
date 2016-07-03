package ColorTester;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Button extends JButton {
  Font font = new Font("Verdana", 1, 15);

  public Button(Color color)  {
    setVerticalTextPosition(0);
    setHorizontalTextPosition(0);
    setFont(this.font);
    setBackground(color);
    setOpaque(true);
    setBorderPainted(false);
  }
}
