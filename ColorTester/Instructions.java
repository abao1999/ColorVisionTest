/*    */ package ColorTester;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.Insets;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class Instructions extends JFrame
/*    */   implements MouseListener
/*    */ {
/* 16 */   static int width = Page.size.width;
/* 17 */   static int height = Page.size.height;
/* 18 */   Font title = new Font("Comic-Sans", 1, 30);
/* 19 */   Font subtitle = new Font("Times", 2, 10);
/* 20 */   JTextArea text = new JTextArea("Click the square with a different color from the others.\nEach time you click a correct square, you gain a score-point. You will progress a level for every three correct clicks, but if you click wrong even once, then you lose.\nAt first you have 15 seconds to find each miscolored square. Howevever, whenever you gain 5 levels, your time will be reduced by 2 seconds until you only have five seconds left.\n\n\n\nClick anywhere in the orange region to begin!");
/*    */ 
/*    */   public Instructions(String title) {
/* 23 */     super(title);
/* 24 */     addMouseListener(this);
/* 25 */     getContentPane().setBackground(Color.ORANGE);
/* 26 */     this.text.setEditable(false);
/* 27 */     this.text.setBackground(Color.YELLOW);
/* 28 */     this.text.setPreferredSize(new Dimension(Page.size.width, 200));
/* 29 */     this.text.setMargin(new Insets(50, 50, 50, 50));
/* 30 */     add(this.text, "North");
/* 31 */     setDefaultCloseOperation(3);
/* 32 */     setPreferredSize(Page.size);
/* 33 */     pack();
/* 34 */     setVisible(true);
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
/* 58 */     new Page("Color Vision Tester");
/*    */   }
/*    */ 
/*    */   public void mouseReleased(MouseEvent e)
/*    */   {
/*    */   }
/*    */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.Instructions
 * JD-Core Version:    0.6.0
 */