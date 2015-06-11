import java.util.*;

public class Alert extends Thread{
	private Message mes;
	private List<Horse> hs;
	
	public Alert(Message mes, List<Horse> hs){
		this.hs = hs;		
		this.mes = mes;
	}

	public void run(){
			while(true){
				boolean runthis = false;
				for(Horse h : hs) {
					System.out.println(h.getName() + " state : " + h.getState());
					if(h.getState() == Thread.State.WAITING) {
						runthis = true;
					} else {
						runthis = false;
					}
					
					
				}
				System.out.println(runthis);
				if(runthis) {
					break;
				}
				try {
					Alert.sleep(1000);
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}
			System.out.println("\n<ALL HORSES IN STARTING LINE>\n");
		synchronized(mes) {
			mes.notifyAll();
		}
		
	}

}
