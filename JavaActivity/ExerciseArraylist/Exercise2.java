import java.util.*;

class Exercise2{
	private static int init = 0;
	public static void main(String[]args){
		Operations op = new Operations();
		System.out.println(" [1] Set Size \n [2] Initialize \n [3] Print \n [4] Search \n [5] Edit  \n [6] Count Occurence \n [7] Exit" );
		int choice = 0;		
		try{
			choice = Integer.parseInt(op.userInput("Enter your Choice: "));
			if (choice == 1) init = 1;

		}catch (NumberFormatException e){
			System.out.println("Invalid Input. Bye");
		}
		
		loop: while(choice!=7){

			switch (choice){
				case 1: op.setSize();
					init=1;
				break;
				case 2:	if(init==0)System.out.println("Initialize First!");
					else{
					op.initial();
					init=2;					
					} 
				break;
				case 3: if(init==2)op.print();
					else System.out.println("Set size/Initialize First!");
				break;
				case 4: if(init==2)op.search();
					else System.out.println("Set size/Initialize First!");
				break;
				case 5:if(init==2) op.edit();
					else System.out.println("Set size/Initialize First!");
				break;
				case 6: if(init==2) op.count();
					else System.out.println("Set size/Initialize First!");
				break;
				case 7:
				break loop;
				default: System.out.println("Choice does not exist!");
				break;
			}//switch	
			System.out.println("\n [1] Set Size \n [2] Initialize \n [3] Print \n [4] Search \n [5] Edit  \n [6] Count Occurence \n [7] Exit" );
			choice = Integer.parseInt(op.userInput("Enter your Choice: "));
		}//while

	}
}

class Operations{
	private ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
	private int row;
	private int col;
	private String pool = "qwertyuiopasdfghjklzxcvbnm0987654321";

	public void initial(){
		words.clear();
		System.out.println();
		for(int i=0; i<row; i++){
			words.add(new ArrayList<String>());
			for(int y=0; y<col; y++){
				int random = 5;
				String ranWord = "";				
				while (random>0){
					int rand = (int)(Math.random()*pool.length());
					char add = pool.charAt(rand);
					ranWord = ranWord + add;
					--random;
				}
				//System.out.println(ranWord);
				words.get(i).add(ranWord);
			}
		
		}
		System.out.println("Array Initialized!");
		
	}
	public void print(){
		for(int i=0; i<words.size(); i++){
			for(String in:words.get(i)){
				System.out.print(in + "     ");
			}
			System.out.println();
		}
	}
	public void search(){
		String searchWord = userInput("Enter word/letter: ");
		System.out.println("Matches: ");

		boolean exist = false;
		for(int i=0; i<words.size(); i++){
			int count=0; 
			for(String in:words.get(i)){
				if(in.contains(searchWord)) System.out.println("["+i+"]["+count+"]"+ in);
				count++;
			}
		}
			
	}
	public void edit(){
		int eRow;
		int eCol;
		try{
			eRow = Integer.parseInt(userInput("Enter Row: "));
			while(eRow >= row)eRow = Integer.parseInt(userInput("Enter Row: "));
			eCol = Integer.parseInt(userInput("Enter Column: "));
			while(eCol>=col)eCol = Integer.parseInt(userInput("Enter Column: "));		
			System.out.println("Edit "+words.get(eRow).get(eCol) );
			words.get(eRow).remove(eCol);
			words.get(eRow).add(eCol,userInput("Enter New Value: "));
			System.out.println("Changed!");	
		
		}catch(NumberFormatException e){
			System.out.println("Invalid Input. Bye!");
		}	
	}
	public void count(){
		int eRow;
		int eCol;
		try{
			eRow = Integer.parseInt(userInput("Enter Row: "));
			while(eRow >= row)eRow = Integer.parseInt(userInput("Enter Row: "));
			eCol = Integer.parseInt(userInput("Enter Column: "));
			while(eCol>=col)eCol = Integer.parseInt(userInput("Enter Column: "));	
			String find = userInput("Insert letter: ");
			System.out.println("Count "+find+"'s in "+words.get(eRow).get(eCol));
			int counts =0;
			for(int term=0; term<words.get(eRow).get(eCol).length(); term++){
				String terms = ""+words.get(eRow).get(eCol).charAt(term);		
				//System.out.println(terms + " == " + find);		
				if (terms.equals(find))++counts;			
			}		

			System.out.println("Number of occurence/s: "+ counts);

		}catch(NumberFormatException e){
			System.out.println("Invalid Input!");
		}	
	
	}
	public void setSize(){
		try{
			row = Integer.parseInt(userInput("Size of Row: "));
			col = Integer.parseInt(userInput("Size of Column: "));
			while(row<=0 || col <=0){
				System.out.println("Size cannot be zero!");
				if(row<=0)row = Integer.parseInt(userInput("Re-enter size of Row: "));
				if(col <=0)col = Integer.parseInt(userInput("Re-enter size of Column: "));
			}
			System.out.println("Size is now " + row + " by " + col);
		}catch (NumberFormatException e){
			System.out.println("Invalid Input");
		}
	}
	public String userInput(String message){
		System.out.println(message);
		Scanner scan = new Scanner(System.in);	
		String input = scan.next();
		return input;
	}	
}

