import java.util.*;
import java.lang.*;

class Exercise1{
	static int init = 0;
	static boolean exit = false;
	static private String[][] words = new String[3][4];
	static String pool = "qwertyuiopasdfghjklzxcvbnm";
	public static void main(String[]args){	
		System.out.println(" [1] Initialize \n [2] Print \n [3] Search \n [4] Edit \n [5] Count Occurence \n [6] Exit" );
		int choice = 0;		
		try{
			choice = Integer.parseInt(userInput("Enter your Choice: "));
			if (choice == 1) init = 1;

		}catch (NumberFormatException e){
			System.out.println("Invalid Input. Bye");
		}
		
		loop: while(choice!=6){

			switch (choice){
				case 1:	initial();
					init=1;
				break;
				case 2: if(init==1)print();
					else System.out.println("Initialize First!");
				break;
				case 3: if(init==1)search();
					else System.out.println("Initialize First!");
				break;
				case 4:if(init==1) edit();
					else System.out.println("Initialize First!");
				break;
				case 5: if(init==1) count();
					else System.out.println("Initialize First!");
				break;
				case 6:
				break loop;
				default: System.out.println("Choice does not exist!");
				break;
			}//switch	
			System.out.println("\n [1] Initialize \n [2] Print \n [3] Search \n [4] Edit \n [5] Count Occurence \n [6] Exit" );
			choice = Integer.parseInt(userInput("Enter your Choice: "));
		}//while
	}
	public static void initial(){
		
		for(int i=0; i<words.length; i++){
			for(int y=0; y<words[0].length; y++){
				int random = 5;//(int)(Math.random()*6)+1;
				String ranWord = "";			
				while (random>0){
					int rand = (int)(Math.random()*pool.length());
					char add = pool.charAt(rand);
					ranWord = ranWord + add;
					--random;
				}
				words[i][y]=ranWord;
			}			
		}
		System.out.println("Array Initialized!");
		
	}
	public static void print(){
	
		for(int x=0; x<words.length;x++){
			for(int z=0; z<words[0].length; z++){
				System.out.print(words[x][z]+ "    ");		
			}
			System.out.println();
		}

	}
	public static  void search(){
		String searchWord = userInput("Enter word/letter: ");		
		System.out.println("Matches: ");	
		boolean exist = false;
		for(int x=0; x<words.length;x++){
			for(int z=0; z<words[0].length; z++){
				if(words[x][z].contains(searchWord) == true){
					System.out.println("["+x+"]["+z+"] = "+words[x][z]);
					exist = true;
				}
			}
		}	
		if (exist==false)System.out.print("No Matches!");	
	}
	public static void edit(){
		int row=0;
		int col=0;		
		try{
			row = Integer.parseInt(userInput("Enter Row: "));
			while(row >= words.length)row = Integer.parseInt(userInput("Enter Row: "));
			col = Integer.parseInt(userInput("Enter Column: "));
			while(col>=words[0].length)col = Integer.parseInt(userInput("Enter Column: "));		
			System.out.println("Edit "+words[row][col] );

			words[row][col] = userInput("Enter New Value: ");
			System.out.println("Changed!");	
		
		}catch(NumberFormatException e){
			System.out.println("Invalid Input. Bye!");
		}	
	}

	public static void count(){
		try{
			int row = Integer.parseInt(userInput("Enter Row: "));
			while(row >= words.length)row = Integer.parseInt(userInput("Enter Row: "));
			int col = Integer.parseInt(userInput("Enter Column: "));
			while(col>=words[0].length)col = Integer.parseInt(userInput("Enter Column: "));	
			String find = userInput("Insert letter: ");
			System.out.println("Count "+find+"'s in "+words[row][col] );
			int counts =0;
			for(int term=0; term<words[row][col].length(); term++){
				String terms = ""+words[row][col].charAt(term);		
				//System.out.println(terms + " == " + find);		
				if (terms.equals(find))++counts;			
			}		

			System.out.println("Number of occurence/s: "+ counts);

		}catch(NumberFormatException e){
			System.out.println("Invalid Input!");
		}	
	}

	public static String userInput(String message){
		System.out.println(message);
		Scanner scan = new Scanner(System.in);	
		String input = scan.next();
		return input;
	}

}
