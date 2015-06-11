public class Horse extends Thread{
	private String sound;
	private int delay;
	private int time;
	private int distance;
	private Message mes;
	
	public Horse(String n, String s, Integer t, int dis,Message mes){
		sound = s;
		time = t;
		distance = dis;
		this.mes = mes;
		this.setName(n);
	}

	public String getSound(){
		return sound;
	}

	public void run(){
		try{
			mes.count++;
			System.out.println(getName()+" is ready to start and has traveled "+ time + " second/s " + mes.count );				
			synchronized(mes){				
				mes.wait();
				System.out.println(getName() + " Started at:" +System.currentTimeMillis() + "\n");		
				go();
			}		
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void go(){
		int toTravel = distance;			
		do {
			int travel = (int)(Math.random()*10)+1;
			if(toTravel<travel){
				travel = toTravel; 
			}
			toTravel = toTravel - travel;	
			System.out.println(getName() + " ran "+ travel +"m and have to travel " + toTravel + "m more");	

		} while(toTravel>0);
		System.out.println("\n<<"+ getName() + " finished the race! : " + getSound()+">>\n");
	}

	
}


