import java.awt.Color;

import acm.util.RandomGenerator;

public class Species1 extends Animal {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public Species1(Location loc, World w, int Lifespan, Color myColor, int StartingSurvival) {
		super(loc, w, Lifespan, myColor, StartingSurvival);
	}

	public Species1(Location loc, World w) {
		super(loc, w);
		myLifeSpan= 6;
		myColor = Color.BLUE;
		
	}

	@Override
	public void move() {
		Location previous = getMyLocation();
		int x = previous.getX();
		int y = previous.getY();
		previous.setX(x+(rgen.nextInt(-1, 1)));
		previous.setY(y+(rgen.nextInt(-1, 1)));
		setMyLocation(previous);
		
	}

	// returns one creature surrounding if there is one, and will return null if there are none
	public LifeForm neighboringSpecies() {
		int numAnimals =0;
		for(int x=-1; x< 2; x++) {
			for (int y= -1; y<2;y++) {
				Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY() +y); //why the +x and +y
				for(int j=0; j< myWorld.getCreatureList().size();j++) {
					LifeForm test = myWorld.getCreatureList().get(j);
					if(test.getMyLocation()== neighboringSqr) {
						numAnimals++;
						if (numAnimals >1) {
							return test;
						}
					}
				}
			}
			
		}
		return null;
		
	}

	@Override
	public void runAway() {
		//If the eat method automatically turns any opposing neighboring species
		//dead, by immediately swiching the alive boolean variable to false
		//Then how can one run away?
		//runAway() 
		
	}

	@Override
	public void reproduce() {
		if (survivalNum>5) {
			Location myLoc = getMyLocation();
			myWorld.getCreatureList().add(new Species1(new Location(myLoc.getX()+1,myLoc.getY()+1), myWorld));
		}
		
	}

	@Override
	public void eat() {
		Location location = getMyLocation();
		World world = myWorld;
		if(neighboringSpecies() != null) {
			if (neighboringSpecies() instanceof Species1 == false) {
				neighboringSpecies().alive=false;
			}
		}
		survivalNum++;
		myLifeSpan++;
		
		
	}
		
}


