import java.util.ArrayList;
import java.util.List;

public  class Hero{
	private String newName;
	private int newAge;
	private int mId;
	private String newSpecialpowers;
	private String newWeakness;
	private  static List<Hero> heros = new ArrayList<Hero>();

// name,age,specialpowers,weakness
	public Hero(String name,int age,String specialpowers,String weakness){
		newName=name;
		newAge=age;
		newSpecialpowers=specialpowers;
		newWeakness=weakness;
		heros.add(this);
		mId= heros.size();
	}

	public String getName(){
		return newName;
	}
	public int getAge(){
		return newAge;
	}
	public String getSpecialpowers(){
		return newSpecialpowers;
	}
	public String getWeakness(){
		return newWeakness;
	}
	public static List<Hero> all(){
		return heros;
	}
	public static void clear(){
		heros.clear();
	}
	public int getId(){
		return mId;
	}
	public static Hero find(int id){
		return heros.get(id-1);
	}
}