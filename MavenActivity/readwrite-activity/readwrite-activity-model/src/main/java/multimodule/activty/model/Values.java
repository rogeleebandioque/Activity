package multimodule.activty.model;

public class Values implements Comparable<Values>{
	public String value1;
	public String value2;
	
	public Values(String val1, String val2){
		value1 = val1;
		value2 = val2;
	}
	public String getComparison(){
		return value1 + value2;
	}

	public int compareTo(Values val){
      		return (this.getComparison().toUpperCase()).compareTo(val.getComparison().toUpperCase());
  	}

}
