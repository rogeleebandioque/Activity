
import java.util.*;

public class Exercise2AnM{
	private static int init = 0;
	public static void main(String[]args){
		Operations op = new Operations();
		System.out.println(" [1] Set Size \n [2] Initialize \n [3] Print \n [4] Search \n [5] Edit  \n [6] Exit" );
		int choice = 0;		
		try{
			choice = Integer.parseInt(op.userInput("Enter your Choice: "));
			if (choice == 1) init = 1;

		}catch (NumberFormatException e){
			System.out.println("Invalid Input. Bye");
		}
		
		loop: while(choice!=6){

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
				case 5:	if(init==2) op.edit();
					else System.out.println("Set size/Initialize First!");
				break;
				case 6:
				break loop;
				default: System.out.println("Choice does not exist!");
				break;
			}//switch	
			System.out.println("\n [1] Set Size \n [2] Initialize \n [3] Print \n [4] Search \n [5] Edit  \n [6] Exit" );
			choice = Integer.parseInt(op.userInput("Enter your Choice: "));
		}//while

	}
}
/*
class Operations{
	private ArrayList<HashMap<Integer,String>> words = new ArrayList<HashMap<Integer,String>>();
	private ArrayList<Integer> keyArr = new ArrayList<Integer>();
	private int row;
	private int col;
	private int key;	
	private String pool = "qwertyuiopasdfghjklzxcvbnm0987654321";

	public void initial(){
		//keyArr.clear();
		words = new ArrayList<HashMap<Integer,String>>();
		words.clear();
		key = 0;
		System.out.println();
		for(int i=0; i<row; i++){
			words.add(new HashMap<Integer,String>());
			for(int y=0; y<col; y++){
				keyArr.add(key);
				int random = 5;
				String ranWord = "";				
				while (random>0){
					int rand = (int)(Math.random()*pool.length());
					char add = pool.charAt(rand);
					ranWord = ranWord + add;
					--random;
				}
				//System.out.println(ranWord);
				words.get(i).put(key,ranWord);
				key++;
			}
		}
		
		System.out.println("Array Initialized!");
		
	}
	public void print(){
		for(int i=0; i<words.size(); i++){
			for(int in:words.get(i).keySet()){
				System.out.print("("+in+" , "+words.get(i).get(in)+")     ");
			}
			System.out.println();
		}
	}
	public void search(){
		try{
			int sRow = Integer.parseInt(userInput("Enter Row: "));
			while(sRow>=row)sRow = Integer.parseInt(userInput("Row does not exist, Re-enter Row: "));
			int skey = Integer.parseInt(userInput("Enter key: "));
			System.out.println("Matches: ");
		
			if(words.get(sRow).containsKey(skey) == true){
			System.out.println("("+skey+" , "+words.get(sRow).get(skey)+")");
			
			System.out.println("Count Occurences");
			count(sRow,skey,words.get(sRow).get(skey));			

			}else System.out.println("No Matches found");
			
			
		}catch(NumberFormatException e){
			System.out.println("Invalid Input!");
		}
	}
	public void edit(){
		int eRow;
		Integer eKey;
		try{
			eRow = Integer.parseInt(userInput("Enter Row: "));
			while(eRow >= row)eRow = Integer.parseInt(userInput("Row doesnt exist! Re-enter Row: "));
			eKey = Integer.parseInt(userInput("Enter Key: "));
			//System.out.println(words.get(eRow).containsKey(eKey) +""+words.get(eRow).get(eKey));
			while(words.get(eRow).containsKey(eKey) == false)eKey = Integer.parseInt(userInput("Key doesnt exist! Re-enter Key: "));		
			int answer = Integer.parseInt(userInput("Edit \n [1] Key [2]  Value"));	
			if(answer == 1){
				System.out.println("Edit key: "+eKey);
				boolean keyin= false;
				int newKey;
				do{
					newKey = Integer.parseInt(userInput("Enter New Key: "));
					loopfor: for(int k: keyArr){
						if(k==newKey){
						keyin=true;
						break loopfor;
						}else keyin = false;
					}
				}while(keyin==true);
				String val = words.get(eRow).get(eKey);
				System.out.println(val);
				words.get(eRow).remove(eKey);
				words.get(eRow).put(newKey,val);
				//gawan ng local variable para di paulitulit na tatawag sa arraylist
				keyArr.remove(eKey);
				System.out.println("Changed!");	
			}else if(answer == 2){
				System.out.println("Edit "+words.get(eRow).get(eKey) );
				words.get(eRow).remove(eKey);
				words.get(eRow).put(eKey,userInput("Enter New Value: "));
				System.out.println("Changed!");	
			}else System.out.println("Not in the Choices");		
			
		
		}catch(NumberFormatException e){
			System.out.println("Invalid Input. Bye!");
		}	
	}
	public void count(int eRow, int ekey, String wordTF){
		String find = userInput("Find letter?: ");
		System.out.println("Count "+find+"'s in "+wordTF);
		int counts =0;
		int findcount = find.length();
		if(findcount>wordTF.length())System.out.println("No Occurences!");
		else if(find.equals(wordTF))System.out.println("Same Word! 1 Occurence");		
		else{
			for(int term=0; term<wordTF.length(); term++){
				//String terms = ""+words.get(eRow).get(eCol).charAt(term);	
				if (term<=wordTF.length()-findcount){
					//System.out.println(find+ " " + wordTF.substring(term,term+findcount));
					if (find.equals(wordTF.substring(term,term+findcount)))++counts;
				}
			}	
			System.out.println("Number of occurence/s: "+ counts);
		}
			
	}
	public void setSize(){
		try{
			key = 0;
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
*/
