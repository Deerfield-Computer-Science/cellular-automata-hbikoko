import acm.util.RandomGenerator;

public class MoveTestClass extends Animal {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public MoveTestClass(Location loc, World w) {
		super(loc, w);
	}
	
	public void move() {
		Location previous = getMyLocation();
		int x = previous.getX();
		int y = previous.getY();
		previous.setX(x+(rgen.nextInt(-1, 1)));
		previous.setY(y+(rgen.nextInt(-1, 1)));
		setMyLocation(previous);
	}

	@Override
	public void eat() {
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
