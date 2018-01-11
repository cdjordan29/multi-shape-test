
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
 */
public class UFOShape implements MoveableShape
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
	public UFOShape(int x, int y, int width)
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
		//This is the main body of the UFO
		Ellipse2D.Double bodyUFO = new Ellipse2D.Double(x, y + width / 6, width - 1, width / 6);

		// The point starting at the bottom of the UFO's windshield
		Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);

		// The point starting at the front of the UFO's roof
		Point2D.Double r2 = new Point2D.Double(x + width / 3, y);

		// The point starting at the rear of the UFO's roof
		Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);

		// The point starting at the bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);

		Line2D.Double frontUFOWindshield = new Line2D.Double(r1, r2);
		Line2D.Double UFOTop = new Line2D.Double(r2, r3);
		Line2D.Double rearUFOWindshield  = new Line2D.Double(r3, r4);

		g2.setPaint(Color.MAGENTA);
		g2.draw(bodyUFO);
		g2.fill(bodyUFO);

		g2.setPaint(Color.CYAN);
		g2.draw(frontUFOWindshield);
		g2.draw(UFOTop);
		g2.draw(rearUFOWindshield);

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

