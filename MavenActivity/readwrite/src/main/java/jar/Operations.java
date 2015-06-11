import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;


class Operations{	
	private ArrayList<ArrayList<Values>> words = new ArrayList<ArrayList<Values>>();

	public String userInput(String message){
		System.out.println(message);
		Scanner scan = new Scanner(System.in);	
		String input = scan.next();
		return input;	
	}

	public boolean initialize(){
		boolean ans = false;
		try{
			File myFile = new File("words.text");
			List<String> list = FileUtils.readLines(myFile);
			int count = 0;
			
			outer: for(String word: list){
				word = word.replace("),",") ");
				String[] rows = word.split(" ");
				words.add(new ArrayList<Values>());
				int l=0;
				inner: for(String copy: rows){
					copy = copy.substring(1,copy.length()-1);
					if(!(copy.indexOf(",")==copy.lastIndexOf(","))){
						System.out.println("Some values contain delimeters! Check the text file. :)");
						ans = false;
						break outer;
					}
					String[] copied = copy.split(",");
					Values a = new Values(copied[0],copied[1]);
					words.get(count).add(a);
					l++;
					ans = true;
					}//inner for
				count++;			
				}//outer forloop
		}catch (Exception e){

		}
		return ans;
	}//initialize

	public void print(){
		for(int i=0; i<words.size();i++){
			for(int x=0; x<words.get(i).size();x++){
				System.out.print("("+words.get(i).get(x).value1 + "," + words.get(i).get(x).value2+")");
				if(!(x==words.get(i).size()-1)){
					System.out.print(",");				
				}
			}
			System.out.println();
		}
	}//print
	public void search(){
		String find = userInput("Search: ");
		boolean match = false;
		for(int i=0; i<words.size();i++){
			ArrayList<Values> temp = words.get(i);
			int k=0;
			for(Values sWord:temp){
				if(sWord.value1.contains(find) || sWord.value2.contains(find)){		
					System.out.print("("+i+","+k+")("+sWord.value1+","+sWord.value2+")->");
					System.out.print(find+"'s Occurence/s: ");
					int count =0;
					match = true;
					if(find.equals(sWord.value1)&& find.equals(sWord.value2)){
						count=2;	
					}else if(find.equals(sWord.value1)||find.equals(sWord.value2)){
						count=1;
					}else{
						value1: for(int term=0; term<sWord.value1.length(); term++){	
								if (term<=sWord.value1.length()-find.length()){
									if (find.equals(sWord.value1.substring(term,term+find.length()))){
									++count;
									}
								}
							}//value1 forloop	
						value2: for(int term=0; term<sWord.value2.length(); term++){	
								if (term<=sWord.value2.length()-find.length()){
									if (find.equals(sWord.value2.substring(term,term+find.length()))){
									++count;
									}
								}
							}//value2 forloop	
					}
					System.out.print(count+ "\n");
				}
				k++;
			}
		}
		if(match == false){
			System.out.println("No Matches");
		}

	}//search 
	
	public void edit(){
		try{	
			int row = Integer.parseInt(userInput("Enter Row: "));
			while(row >= words.size()){
				row = Integer.parseInt(userInput("Enter Row: "));
			}
			int col = Integer.parseInt(userInput("Enter Column: "));
			while(col>=words.get(row).size()){
				col = Integer.parseInt(userInput("Enter Column: "));		
			}
			Values temp = words.get(row).get(col);
			System.out.println("Edit " + "("+temp.value1 + "," + temp.value2+")");	
			
			temp.value1 = userInput("Enter New Value1: ");
			temp.value2 = userInput("Enter New Value2: ");
			
			ArrayList<Values> toUpdate = words.get(row);
			String updateTextFile = "";
			int x =0;
			for(Values tempo: toUpdate){
				updateTextFile = updateTextFile + "(" + tempo.value1 + "," + tempo.value2 + ")";
				if(!(x== toUpdate.size()-1)){
					updateTextFile = updateTextFile + ",";
				}
				x++;
			}
			
			File myFile = new File("words.text");
			List<String> uplist = FileUtils.readLines(myFile);
			String content ="";
			int editLine=0;
			for(String word:uplist){
				if(editLine==row){
					content= content + updateTextFile+ "\n";		
				}else{
					content= content + word+ "\n";
				}	
				editLine++;		
			}
			FileUtils.writeStringToFile(myFile,content);
			System.out.println("Updated!");

		}catch(Exception e){
			System.out.println("Ooops. Something went wrong!");
		}
	}//edit

	public void sort(){
		try{
			String sorted ="";
			for(int i=0; i<words.size(); i++){
				ArrayList<Values> list = words.get(i);
				Collections.sort(list);
				int x = 0;
				for(Values sVal: list){
					sorted = sorted + "("+ sVal.value1 + "," + sVal.value2 + ")";
					if(!(x== list.size()-1)){
						sorted = sorted + ",";
					}
					x++;
				}
				sorted = sorted + "\n";
			}
			File myFile = new File("words.text");
			FileUtils.writeStringToFile(myFile,sorted);
			System.out.println("Sorted!");
			print();
		}catch(Exception e){
			
		}

	}//sort

}//operations

