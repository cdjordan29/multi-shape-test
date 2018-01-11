import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{

	private int width;
	private int height;
	private MoveableShape shape;
	private static ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();

	public ShapeIcon(int width, int height)
	{
		this.width = width;
		this.height = height;		
	}

	public int getIconWidth()
	{
		return width;
	}

	public int getIconHeight()
	{
		return height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		//for each that draws the shapes which allows them to move.
		for(MoveableShape shape : shapes){

			shape.draw(g2);
		}
	}

	/**
	 * Method translate, is responsible for making the shapes move on the screen.
	 * It also accounts for the image wrapping. 
	 * @param x
	 * @param y
	 */
	public void translate(int x, int y){
		
		for(MoveableShape shape: shapes){
			
			shape.translate(1, 0);
			
			if(shape.getX() > 1000){
				shape.setX(0);
			}
			
			if(shape.getY() > 1000){
				shape.setY(0);
			}
		}
	}
	
	/**
	 * Method addToArrayList, adds the shapes to the array list 
	 */
	public void addToArrayList(MoveableShape sh){

		shapes.add(sh);
	}

	/**
	 * Method removeFromArrayList, removes the shapes from the array list
	 */
	public void removeFromArrayList(){

		if(shapes.size() > 0){
			shapes.remove(shapes.size() - 1);
		}
	}
	
	public void removeAllFromArrayList(){
		
		shapes.removeAll(shapes);
	}
}



