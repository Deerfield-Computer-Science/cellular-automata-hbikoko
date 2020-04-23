
import java.awt.Color;

import acm.util.RandomGenerator;
//Minor changes from Species1 are listed below
public class Species2 extends Animal {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public Species2(Location loc, World w, int Lifespan, Color myColor, int StartingSurvival) {
		super(loc, w, Lifespan, myColor, StartingSurvival);
	}

	public Species2(Location loc, World w) {
		super(loc, w);
		myLifeSpan = 4;
		myColor = Color.RED;
		
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
	}

	@Override
	public void reproduce() {
		if (survivalNum>5) {
			Location myLoc = getMyLocation();
			myWorld.getCreatureList().add(new Species2(new Location(myLoc.getX()+1,myLoc.getY()+1), myWorld));
		}
		
	}

	@Override
	public void eat() {
		Location location = getMyLocation();
		World world = myWorld;
		if(neighboringSpecies() != null) {
			if (neighboringSpecies() instanceof Species2 == false) {
				neighboringSpecies().alive=false;
			}
		}
		survivalNum+=2;	
	}
		
}

//Changes:
//Lower lifespan than Species 1
//Color is red, instead of the blue of Species 1
//Upon eating, the lifespan doesn't actually increase
//Instead, the creature stays with a relatively low lifespan but has a
//much higher survival number than other species because 
//survivalNum increments by 2 instead of 1 in this species' eat method
//My understanding is that Species2 can reproduce more, since they'll have the highest
//survival number? 



