import java.awt.Color;

public abstract class Animal extends LifeForm {

	public Animal(Location loc, World w) {
		super(loc, w);
	}
	
	public Animal(Location loc, World w, int Lifespan, Color myColor, int StartingSurvival) {
		super(Lifespan, loc, myColor, w, StartingSurvival);
	}
	
	
	public abstract void move();
	
	public abstract void eat();
	
	public abstract void runAway();

	public void eat(Location x) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	


