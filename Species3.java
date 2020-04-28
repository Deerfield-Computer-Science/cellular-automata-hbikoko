import java.awt.Color;

import acm.util.RandomGenerator;
//Minor changes from Species2 are listed below
public class Species3 extends Animal {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public Species3(Location loc, World w, int Lifespan, Color myColor, int StartingSurvival) {
		super(loc, w, Lifespan, myColor, StartingSurvival);
	}

	public Species3(Location loc, World w) {
		super(loc, w);
		myLifeSpan = 9;
		myColor = Color.YELLOW;
		
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
		public int inAPack() {
			int packNum =0;
			for(int x=-1; x< 2; x++) {
				for (int y= -1; y<2;y++) {
					Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY()+y);
					for(int j=0; j< myWorld.getCreatureList().size();j++) {
						LifeForm creature = myWorld.getCreatureList().get(j);
						if(creature.getMyLocation().equals(neighboringSqr)) {
							if (creature.getMyLocation().equals(getMyLocation())==false) {
								if(creature instanceof Species1) {
									packNum++;
								}
							}
						}
					}
				}
				
			}
			return packNum;	
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
		myLifeSpan--;
	}

	@Override
	public void eat() {
		for(int x=-1; x< 2; x++) {
			for (int y= -1; y<2;y++) {
				Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY()+y);
				for(int j=0; j< myWorld.getCreatureList().size();j++) {
					LifeForm creature = myWorld.getCreatureList().get(j);
					if(creature.getMyLocation().equals(neighboringSqr)) {
						if (creature.getMyLocation().equals(getMyLocation())==false) {
							if(creature instanceof Grass) {
								creature.alive =false;
								survivalNum++;
							}
						}
					}
				}
			}
		}
	}
		
}
//Species3 has the highest lifespan
//Eating increases the survival number by 1
//Reproducing causes the lifespan to decrease 1, which is why there are not many Species3 creatures
//There aren't many because they have such long lifespans already
//And because of the penalty they face for reproducing, they reproduce less
//So the Species3 doesn't have the strength in numbers that Species2 has
//But the few Species3 that exist have much longer longevity than Species2 or 1
