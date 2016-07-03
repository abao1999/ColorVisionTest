package ColorTester;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Instructions extends JFrame implements MouseListener {
  static int width = Page.size.width;
  static int height = Page.size.height;
  Font title = new Font("Comic-Sans", 1, 30);
  Font subtitle = new Font("Times", 2, 10);
  JTextArea text = new JTextArea("Click the square with a different color from the others.\nEach time you click a correct square, you gain a score-point. You will progress a level for every three correct clicks, but if you click wrong even once, then you lose.\nAt first you have 15 seconds to find each miscolored square. Howevever, whenever you gain 5 levels, your time will be reduced by 2 seconds until you only have five seconds left.\n\n\n\nClick anywhere in the orange region to begin!");

  public Instructions(String title) {
    super(title);
    addMouseListener(this);
    getContentPane().setBackground(Color.ORANGE);
    this.text.setEditable(false);
    this.text.setBackground(Color.YELLOW);
    this.text.setPreferredSize(new Dimension(Page.size.width, 200));
    this.text.setMargin(new Insets(50, 50, 50, 50));
    add(this.text, "North");
    setDefaultCloseOperation(3);
    setPreferredSize(Page.size);
    pack();
    setVisible(true);
  }

  public void mouseClicked(MouseEvent e)
  {
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  public void mousePressed(MouseEvent e)
  {
    new Page("Color Vision Tester");
  }

  public void mouseReleased(MouseEvent e)
  {
  }
}
