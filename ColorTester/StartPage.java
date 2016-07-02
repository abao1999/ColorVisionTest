/*    */ package ColorTester;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class StartPage extends JFrame
/*    */   implements MouseListener
/*    */ {
/* 17 */   static int width = Page.size.width;
/* 18 */   static int height = Page.size.height;
/* 19 */   Font title = new Font("Comic-Sans", 1, 30);
/* 20 */   Font subtitle = new Font("Times", 2, 10);
/* 21 */   JButton instructions = new JButton("Click for Instructions");
/* 22 */   JPanel instructionspanel = new JPanel();
/*    */ 
/* 49 */   ActionListener howtoplay = new ActionListener()
/*    */   {
/*    */     public void actionPerformed(ActionEvent e) {
/* 52 */       new Instructions("How To Play");
/*    */     }
/* 49 */   };
/*    */ 
/*    */   public StartPage(String title)
/*    */   {
/* 25 */     super(title);
/* 26 */     addMouseListener(this);
/* 27 */     this.instructions.addActionListener(this.howtoplay);
/* 28 */     this.instructionspanel.add(this.instructions);
/* 29 */     this.instructionspanel.setVisible(true);
/* 30 */     this.instructionspanel.setBackground(Color.ORANGE);
/* 31 */     add(this.instructionspanel, "South");
/* 32 */     setBackground(Color.ORANGE);
/* 33 */     setDefaultCloseOperation(3);
/* 34 */     setPreferredSize(Page.size);
/* 35 */     pack();
/* 36 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 40 */     g.setFont(this.title);
/* 41 */     g.setColor(Color.BLUE);
/* 42 */     g.drawString("WELCOME TO COLOR-FLIPPER 1.0", (int)(0.3D * width), 100);
/* 43 */     g.setColor(Color.MAGENTA);
/* 44 */     g.setFont(this.subtitle);
/* 45 */     g.drawString("Click Anywhere On The Screen To Begin", (int)(0.435D * width), 400);
/*    */   }
/*    */ 
/*    */   public void mouseClicked(MouseEvent e)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void mouseEntered(MouseEvent e)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void mouseExited(MouseEvent e)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void mousePressed(MouseEvent e)
/*    */   {
/* 78 */     if (e.getSource() != this.instructions)
/* 79 */       new Page("Color Vision Tester");
/*    */   }
/*    */ 
/*    */   public void mouseReleased(MouseEvent e)
/*    */   {
/*    */   }
/*    */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.StartPage
 * JD-Core Version:    0.6.0
 */