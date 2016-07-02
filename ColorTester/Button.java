/*    */ package ColorTester;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ public class Button extends JButton
/*    */ {
/*  9 */   Font font = new Font("Verdana", 1, 15);
/*    */ 
/*    */   public Button(Color color)
/*    */   {
/* 13 */     setVerticalTextPosition(0);
/* 14 */     setHorizontalTextPosition(0);
/* 15 */     setFont(this.font);
/* 16 */     setBackground(color);
/* 17 */     setOpaque(true);
/* 18 */     setBorderPainted(false);
/*    */   }
/*    */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.Button
 * JD-Core Version:    0.6.0
 */