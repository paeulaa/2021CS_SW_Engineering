
package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.io.*;
import java.lang.String;

//import "demo_class.java";
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class StudentTests {

	private demo_class codetotest;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("beforeEach");
		codetotest = new demo_class();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
		codetotest = null;
	}

	/**
	* test method: codetotest.TotalExpense(table[], int, int)
	* test id: 10000001
	*/ 
	@Test
	void test1() throws IOException{
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  codetotest.read_data(var);
		len = var[0].id;
		
		
		int expected = 27264;
		int result = codetotest.TotalExpense(var, 10000001, 151);
		assertEquals(expected, result);
	}
	
	/**
	* test method: codetotest.TotalExpense(table[], int, int)
	* test id: 19254301
	*/ 
	@Test
	void test2() throws IOException{
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  demo_class.read_data(var);
		len = var[0].id;
		
		
		int expected = 26252;
		int result = codetotest.TotalExpense(var, 19254301, 151);
		assertEquals(expected, result);
		//fail("Not yet implemented1");
	}

	/**
	* test method: codetotest.Allrecords(table[], int, int)
	* test id: 19254301
	*/ 
	@Test
	void test3() throws IOException{
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  demo_class.read_data(var);
		len = var[0].id;
		
		codetotest.Allrecords(var, 19254301, 151);
		//System.out.println("Test3 succeed!");
		//fail("Not yet implemented1");
	}

	/**
	* test method: codetotest.Allrecords(table[], int, int)
	* test id: 15317546
	*/ 
	@Test
	void test4() throws IOException{
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  demo_class.read_data(var);
		len = var[0].id;
		
		codetotest.Allrecords(var, 15317546	, 151);
		
	}
	
	/**
	* test method: codetotest.DayTrans(table[], int, int)
	* test id: 18501179
	* test date: 20210101
	*/
	@Test
	void test5() throws IOException{ // scan 20210101
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  codetotest.read_data(var);
		len = var[0].id;
		
		int expected = 0;
		int result = codetotest.DayTrans(var, 18501179, 151);
		assertEquals(expected, result); 
		
	}
	
	/**
	* test method: codetotest.DayTrans(table[], int, int)
	* test id: 19254301
	* test date: 20180925
	*/
	@Test
	void test6() throws IOException{ //scan 20180925
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  codetotest.read_data(var);
		len = var[0].id;
		
		int expected = 4999;
		int result = codetotest.DayTrans(var, 19254301, 151);
		assertEquals(expected, result); 
	}
	
	/**
	* test method: codetotest.AvgTrans(table[], int, int)
	* test id: 12345678
	* test month: 201212
	*/
	@Test
	void test7() throws IOException{ //scan 201212
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  codetotest.read_data(var);
		len = var[0].id;
		
		double expected = 39.09677505493164;
		double result = codetotest.AvgTrans(var, 12345678, 151);
		assertEquals(expected, result); 
	}
	
	/**
	* test method: codetotest.AvgTrans(table[], int, int)
	* test id: 11254730
	* test month: 202007
	*/
	@Test
	void test8() throws IOException{ //scan 202007
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  codetotest.read_data(var);
		len = var[0].id;
		
		double expected = 52.935482025146484;
		double result = codetotest.AvgTrans(var, 11254730, 151);
		assertEquals(expected, result); 
	}

	/**
	* test method: 
	* 1. codetotest.TotalExpense(table[], int, int)
	* 2. codetotest.Allrecords(table[], int, int)
	* 3. codetotest.DayTrans(table[], int, int)
	* 4. codetotest.AvgTrans(table[], int, int)
	* test id: 15317546
	* test date: 20210301
	* test month: 202103
	*/
	@Test
	void integration1() throws IOException{ //scan 	20210301
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  demo_class.read_data(var);
		len = var[0].id;
		
		int expect1 = 150, expect2 = 150;
		double expect3 = 4.838709831237793;
		int result1 = codetotest.TotalExpense(var, 15317546, 151);
		codetotest.Allrecords(var, 15317546	, 151);
		int result2 = codetotest.DayTrans(var, 15317546, 151);
		double result3 = codetotest.AvgTrans(var, 15317546, 151);
		assertEquals(expect1, result1);
		assertEquals(expect2, result2);
		assertEquals(expect3, result3);
		
	}
	
	/**
	* test method: 
	* 1. codetotest.TotalExpense(table[], int, int)
	* 2. codetotest.Allrecords(table[], int, int)
	* 3. codetotest.DayTrans(table[], int, int)
	* 4. codetotest.AvgTrans(table[], int, int)
	* test id: 11254730
	* test date: 20210124
	* test month: 202101
	*/
	@Test
	void integration2() throws IOException{ //scan 20210124
		int len = 0;
		table[] var = new table[700];
		for(int i = 0; i < 700; i++) {
			var[i] = new table();
		}
		var =  demo_class.read_data(var);
		len = var[0].id;
		
		int expect1 = 0, expect2 = 0;
		double expect3 = 0;
		int result1 = codetotest.TotalExpense(var, 11254730, 151);
		codetotest.Allrecords(var, 11254730	, 151);
		int result2 = codetotest.DayTrans(var, 11254730, 151);
		double result3 = codetotest.AvgTrans(var, 11254730, 151);
		assertEquals(expect1, result1);
		assertEquals(expect2, result2);
		assertEquals(expect3, result3);
		
	}
	
}


