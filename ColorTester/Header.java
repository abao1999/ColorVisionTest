/*    */ package ColorTester;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class Header extends JPanel
/*    */ {
/* 11 */   static JTextArea texta = new JTextArea("Ready Player One");
/*    */ 
/*    */   public Header() {
/* 14 */     texta.setBackground(Color.YELLOW);
/* 15 */     texta.setEditable(false);
/* 16 */     setPreferredSize(new Dimension(Page.size.width, 30));
/* 17 */     setBackground(Color.YELLOW);
/* 18 */     add(texta);
/*    */   }
/*    */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.Header
 * JD-Core Version:    0.6.0
 */