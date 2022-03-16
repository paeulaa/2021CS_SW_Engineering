package demo;
import java.util.Scanner;
import java.io.*;
import java.lang.String;

class table{
	public int id, date, trans;
}

public class Demo_class {
	/*** Calculate the total expense for user. 
	* @param  
	* @throws NoSuchIDExceptions 
	* If ID not exist in Accounting System, throw NoSuchIDException 
	* @return true if id exist, false otherwise 
	* * Example: someObject.checkID(1234567); return true. 
	* Time estimate: O(n) 
	*/
	public static void TotalExpense(table var[],int id_in, int len) {
		int sum=0;
		for(int i = 0; i<=len ;i++) {
			if(id_in == var[i].id) {
				sum = sum+var[i].trans;
			}
		}
		System.out.println("蝮賣��"+sum+"���");//print total expense
	}

	/*** Print out all the transaction records for user. 
	* @param  
	* @throws NoSuchIDExceptions 
	* If ID not exist in Accounting System, throw NoSuchIDException 
	* @return true if id exist, false otherwise 
	* * Example: someObject.checkID(1234567); return true. 
	* Time estimate: O(n) 
	*/
	public static void Allrecords(table var[],int id_in, int len) {
		System.out.println("��瘨祥蝝���:");
				for(int i = 0; i<=len ;i++) {
					if(id_in == var[i].id)
						System.out.println("����:"+var[i].date+" ����:"+var[i].trans+"���");
				}
	}

	/*** Calculate the specific day expense for user. 
	* @param 
	* @throws NoSuchIDExceptions 
	* If ID not exist in Accounting System, throw NoSuchIDException 
	* @return true if id exist, false otherwise 
	* * Example: someObject.checkID(1234567); return true. 
	* Time estimate: O(n) 
	*/
	public static void DayTrans(table var[],int id_in, int len) {
		System.out.println("����蕭�嚙踝�謍梱�蕭嚙踝蕭:");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int sum = 0;
		for(int i = 0; i<=len ;i++) {
			//System.out.println("嚙踐嚙踐��");
			if(input == var[i].date && id_in == var[i].id){//add identify id condition
				sum += var[i].trans;
			}
		}System.out.println(sum);
	}

	/*** Calculate the average daily expense during specific month for user. 
	* @param 
	* @throws NoSuchIDExceptions 
	* If ID not exist in Accounting System, throw NoSuchIDException 
	* @return true if id exist, false otherwise 
	* * Example: someObject.checkID(1234567); return true. 
	* Time estimate: O(n) 
	*/
	public static void AvgTrans(table var[],int id_in, int len) {
		System.out.println("����蕭�嚙踝�謍梧蕭��:");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int month = input%100;
		int year = input/100;
		float sum = 0;
		if(month == 2) {
			if(year%4 != 0 || (year%100 == 0 && year%400 !=0) ) {
				for(int i = 0; i<= len ;i++) {
					if((var[i].date/100)%100 == 2 && var[i].date/10000 == year && id_in == var[i].id){//add identify id condition
						sum = sum + var[i].trans;
					}
				}
				System.out.println(sum/28);
				//System.out.println("Feb��蕭");
			}else if((year%4 == 0 && year%100 !=0) || year%400 == 0) {
				for(int i = 0; i<= len ;i++) {
					if((var[i].date/100)%100 == 2 && var[i].date/10000 == year && id_in == var[i].id){
						sum = sum + var[i].trans;
					}
				}
				System.out.println(sum/29);
				//System.out.println("Feb��蕭");
			}
		}else if(month == 4 || month == 6 || month == 9 || month == 11) {
			for(int i = 0; i<= len ;i++) {
				if(month == (var[i].date/100)%100 && var[i].date/10000 == year && id_in == var[i].id){
					sum = sum + var[i].trans;
				}
			}
			System.out.println(sum/30);
			//System.out.println("��嚙踝蕭");
		}else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
			for(int i = 0; i<= len ;i++) {
				if(month == (var[i].date/100)%100 && var[i].date/10000 == year && id_in == var[i].id){
					sum = sum + var[i].trans;
					System.out.println(sum);
				}
			}
			System.out.println(sum/31);
			//System.out.println("��嚙踝蕭");
		}
	}
	
	
	public static void main(String[] argv)throws IOException {
		Scanner scanner = new Scanner(System.in);
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		
		int len = 1;
	    String[] strs = new String[500];
	    Scanner sc = null;
	 
	    sc = new Scanner(new File("src/input.txt"));
	
	    while (sc.hasNext()) {
	      strs[len] = sc.next(); 
	      len++;
	    }
	    sc.close();
	    
	    //sSystem.out.println(index);
	    int index = 0;
	    for(int j = 1; j < len; j++) {
	    	if(j%3 == 0) {
	    		var[index].trans = Integer.valueOf(strs[j]);
	    		index++;
	    	}else if(j%3 == 1) {
	    		var[index].id = Integer.valueOf(strs[j]);
	    	}
	    	else if(j%3 == 2) {
	    		var[index].date = Integer.valueOf(strs[j]);
	    	}
	    }
	    
	    System.out.println("頛詨 ID ��� Q(蝯�蝙�)?");//user input id
	    int id_in = scanner.nextInt();
	    
	    //check if id exist
	    int check=0;
	    for(int i=0; i<=len;i++) {
	    	if(id_in == var[i].id) check = 1;
	    }
	    
	    if(check == 1) System.out.println("Welcome "+id_in+"");
	    else System.out.println("你的ID打錯摟~再檢查一次!");//print:enter the id again
	    
		System.out.println("��岳�嚙踝蕭�隤�:\n"
				+ "1) A ����鞈���蕭�\n"
				+ "2) B ���嚙踝嚙踝�貊��孕��蕭嚙踝蕭�n"
				+ "3) C ���嚙踝�謍梱�蕭嚙踐�蕭��孕嚙踝蕭�嚙踝n"
				+ "4) D ���嚙踝�謍梧蕭��嚙踐��嚙踝嚙踝�孕嚙踝蕭�嚙踝n"
				+ "5) Q 嚙踐�蕭嚙踝��撏孓");
		char choice = scanner.next().charAt(0);

		if(choice == 'A') TotalExpense(var,id_in, len); 
		else if(choice == 'B') Allrecords(var,id_in, len);
		else if(choice == 'C') DayTrans(var,id_in, len);
		else if(choice == 'D') AvgTrans(var,id_in, len);
	}
}

