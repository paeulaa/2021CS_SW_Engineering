package demo;
import java.lang.*;
import java.util.Scanner;
import java.io.*;
import java.lang.String;
import java.util.Arrays;

class table{
	public int id, date, trans;
}

public class demo_class {
	public static void main(String[] argv)throws IOException {
		int input;
		Scanner scanner = new Scanner(System.in);
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		/*
		File file = new File("src/input.txt");
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr);
        
		while (br.ready()) {
			System.out.println(br.readLine());
        }
        fr.close();
        */
		
		int len = 1;
	    String[] strs = new String[500];
	    Scanner sc = null;
	 
	    sc = new Scanner(new File("src/input.txt"));
	
	    while (sc.hasNext()) {
	      strs[len] = sc.next(); // 下面增加 i++ 的話 也是讀到空值
	      //System.out.println(strs[index]); // strs[i] 跟 strs[0] 結果都一樣 strs[1]會讀到空值
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
	    /*
	    for(int i = 0; i < 700; i++) {
	    	System.out.println(var[i].id);
	    	System.out.println(var[i].date);
	    	System.out.println(var[i].trans);
		}
	    */
	    
		System.out.println("輸入指令:\n"
				+ "1) A 顯示總支出\n"
				+ "2) B 顯示全部消費紀錄\n"
				+ "3) C 顯示特定日期消費金額\n"
				+ "4) D 顯示特定月份日平均消費金額\n"
				+ "5) Q 離開系統\n");
		char choice = scanner.next().charAt(0);
		if(choice == 'C') {
			System.out.println("請輸入特定日期:");
			input = scanner.nextInt();
			int sum = 0;
			for(int i = 0; i<=len ;i++) {
				//System.out.println("啾咪");
				if(input == var[i].date){
					sum += var[i].trans;
				}
			}System.out.println(sum);
		}
		else if(choice == 'D') {
			System.out.println("請輸入特定月份:");
			input = scanner.nextInt();
			int month = input%100;
			int year = input/100;
			float sum = 0;
			if(month == 2) {
				if(year%4 != 0 || (year%100 == 0 && year%400 !=0) ) {
					for(int i = 0; i<= len ;i++) {
						if((var[i].date/100)%100 == 2 && var[i].date/10000 == year){
							sum = sum + var[i].trans;
						}
					}
					System.out.println(sum/28);
					//System.out.println("Feb平");
				}else if((year%4 == 0 && year%100 !=0) || year%400 == 0) {
					for(int i = 0; i<= len ;i++) {
						if((var[i].date/100)%100 == 2 && var[i].date/10000 == year){
							sum = sum + var[i].trans;
						}
					}
					System.out.println(sum/29);
					//System.out.println("Feb潤");
				}
			}else if(month == 4 || month == 6 || month == 9 || month == 11) {
				for(int i = 0; i<= len ;i++) {
					if(month == (var[i].date/100)%100 && var[i].date/10000 == year){
						sum = sum + var[i].trans;
					}
				}
				System.out.println(sum/30);
				//System.out.println("小月");
			}else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
				for(int i = 0; i<= len ;i++) {
					if(month == (var[i].date/100)%100 && var[i].date/10000 == year){
						sum = sum + var[i].trans;
						System.out.println(sum);
					}
				}
				System.out.println(sum/31);
				//System.out.println("大月");
			}
		}
		
	}
}
