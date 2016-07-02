/*     */ package ColorTester;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class Page extends JFrame
/*     */   implements ActionListener
/*     */ {
/*  19 */   static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
/*  20 */   JTextArea textarea = new JTextArea("Score: 0; Level: 1");
/*  21 */   ImageDrawer ID = new ImageDrawer(2, 2);
/*  22 */   int count = 0;
/*  23 */   int level = 1;
/*  24 */   int time = 15;
/*  25 */   Timer countdown = new Timer(1000, this);
/*  26 */   int timeleft = this.time;
/*  27 */   JTextArea countdowndisplay = new JTextArea("Time Left: " + this.time);
/*     */ 
/*     */   public Page(String title)
/*     */   {
/* 129 */     super(title);
/* 130 */     this.countdown.start();
/* 131 */     this.textarea.setBackground(Color.YELLOW);
/* 132 */     this.countdowndisplay.setBackground(Color.YELLOW);
/* 133 */     setDefaultCloseOperation(3);
/* 134 */     setPreferredSize(size);
/* 135 */     add(new Header(), "North");
/* 136 */     add(this.ID);
/* 137 */     MenuCreator();
/* 138 */     pack();
/* 139 */     setVisible(true);
/*     */   }
/*     */ 
/*     */   public void MenuCreator()
/*     */   {
/* 144 */     JButton button1 = new JButton("Restart");
/* 145 */     button1.setForeground(Color.DARK_GRAY);
/* 146 */     button1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 148 */         Page.this.timeleft = Page.this.time;
/* 149 */         Page.this.countdowndisplay.setForeground(Color.BLACK);
/* 150 */         Page.this.countdowndisplay.setText("Time Left: " + Page.this.timeleft);
/* 151 */         Page.this.countdown.restart();
/* 152 */         Page.this.count = 0;
/* 153 */         Page.this.level = 1;
/* 154 */         Page.this.textarea.setText("Score: 0 Level: 1");
/* 155 */         Page.this.getContentPane().remove(1);
/* 156 */         Page.this.ID = new Page.ImageDrawer(Page.this, 2, 2);
/* 157 */         Page.this.getContentPane().add(Page.this.ID, 1);
/* 158 */         Page.this.validate();
/*     */       }
/*     */     });
/* 162 */     Menu M = new Menu();
/* 163 */     add(M, "South");
/* 164 */     M.add(this.countdowndisplay, "South");
/* 165 */     M.add(button1, "South");
/* 166 */     M.add(this.textarea, "South");
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 173 */     if (e.getSource().equals(this.countdown)) {
/* 174 */       this.timeleft -= 1;
/* 175 */       if (this.timeleft >= 0) {
/* 176 */         this.countdowndisplay.setText("Time Left: " + this.timeleft);
/*     */       }
/* 178 */       if (this.timeleft <= 5) {
/* 179 */         this.countdowndisplay.setForeground(Color.RED);
/*     */       }
/*     */     }
/*     */ 
/* 183 */     if (this.timeleft == -1) {
/* 184 */       this.countdown.stop();
/* 185 */       this.textarea.setText("YOU LOST");
/* 186 */       this.ID.pictures[this.ID.rLocation][this.ID.cLocation].setText(this.ID.message);
/* 187 */       RestartPage restart = new RestartPage(this.count);
/* 188 */       getContentPane().remove(1);
/* 189 */       getContentPane().add(restart, 1);
/* 190 */       this.count = 0;
/* 191 */       this.level = 1;
/* 192 */       this.timeleft = this.time;
/* 193 */       this.countdowndisplay.setForeground(Color.BLACK);
/* 194 */       validate();
/*     */     }
/*     */   }
/*     */ 
/*     */   class ImageDrawer extends JPanel
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*  32 */     final String message = null;
/*     */     int rows;
/*     */     int columns;
/*     */     Button[][] pictures;
/*     */     int rLocation;
/*     */     int cLocation;
/*  38 */     int increment = 20;
/*     */ 
/*  80 */     ActionListener next = new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  83 */         Page.this.count += 1;
/*  84 */         if (Page.this.count % 3 == 0) {
/*  85 */           Page.this.level += 1;
/*     */         }
/*  87 */         if (Page.ImageDrawer.this.increment > 0) {
/*  88 */           Page.ImageDrawer.this.increment -= 1;
/*     */         }
/*  90 */         if (Page.this.count % 3 == 0) {
/*  91 */           Page.this.ID = new Page.ImageDrawer(Page.this, Page.this.ID.rows + 1, Page.this.ID.columns + 1);
/*     */         }
/*     */         else {
/*  94 */           Page.this.ID = new Page.ImageDrawer(Page.this, Page.this.ID.rows, Page.this.ID.columns);
/*     */         }
/*  96 */         if ((Page.this.count % 15 == 0) && (Page.this.time >= 7)) {
/*  97 */           Page.this.time -= 2;
/*     */         }
/*     */ 
/* 100 */         Page.this.getContentPane().remove(1);
/* 101 */         Page.this.getContentPane().add(Page.this.ID, 1);
/* 102 */         Page.ImageDrawer.this.validate();
/* 103 */         Page.this.textarea.setText("Score: " + Page.this.count + "; Level: " + Page.this.level);
/* 104 */         Page.this.timeleft = Page.this.time;
/* 105 */         Page.this.countdowndisplay.setForeground(Color.BLACK);
/* 106 */         Page.this.countdowndisplay.setText("Time Left: " + Page.this.timeleft);
/* 107 */         Page.this.countdown.restart();
/*     */       }
/*  80 */     };
/*     */ 
/* 111 */     ActionListener end = new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 114 */         Page.this.textarea.setText("YOU LOST");
/* 115 */         Page.this.countdown.stop();
/* 116 */         Page.ImageDrawer.this.pictures[Page.ImageDrawer.this.rLocation][Page.ImageDrawer.this.cLocation].setText(Page.ImageDrawer.this.message);
/* 117 */         RestartPage restart = new RestartPage(Page.this.count);
/* 118 */         Page.this.getContentPane().remove(1);
/* 119 */         Page.this.getContentPane().add(restart, 1);
/* 120 */         Page.this.count = 0;
/* 121 */         Page.this.level = 1;
/* 122 */         Page.ImageDrawer.this.validate();
/*     */       }
/* 111 */     };
/*     */ 
/*     */     public ImageDrawer(int r, int c)
/*     */     {
/*  40 */       super();
/*     */ 
/*  42 */       Page.this.textarea.setEditable(false);
/*     */ 
/*  44 */       int colora = (int)Math.round(Math.random() * 255.0D);
/*  45 */       int colorb = (int)Math.round(Math.random() * 255.0D);
/*  46 */       int colorc = (int)Math.round(Math.random() * 255.0D);
/*  47 */       int changea = (int)Math.round(Math.random() * this.increment);
/*  48 */       int changeb = (int)Math.round(Math.random() * this.increment);
/*  49 */       int changec = (int)Math.round(Math.random() * this.increment);
/*  50 */       if (((changea < changeb) && (colora > this.increment)) || (colora > 255 - this.increment)) {
/*  51 */         changea *= -1;
/*     */       }
/*  53 */       if (((changeb < changec) && (colorb > this.increment)) || (colorb > 255 - this.increment)) {
/*  54 */         changeb *= -1;
/*     */       }
/*  56 */       if (((changec < changea) && (colorc > this.increment)) || (colorc > 255 - this.increment)) {
/*  57 */         changec *= -1;
/*     */       }
/*     */ 
/*  60 */       setBackground(Color.WHITE);
/*  61 */       this.rows = r;
/*  62 */       this.columns = c;
/*  63 */       this.rLocation = (int)(Math.random() * this.columns);
/*  64 */       this.cLocation = (int)(Math.random() * this.rows);
/*  65 */       this.pictures = new Button[r][c];
/*  66 */       for (int i = 0; i < this.rows * this.columns; i++)
/*  67 */         if ((i / c != this.rLocation) || (i % c != this.cLocation)) {
/*  68 */           this.pictures[(i / c)][(i % c)] = new Button(new Color(colora, colorb, colorc));
/*  69 */           this.pictures[(i / c)][(i % c)].addActionListener(this.end);
/*  70 */           add(this.pictures[(i / c)][(i % c)]);
/*     */         }
/*  72 */         else if ((i / c == this.rLocation) && (i % c == this.cLocation)) {
/*  73 */           this.pictures[(i / c)][(i % c)] = new Button(new Color(colora + changea, colorb + changeb, colorc + changec));
/*  74 */           this.pictures[(i / c)][(i % c)].addActionListener(this.next);
/*  75 */           add(this.pictures[(i / c)][(i % c)]);
/*     */         }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.Page
 * JD-Core Version:    0.6.0
 */