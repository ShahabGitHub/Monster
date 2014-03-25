
public class MonsterUsage {

	public static void main(String[] args) {
	
		try {
			Monster shahab = new Monster("Shahab",1,13, 9, 19);
			Monster shahid = new Monster("Shahid",1,11, 12, 18);
			int iterations = Monster.generateNumberBetween(1, 2);
			while ((shahid.isAlive()) && (shahab.isAlive())) {
				System.out.println("Iteration"+ iterations + " Name:"+shahid.getName()
						+" Damage:"+shahid.getDamage()+" protection:"+
						shahid.getProtection()+" hitpoint:"+shahid.getHitpoints()+
						" strength:"+shahid.getStrength());
				System.out.println("Iteration"+ iterations + " Name:"+shahab.getName()
						+" Damage:"+shahab.getDamage()+" protection:"+
						shahab.getProtection()+" hitpoint:"+shahab.getHitpoints()+
						" strength:"+shahab.getStrength());
				if (iterations % 2 == 0)
					shahab.attack(shahid);
				else
					shahid.attack(shahab);
				iterations++;
			}
			System.out.println("************End of Fight****************");
			System.out.println(" Name:"+shahid.getName()+" Damage:"+shahid.getDamage()
					+" protection:"+shahid.getProtection()+" hitpoint:"+
					shahid.getHitpoints()+" strength:"+shahid.getStrength());
			System.out.println(" Name:"+shahab.getName()+" Damage:"+shahab.getDamage()
					+" protection:"+shahab.getProtection()+" hitpoint:"+
					shahab.getHitpoints()+" strength:"+shahab.getStrength());
			}catch (IllegalHitpointsException | IllegalNameException e) {
				System.out.println(e.getMessage());
			}
	}
}
