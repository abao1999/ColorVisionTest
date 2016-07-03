package ColorTester;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPage extends JFrame implements MouseListener  {
  static int width = Page.size.width;
  static int height = Page.size.height;
  Font title = new Font("Comic-Sans", 1, 30);
  Font subtitle = new Font("Times", 2, 10);
  JButton instructions = new JButton("Click for Instructions");
  JPanel instructionspanel = new JPanel();

  ActionListener howtoplay = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new Instructions("How To Play");
    }
  };

  public StartPage(String title)  {
    super(title);
    addMouseListener(this);
    this.instructions.addActionListener(this.howtoplay);
    this.instructionspanel.add(this.instructions);
    this.instructionspanel.setVisible(true);
    this.instructionspanel.setBackground(Color.ORANGE);
    add(this.instructionspanel, "South");
    setBackground(Color.ORANGE);
    setDefaultCloseOperation(3);
    setPreferredSize(Page.size);
    pack();
    setVisible(true);
  }

  public void paint(Graphics g) {
    g.setFont(this.title);
    g.setColor(Color.BLUE);
    g.drawString("WELCOME TO COLOR-FLIPPER 1.0", (int)(0.3D * width), 100);
    g.setColor(Color.MAGENTA);
    g.setFont(this.subtitle);
    g.drawString("Click Anywhere On The Screen To Begin", (int)(0.435D * width), 400);
  }

  public void mouseClicked(MouseEvent e)  {}

  public void mouseEntered(MouseEvent e)  {}

  public void mouseExited(MouseEvent e) {}

  public void mousePressed(MouseEvent e)  {
    if (e.getSource() != this.instructions)
      new Page("Color Vision Tester");
  }

  public void mouseReleased(MouseEvent e) {}
}
