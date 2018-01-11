
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
 */
public class BirdShape implements MoveableShape
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
	public BirdShape(int x, int y, int width)
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
		//This is the main body of the Bird
		Ellipse2D.Double birdBody = new Ellipse2D.Double(x + 20, y, width / 2, width / 8);

		//This is the beak of the bird
		Ellipse2D.Double birdBeak = new Ellipse2D.Double(x + 60, y, width / 6, width / 10);
		//Arc2D.Double birdBeak = new Arc2D.Double(x, y, width, width);

		//This is the tail of the bird
		Ellipse2D.Double birdTail = new Ellipse2D.Double(x, y, width / 4, width / 8);

		g2.setPaint(Color.YELLOW);
		g2.draw(birdBody);
		g2.fill(birdBody);

		g2.setPaint(Color.ORANGE);
		g2.draw(birdBeak);
		g2.fill(birdBeak);

		g2.setPaint(Color.YELLOW);
		g2.draw(birdTail);
		g2.fill(birdTail);

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

