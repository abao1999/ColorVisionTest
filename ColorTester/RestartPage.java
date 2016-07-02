/*    */ package ColorTester;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Insets;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class RestartPage extends JPanel
/*    */ {
/*    */   public RestartPage(int score)
/*    */   {
/* 13 */     setBackground(Color.YELLOW);
/* 14 */     JTextArea finalscore = new JTextArea("Your Score Was: " + score);
/* 15 */     finalscore.setMargin(new Insets(Page.size.height / 3, 0, 0, 0));
/* 16 */     finalscore.setBackground(Color.YELLOW);
/* 17 */     add(finalscore);
/*    */   }
/*    */ }

/* Location:           /Users/timcoker/Desktop/ColorVisionTest.jar
 * Qualified Name:     ColorTester.RestartPage
 * JD-Core Version:    0.6.0
 */