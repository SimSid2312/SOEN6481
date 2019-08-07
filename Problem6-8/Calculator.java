import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
	
	public static ArrayList<SessionHistory> userHistory=new ArrayList<SessionHistory>();	
	
	public static double roundoff(double number,int decimalPlaces){
		double out=number;		
		if(decimalPlaces==2){
			out = (int)(number * 100 + 0.5) / 100.0;		
		}
		else if(decimalPlaces==3){
			out = (int)(number * 1000 + 0.5) / 1000.0;
			
		}		
		return out;
	}
	
	public static void saveToUserHistory(String operation,String result){
		if(!result.equals("Math Error")){
			double operationResult=Double.parseDouble(result);
			SessionHistory s=new SessionHistory(operation,result,roundoff(operationResult,2)+"",roundoff(operationResult,3)+"");
			userHistory.add(s);	
		}
		else{
			SessionHistory s=new SessionHistory(operation,result);
			userHistory.add(s);	
		}
	}
	
	public static void displayUserHistory(){
		if(userHistory.size()==0){
			System.out.println("No History for your session so far!");
		}
		else{
			for (SessionHistory s : userHistory) {
				if(s.resultTwoDecimalPlace.equals("not applicable") && s.resultThreeDecimalPlace.equals("not applicable")){
					System.out.println("User Command: "+s.userCommand + " ;Result: "+s.result);
				}
				else{
					System.out.println("User Command: "+s.userCommand + " ;Result: "+s.result+ " ;Result upto 2 decimal places :"+s.resultTwoDecimalPlace+" ;Result upto 3 decimal places :"+s.resultThreeDecimalPlace);
				}            		
			}
		}
	}
	
	public static String timeToDoubleInitialAmountCompoundedAnnually(double r){
		String result;
		if(r==0){
			result= "Math Error";
		}
		else{
			result= (72/r)+"";
		}		
		String userCommand="timeToDoubleInitialAmountCompoundedAnnually("+r+")";
		saveToUserHistory(userCommand,result);
		return result;
	}
	
	public static String timeToDoubleInitialAmountCompoundedContinously(double r){
		String result;
		if(r==0){
			result= "Math Error";
		}
		else{
			result=(69/r)+"";
		}
		String userCommand="timeToDoubleInitialAmountCompoundedContinously("+r+")";
		saveToUserHistory(userCommand,result);
		return result;
		
	}
	public static double computeInverseFunctionLn2(){
		double out=2.718281828459;// this is a value of constant e
		
		String userCommand="InverseFunction(Ln(2))";
		saveToUserHistory(userCommand,((out*out)+""));
		return out*out;
	}
	
	public static String Ln(double x){
		String result="";
		
		// Validation Check to ensure x is non negative
		if(x < 0){
			result="Math Error";
		}
		else if (x==1){
			result="0";
		}
		else if (x>1){ //Using the Concepts of trapezoidal rules
			
			double computedResult;
			computedResult=1+1/x;
			int count=1;
			while(count <100){
				computedResult += 2*(1/(count *( (x - 1)/100 ) + 1));
				count++;
			}
			computedResult *= ((x - 1)/100)/2;
			result=computedResult+"";//converting it String			
		}			
		
		String userCommand="Ln("+x+")";
		saveToUserHistory(userCommand,result);
		return result;
	}
	
	public static String computerPowerRule(double pow){
		double res;
		String userCommand="ln(2^)"+pow+")";
		res=pow*Double.parseDouble(Ln(2));
		saveToUserHistory(userCommand,res+"");
		return res+"";
	}
	public static String computerProductRule(double prodNum){
		String res=Ln(prodNum);
		if(!res.equals("Math Error")){
			double temp=Double.parseDouble(res);
			res=(Double.parseDouble(Ln(2))+temp)+"";
		}
		String userCommand="ln(2."+prodNum+")";
		saveToUserHistory(userCommand,res);
		return res;
		
	}
	public static String computeLn2_y(double quoteintInputNum){
		String res=Ln(quoteintInputNum);
		if(!res.equals("Math Error")){
			double temp=Double.parseDouble(res);
			res=(Double.parseDouble(Ln(2))-temp)+"";
		}
		String userCommand="ln(2/"+quoteintInputNum+")";
		saveToUserHistory(userCommand,res);
		return res;
		
	}
	
	public static String computeLny_2(double quoteintInputNum){
		String res=Ln(quoteintInputNum);
		if(!res.equals("Math Error")){
			double temp=Double.parseDouble(res);
			res=(temp-Double.parseDouble(Ln(2)))+"";
		}
		String userCommand="ln("+quoteintInputNum+"/2)";
		saveToUserHistory(userCommand,res);
		return res;
	}
	
	public static void displayTOConsole(String Command,String result){
		if(!(result.equals("Math Error"))){
			System.out.println(Command+" ,"+result);
		    System.out.println(Command+" , Result upto 2 decimal Places: "+ roundoff	(Double.parseDouble(result),2));
		    System.out.println(Command+" , Result upto 3 decimal Places: "+ roundoff	(Double.parseDouble(result),3));
		}
		else{
			System.out.println(Command+result);
		}
		
	}
	
	public static String addTwoNumbers(double num1,double num2){		
		double res=num1+num2;
		String userCommand=num1+"+"+num2;
		saveToUserHistory(userCommand,(res+""));
		return res+"";
	}
	
	public static String subtractTwoNumbers(double num1,double num2){
		double res=num1-num2;
		String userCommand=num1+"-"+num2;
		saveToUserHistory(userCommand,(res+""));
		return res+"";
	}
	
	public static String multiplyTwoNumbers(double num1,double num2){
		double res=num1*num2;
		String userCommand=num1+"*"+num2;
		saveToUserHistory(userCommand,(res+""));
		return res+"";
		
	}
	public static String divideTwoNumbers(double num1,double num2){
		String result;
		if(num2==0){
			result= "Math Error";
		}
		else{
			double temp=num1/num2;
			result= temp+"";
		}		
		String userCommand=num1+"/"+num2;
		saveToUserHistory(userCommand,result);
		return result;
		
	}
	
	public static void run(){
		Scanner sc= new Scanner(System.in);
		while(true){
			System.out.println("\n---------------------------MAIN MENU----------------------------------------------------");
			System.out.println("Welcome to the Main Menu , please choose from the below option, to quit press 9\n");
			System.out.println("1. View history of computations.");
			System.out.println("2. Perform Basic Arithematic operations (ADD,MULTIPLICATION,DIVISION,SUBSTRACTION) on two numbers");
			System.out.println("3. Calculate Natural Logarithm Properties (QUOTIENT RULE,POWER RULE,PRODUCT RULE) of a number with ln(2)");
			System.out.println("4. Get Result of natural logarithm of 2");
			System.out.println("5. Get Result of natural logarithm of a number");
			System.out.println("6. Compute the Inverse Function of natural logarithm of 2");
			System.out.println("7. Compute the time required to double the initial principle with interest compunded annually");
			System.out.println("8. Compute the time required to double the initial principle with interest compunded continously");
			System.out.println("9. Quit");
			System.out.println("---------------------------------------------------------------------------------");
			boolean exitUserSession=false;
			String userChoice;
			System.out.print("Enter your choice: ");
			userChoice=sc.next().trim();
			
			switch(userChoice){
					case "1" :  System.out.println("Displaying User's Computation History\n");
								displayUserHistory();
							   	break;
					case "2" :  System.out.println("Basic Arithematic Operation (ADD,MULTIPLICATION,DIVISION,SUBSTRACTION)\n");
								System.out.println("Please choose from below option(A/B/C) \n");
								System.out.println("A Add two numbers");
								System.out.println("B Subtract two numbers");
								System.out.println("C Multiply two numbers");
								System.out.println("D Divide two numbers");
								System.out.println("Enter your choice now: ");
								String inputChoice=sc.next().trim();
								if((inputChoice.equals("A"))|| (inputChoice.equals("B")) || (inputChoice.equals("C")) || (inputChoice.equals("D"))){
									if(inputChoice.equals("A")){
										System.out.println ("Enter a num: ");
										String num1=sc.next().trim();
										System.out.println ("Enter a num: ");
										String num2=sc.next().trim();
										String arithResult=addTwoNumbers(Double.parseDouble(num1),Double.parseDouble(num2));
										displayTOConsole(num1+"+"+num2+"is ",arithResult);
									}
									else if(inputChoice.equals("B")){
										System.out.println ("Enter a num: ");
										String num1=sc.next().trim();
										System.out.println ("Enter a num: ");
										String num2=sc.next().trim();
										String arithResult=subtractTwoNumbers(Double.parseDouble(num1),Double.parseDouble(num2));
										displayTOConsole(num1+"-"+num2+"is ",arithResult);
										
									}
									else if (inputChoice.equals("C")){
										System.out.println ("Enter a num: ");
										String num1=sc.next().trim();
										System.out.println ("Enter a num: ");
										String num2=sc.next().trim();
										String arithResult=multiplyTwoNumbers(Double.parseDouble(num1),Double.parseDouble(num2));
										displayTOConsole(num1+"*"+num2+"is ",arithResult);
										
									}
									else if (inputChoice.equals("D")){
										System.out.println ("Enter a num: ");
										String num1=sc.next().trim();
										System.out.println ("Enter a num: ");
										String num2=sc.next().trim();
										String arithResult=divideTwoNumbers(Double.parseDouble(num1),Double.parseDouble(num2));
										displayTOConsole(num1+"/"+num2+"is ",arithResult);										
									}
								}
								else{
									System.out.println("Invalid Choice, no operation performed!");
								}
								break;
							
								
					case "3" :	System.out.println("Please choose from below option(A/B/C) \n");
								System.out.println("A Compute Power Rule");
								System.out.println("B Compute Quotient Rule");
								System.out.println("C Compute Product Rule");
								System.out.println("Enter your choice now: ");
								String input=sc.next().trim();
								switch(input){
									case "A" : System.out.println("The Power Rule on ln(2^y), where y is the number you enter.");
											   System.out.print("Enter a number, y ");
											   String powerInput=sc.next().trim();
											   double y=Double.parseDouble(powerInput);
											   String powerRuleResult= computerPowerRule(y);
											   displayTOConsole("Power Rule on ln(2^"+y+") is ",powerRuleResult);
											   break;	
									case "B" :	
												System.out.println("Please choose your option (N,D):");
												System.out.println("N The Quotient Rule on ln(2/y) , where y is your number");
												System.out.println("D The Quotient Rule on ln(y/2) , where y is your number ");
												System.out.println("Enter your choice now: ");
												String userResponse= sc.next().trim();
												if(userResponse.equals("N")||userResponse.equals("D")){
													System.out.print("Enter number, y");
													String userInpt=sc.next().trim();
													double quoteintInputNum=Double.parseDouble(userInpt);
													if(userResponse.equals("N")){
														String quoteintResult=computeLn2_y(quoteintInputNum);
														displayTOConsole("The Quotient Rule on ln(2/"+userInpt+") is ",quoteintResult);
													}
													else if(userResponse.equals("D")){
														String quoteintResult=computeLny_2(quoteintInputNum);
														displayTOConsole("The Quotient Rule on ln("+userInpt+"/2) is ",quoteintResult);
													}
												}
												else{
													System.out.println("Invalid Choice, no operation performed!");
												}												
												break;
									case "C" :  System.out.println("The Product Rule on ln(2 . y), where y is the number you enter.");
												System.out.print("Enter a number, y ");
												String prodInput=sc.next().trim();
												double prodNum=Double.parseDouble(prodInput);
												String prodRuleResult= computerProductRule(prodNum);
												displayTOConsole("Product Rule on ln(2 . ("+ prodNum +") ) is ",prodRuleResult);
												break;
									default :
											 System.out.println("Invalid Choice");
								}
								break;
								
					case "4" :  	String value=Ln(2);
									displayTOConsole("The value of ln(2) is ",value);							
									break;	
					case "5" : System.out.print("\nEnter a number : ");
							   String number=sc.next().trim();
							   //int x=Integer.parseInt(number);
							   double x=Double.parseDouble(number);
							   String res=Ln(x);
							   displayTOConsole("Natural Logarithm of :"+x+ " :",res);							  						
							   break;
							   
					case "6" :  double inverseFunctionResult=computeInverseFunctionLn2();
								displayTOConsole("Inverse Function of ln(2) is  ",inverseFunctionResult+"");	
								break;
					           
					case "7" : System.out.print("Please enter rate of interest compounded annually: ");
								String Rate= sc.next().trim();
								double r=Double.parseDouble(Rate);
								String result=timeToDoubleInitialAmountCompoundedAnnually(r);
								displayTOConsole("Time required to double initial investment (in years)  ",result);							
								break;
								
					case "8" :	System.out.print("Please enter rate of interest compounded continously: ");
								String Rt= sc.next().trim();
								double rt=Double.parseDouble(Rt);
								String outputReturned=timeToDoubleInitialAmountCompoundedContinously(rt);
								displayTOConsole("Time required to double initial investment (in years)  ",outputReturned);	
								break;
								
					case "9" : System.out.println("Thank you for using Enternity:Numbers.\n");
					            exitUserSession=true;
								break;
					default  : System.out.println("Invalid input");
							   break;	
					
			}
			
			if(exitUserSession){
				System.out.println("Bye!\n");
				break;
			}
			
			
			
		}
	}
	
	public static void main(String [] args){
		
		System.out.println("\t\t\tEnternity:Numbers Calculator");
		run();
	}
}
