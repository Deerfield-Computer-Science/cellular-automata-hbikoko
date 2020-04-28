import java.awt.Color;

public abstract class Plant extends LifeForm {

	public Plant(Location loc, World w) {
		super(loc, w);
		myColor = Color.green;
	}
	
	public abstract void move();
	public abstract void eat();
}
