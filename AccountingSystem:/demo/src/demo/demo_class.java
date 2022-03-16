package demo;
import java.util.Scanner;
import java.io.*;
import java.lang.String;

class table{
	public int id, date, trans;
	
	
}

public class demo_class {
	/*** Calculate the total expense for user. 
	 * @param  table var[] save the input file information.
	 * @param  id_in save the id name.
	 * @param  sum used to calculate the total expense.
	 * @param  len save the input file size.
	 * @return sum(total expense) 
	 * * Example: TotalExpense(var,10000001, 151); return 27264. 
	 * Time estimate: O(len) 
	 */
	public static int TotalExpense(table var[],int id_in, int len) {
		int sum=0;
		for(int i = 0; i<=len ;i++) {
			if(id_in == var[i].id) {
				sum = sum+var[i].trans;
			}
		}
		return sum;
	}

	 /*** Print out all the transaction records for user. 
	 * @param  table var[] save the input file information.
	 * @param  id_in save the id name.
	 * @param  len save the input file size.
	 * @return void
	 * * Example: Allrecords(var,10000001, 151); 
	 * Time estimate: O(len) 
	 */
	public static void Allrecords(table var[],int id_in, int len) {
		for(int i = 0; i<=len ;i++) {
			if(id_in == var[i].id)
				System.out.println("日期:"+var[i].date+" 消費紀錄:"+var[i].trans+"元");
		}
		return;
	}

	 /*** Calculate the specific day expense for user. 
	 * @param  table var[] save the input file information.
	 * @param  id_in save the id name.
	 * @param  len save the input file size.
	 * @param  sum used to calculate the specific day expense.
	 * @param  input indicate the specific day.
	 * @throws NoSuchDateExceptions 
	 * If the input is invalid date, throw NoSuchDateExceptions 
	 * @return specific day expense if date is valid, recall DayTrans function otherwise 
	 * * Example: DayTrans(var,10000001, 151); type in 19961001; return 239. 
	 * Time estimate: O(len) 
	 */
	public static int DayTrans(table var[],int id_in, int len) {
		Scanner scanner_2 = new Scanner(System.in);
		System.out.println("請輸入特定日期 : ");
		int input = scanner_2.nextInt();
		int sum = 0;
		for(int i = 0; i<=len ;i++) {
			if(input == var[i].date && id_in == var[i].id){//add identify id condition
				sum += var[i].trans;
			}
		}
		//System.out.println("您在"+input+"的消費金額為: "+sum+" 元");
		return sum;
	}

	 /*** Calculate the average daily expense during specific month for user. 
	 * @param  table var[] save the input file information.
	 * @param  id_in save the id name.
	 * @param  len save the input file size.
	 * @param  sum used to calculate the specific month's total expense.
	 * @param  input indicate the specific month.
	 * @throws NoSuchDataExceptions 
	 * If the input is invalid, throw NoSuchDataExceptions 
	 * @return specific month average expense if month is valid, recall AvgTrans function otherwise 
	 * * Example: AvgTrans(var,10000001, 151); type in 200001; return 33.03. 
	 * Time estimate: O(len) 
	 */
	public static float AvgTrans(table var[],int id_in, int len) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入特定月份 : ");
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
				return sum/28;
				//System.out.println("您在"+ input+ "的日平均消費金額為: "+sum/28+" 元");
			}else if((year%4 == 0 && year%100 !=0) || year%400 == 0) {
				for(int i = 0; i<= len ;i++) {
					if((var[i].date/100)%100 == 2 && var[i].date/10000 == year && id_in == var[i].id){
						sum = sum + var[i].trans;
					}
				}
				//System.out.println("您在"+ input+ "的日平均消費金額為: "+sum/29+" 元");
				return sum/29;
			}
		}else if(month == 4 || month == 6 || month == 9 || month == 11) {
			for(int i = 0; i<= len ;i++) {
				if(month == (var[i].date/100)%100 && var[i].date/10000 == year && id_in == var[i].id){
					sum = sum + var[i].trans;
				}
			}
			//System.out.println("您在"+ input+ "的日平均消費金額為: "+sum/30+" 元");
			return sum/30;
		}else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
			for(int i = 0; i<= len ;i++) {
				if(month == (var[i].date/100)%100 && var[i].date/10000 == year && id_in == var[i].id){
					sum = sum + var[i].trans;
					//System.out.println(sum);
				}
			}
			//System.out.println(sum/31);
			//System.out.println("您在"+ input+ "的日平均消費金額為: "+sum/31+" 元");
			return sum/31;
		}
		return 0;
	}
	
	/*** Read the input file. 
	 * @param  table var[] save the input file information.
	 * @param  strs[] store the data read from input file.
	 * @param  len save the input file size, which is stored in var[0].
	 * @param  name is the relative path of input file.
	 * @return var[] 
	 * * Example: Readfile(name); return var[]. 
	 * Time estimate: O(len) 
	 */
	public static table[] read_data(table var[]) throws IOException{
	    String[] strs = new String[700];
	    Scanner sc = null;
	 
	    sc = new Scanner(new File("src/input.txt"));
	
	    int len = 1;
	    while (sc.hasNext()) {
	      strs[len] = sc.next(); 
	      len++;
	    }
	    sc.close();
	    
	    var[0].id = len;
	    int index = 1;
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
		return var;
	}
	
	
	public static void main(String[] argv)throws IOException {
		int len = 0;
		Scanner scanner = new Scanner(System.in);
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		
		var = read_data(var);
		len = var[0].id;
	    
		
	    int id_in = 0;
	    int exitornot_1 = 1;
	    while(exitornot_1 == 1) {
	    	String str2;
	    	System.out.println("輸入 ID 或 Q(結束使用)?");//user input id
		    str2 = scanner.next();
		    if(str2.charAt(0) == 'Q') {
		    	System.out.println("Bye Bye!");
		    	exitornot_1 = 0;
		    	return;
		    }
		    else if(str2.charAt(0) == '1' || str2.charAt(0) == '2' || str2.charAt(0) == '3' || str2.charAt(0) == '4' || str2.charAt(0) == '5' || str2.charAt(0) == '6' || str2.charAt(0) == '7' || str2.charAt(0) == '8' || str2.charAt(0) == '9'){
		    	id_in = Integer.valueOf(str2).intValue();
		    	
		    	 //check if id exist
			    int check=0;
			    for(int i=0; i<=len;i++) {
			    	if(id_in == var[i].id) check = 1;
			    }
			    if(check == 1) {
			    	System.out.println("Welcome "+id_in+"");
			    	exitornot_1 = 0;
			    }
			    else System.out.println("你的ID打錯了~再檢查一次!");//print:enter the id again
		    }else {
		    	System.out.println("查無此ID!");
		    }
	    }  
	    
	    
	    int exitornot_2 = 1;
	    while(exitornot_2 == 1) {
			System.out.println("輸入指令:\n"
					+ "1) A 顯示總支出\n"
					+ "2) B 顯示全部消費紀錄\n"
					+ "3) C 顯示特定日期消費金額\n"
					+ "4) D 顯示特定月份日平均消費金額\n"
					+ "5) Q 離開系統\n");
			char choice = scanner.next().charAt(0);
	
			if(choice == 'A') {
				int sum = TotalExpense(var, id_in, len); 
				System.out.println("您的總支出為: "+sum+" 元");//print total expense
			}
			else if(choice == 'B') Allrecords(var, id_in, len);
			else if(choice == 'C') {
				int sum = DayTrans(var, id_in, len);
				System.out.println("您在本日的消費金額為: "+sum+" 元");
			}
			else if(choice == 'D') {
				float sum = AvgTrans(var, id_in, len);
				System.out.println("您在本月的平均消費金額為: "+sum+" 元");
			}
			else if(choice == 'Q') {
				System.out.println("感謝您的使用！");
				exitornot_2 = 0;
			}else {
				System.out.println("指令錯了!");
			}
	    }
	    return;
	}
}

