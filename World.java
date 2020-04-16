import java.util.ArrayList;

public class World {
	
	private int width;
	private int height;
	private ArrayList<LifeForm> creatureList;
	
	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}
	
	public void letTimePass(){
		
		makeNewCreatures();
		//eatThings();
		//creaturesGetOlder();
		//purgeTheDead();		
	}
	
	public void makeNewCreatures() {
		
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is "+currentSizeOfCreatureList);
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
		}
	}
	
	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}	
	}
	
	public void creaturesGetOlder(){
		for( LifeForm l:creatureList){
			l.age(1);
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
}
