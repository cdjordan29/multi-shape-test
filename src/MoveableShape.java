
import java.awt.Graphics2D;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
   void translate(int dx, int dy);
   
   int getX();
   
   int getY();
   
   void setX(int x);
   
   void setY(int y);
}
