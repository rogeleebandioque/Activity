import java.util.*;

public class HorseRace{
	
	public static void main(String[]args){
		Message mes = new Message();
		int distance;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Distance (30 or greater): ");
		distance = scan.nextInt();
		while (distance<10){
			System.out.print("Enter Distance (30 or greater): ");
			distance = scan.nextInt();
		}
		System.out.println();
		ArrayList<Integer> time = new ArrayList<Integer>();
		for(int d=0; d<5; d++){
			time.add((int)(Math.random()*10)+1);
		}
		
		List<Horse> horses = new ArrayList<Horse>();
		Horse h1 = new Horse("Red Horse","grrr",time.get(0),distance,mes);
		Horse h2 = new Horse("Mucho Horse","boomboom",time.get(1),distance,mes);
		Horse h3 = new Horse("Sea Horse","plop plop",time.get(2),distance,mes);
		Horse h4 = new Horse("Beki Horse","keeeriii",time.get(3),distance,mes);
		Horse h5 = new Horse("Petrang Horse","mehehehe",time.get(4),distance,mes);
		
		horses.add(h1);
		horses.add(h2);
		horses.add(h3);
		horses.add(h4);
		horses.add(h5);

		Alert alert = new Alert(mes, horses);
		
		alert.start();
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();	
	}
}
