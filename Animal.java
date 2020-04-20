
	public abstract class Animal extends LifeForm {
		
		protected int myStrength; 
		//pegasus: 4
		
		public Animal(Location loc, World w) {
			super(loc, w);
		}
		
		public abstract void move();
		
		public abstract void eat();
		
		public abstract void runAway();
		
	}
	
	


