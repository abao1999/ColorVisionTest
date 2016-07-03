package ColorTester;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Page extends JFrame implements ActionListener  {
  static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
  JTextArea textarea = new JTextArea("Score: 0; Level: 1");
  ImageDrawer ID = new ImageDrawer(2, 2);
  int count = 0;
  int level = 1;
  int time = 15;
  Timer countdown = new Timer(1000, this);
  int timeleft = this.time;
  JTextArea countdowndisplay = new JTextArea("Time Left: " + this.time);

  public Page(String title) {
    super(title);
    this.countdown.start();
    this.textarea.setBackground(Color.YELLOW);
    this.countdowndisplay.setBackground(Color.YELLOW);
    setDefaultCloseOperation(3);
    setPreferredSize(size);
    add(new Header(), "North");
    add(this.ID);
    MenuCreator();
    pack();
    setVisible(true);
  }

  public void MenuCreator() {
    JButton button1 = new JButton("Restart");
    button1.setForeground(Color.DARK_GRAY);
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Page.this.timeleft = Page.this.time;
        Page.this.countdowndisplay.setForeground(Color.BLACK);
        Page.this.countdowndisplay.setText("Time Left: " + Page.this.timeleft);
        Page.this.countdown.restart();
        Page.this.count = 0;
        Page.this.level = 1;
        Page.this.textarea.setText("Score: 0 Level: 1");
        Page.this.getContentPane().remove(1);
        Page.this.ID = new Page.ImageDrawer(Page.this, 2, 2);
        Page.this.getContentPane().add(Page.this.ID, 1);
        Page.this.validate();
      }
    });
    Menu M = new Menu();
    add(M, "South");
    M.add(this.countdowndisplay, "South");
    M.add(button1, "South");
    M.add(this.textarea, "South");
  }

  public void actionPerformed(ActionEvent e)  {
    if (e.getSource().equals(this.countdown)) {
      this.timeleft -= 1;
      if (this.timeleft >= 0) {
        this.countdowndisplay.setText("Time Left: " + this.timeleft);
      }
      if (this.timeleft <= 5) {
        this.countdowndisplay.setForeground(Color.RED);
      }
    }

    if (this.timeleft == -1) {
      this.countdown.stop();
      this.textarea.setText("YOU LOST");
      this.ID.pictures[this.ID.rLocation][this.ID.cLocation].setText(this.ID.message);
      RestartPage restart = new RestartPage(this.count);
      getContentPane().remove(1);
      getContentPane().add(restart, 1);
      this.count = 0;
      this.level = 1;
      this.timeleft = this.time;
      this.countdowndisplay.setForeground(Color.BLACK);
      validate();
    }
  }

  class ImageDrawer extends JPanel  {
    private static final long serialVersionUID = 1L;
    final String message = null;
    int rows;
    int columns;
    Button[][] pictures;
    int rLocation;
    int cLocation;
    int increment = 20;

    ActionListener next = new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        Page.this.count += 1;
        if (Page.this.count % 3 == 0) {
          Page.this.level += 1;
        }
        if (Page.ImageDrawer.this.increment > 0) {
          Page.ImageDrawer.this.increment -= 1;
        }
        if (Page.this.count % 3 == 0) {
          Page.this.ID = new Page.ImageDrawer(Page.this, Page.this.ID.rows + 1, Page.this.ID.columns + 1);
        }
        else {
          Page.this.ID = new Page.ImageDrawer(Page.this, Page.this.ID.rows, Page.this.ID.columns);
        }
        if ((Page.this.count % 15 == 0) && (Page.this.time >= 7)) {
          Page.this.time -= 2;
        }

        Page.this.getContentPane().remove(1);
        Page.this.getContentPane().add(Page.this.ID, 1);
        Page.ImageDrawer.this.validate();
        Page.this.textarea.setText("Score: " + Page.this.count + "; Level: " + Page.this.level);
        Page.this.timeleft = Page.this.time;
        Page.this.countdowndisplay.setForeground(Color.BLACK);
        Page.this.countdowndisplay.setText("Time Left: " + Page.this.timeleft);
        Page.this.countdown.restart();
      }
    };

    ActionListener end = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Page.this.textarea.setText("YOU LOST");
        Page.this.countdown.stop();
        Page.ImageDrawer.this.pictures[Page.ImageDrawer.this.rLocation][Page.ImageDrawer.this.cLocation].setText(Page.ImageDrawer.this.message);
        RestartPage restart = new RestartPage(Page.this.count);
        Page.this.getContentPane().remove(1);
        Page.this.getContentPane().add(restart, 1);
        Page.this.count = 0;
        Page.this.level = 1;
        Page.ImageDrawer.this.validate();
      }
    };

    public ImageDrawer(int r, int c)  {
      super();

      Page.this.textarea.setEditable(false);

      int colora = (int)Math.round(Math.random() * 255.0D);
      int colorb = (int)Math.round(Math.random() * 255.0D);
      int colorc = (int)Math.round(Math.random() * 255.0D);
      int changea = (int)Math.round(Math.random() * this.increment);
      int changeb = (int)Math.round(Math.random() * this.increment);
      int changec = (int)Math.round(Math.random() * this.increment);
      if (((changea < changeb) && (colora > this.increment)) || (colora > 255 - this.increment)) {
        changea *= -1;
      }
      if (((changeb < changec) && (colorb > this.increment)) || (colorb > 255 - this.increment)) {
        changeb *= -1;
      }
      if (((changec < changea) && (colorc > this.increment)) || (colorc > 255 - this.increment)) {
        changec *= -1;
      }

      setBackground(Color.WHITE);
      this.rows = r;
      this.columns = c;
      this.rLocation = (int)(Math.random() * this.columns);
      this.cLocation = (int)(Math.random() * this.rows);
      this.pictures = new Button[r][c];
      for (int i = 0; i < this.rows * this.columns; i++)
        if ((i / c != this.rLocation) || (i % c != this.cLocation)) {
          this.pictures[(i / c)][(i % c)] = new Button(new Color(colora, colorb, colorc));
          this.pictures[(i / c)][(i % c)].addActionListener(this.end);
          add(this.pictures[(i / c)][(i % c)]);
        }
        else if ((i / c == this.rLocation) && (i % c == this.cLocation)) {
          this.pictures[(i / c)][(i % c)] = new Button(new Color(colora + changea, colorb + changeb, colorc + changec));
          this.pictures[(i / c)][(i % c)].addActionListener(this.next);
          add(this.pictures[(i / c)][(i % c)]);
        }
    }
  }
}
