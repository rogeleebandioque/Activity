public class FRnW{
	
	public static void main(String[]args){
		Operations op = new Operations();
		boolean cont = op.initialize();
		int choice;

		if(cont ==true){
			System.out.println(" [1] Print \n [2] Search \n [3] Edit \n [4] Sort \n [5] Exit " );
		
			try{
				choice = Integer.parseInt(op.userInput("Enter your Choice: "));
			
	
				loop: while (choice != 5){
					switch (choice){
						case 1: op.print();
						break;
						case 2: op.search();
						break;
						case 3: op.edit();
						break;
						case 4: op.sort();
						break;
						case 5:
						break loop;
						default:
							System.out.println("Not In the choices!");
						break;			
					}//switch
					System.out.println("\n [1] Print \n [2] Search \n [3] Edit \n [4] Sort \n [5] Exit " );
					choice = Integer.parseInt(op.userInput("Enter your Choice: "));		
				}//loop: while
			}catch(NumberFormatException e){
				System.out.println("Invalid Input!");
			}
		}
		
	}
}
