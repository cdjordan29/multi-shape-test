
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
*/
public class CloudShape implements MoveableShape
{
	   private int x;
	   private int y;
	   private int width;
   /**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public CloudShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }

   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void draw(Graphics2D g2)
   {
	   //This is the main body of the Cloud
      Ellipse2D.Double cloudBase = new Ellipse2D.Double(x, y + width / 6, width - 1, width / 6);

      //This is the left part of the body for the Cloud
      Ellipse2D.Double cloudLeft = new Ellipse2D.Double(x, y + 5, width / 2, width / 6);
      
      //This is the center part of the body for the Cloud
      Ellipse2D.Double cloudCenter = new Ellipse2D.Double(x + 25, y, width / 2, width / 4);
      
      //This is the right part of the body for the Cloud
      Ellipse2D.Double cloudRight = new Ellipse2D.Double(x + 50, y + 5, width / 2, width / 6);
      
      
      g2.setPaint(Color.LIGHT_GRAY);
      g2.draw(cloudBase);
      g2.fill(cloudBase);
      
      g2.setPaint(Color.WHITE);
      g2.draw(cloudLeft);
      g2.fill(cloudLeft);
      
      g2.setPaint(Color.LIGHT_GRAY);
      g2.draw(cloudCenter);
      g2.fill(cloudCenter);
      
      g2.setPaint(Color.WHITE);
      g2.draw(cloudRight);
      g2.fill(cloudRight);
   }
   
   public void setX(int xValue){

		x = xValue;
	}
	
	public void setY(int yValue){
		
		y = yValue;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}

