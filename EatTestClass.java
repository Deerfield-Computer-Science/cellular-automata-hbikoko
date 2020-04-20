
public class EatTestClass extends Animal {
	
	public EatTestClass(Location loc, World w) {
		super(loc, w);
	}
	//Create a Lifeform object
	//Set its boolean variable to false
	//Wrap the purgeDead() method around the Lifeform to remove it from screen
	//and to remove it from ArrayList
	//And then, for the EatTestClass:
	//myStrength++
	//myLifeSpan++
	public void eat() {
		Location location = getMyLocation();
		World world = getMyWorld();
		Species1Test random = new Species1Test(location, world); 
		random.alive = false;
		world.purgeTheDead();
		myStrength++;
		myLifeSpan++;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void runAway() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void reproduce() {
		// TODO Auto-generated method stub
	}
	
	
	
	
}
