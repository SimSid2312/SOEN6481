
public class SessionHistory {
	
	public  String userCommand;
	public  String resultTwoDecimalPlace="not applicable";
	public  String resultThreeDecimalPlace="not applicable";
	public 	String result;

	
	public SessionHistory(String userCommand,String result) 
	{
		this.userCommand = userCommand;
		this.result=result;
	}
	
	public SessionHistory(String userCommand,String result,String resultTwoDecimalPlace,String resultThreeDecimalPlace) 
	{
		this.userCommand = userCommand;
		this.result=result;
		this.resultTwoDecimalPlace=resultTwoDecimalPlace;
		this.resultThreeDecimalPlace=resultThreeDecimalPlace;
		
	}

}
