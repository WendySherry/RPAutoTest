
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import junit.framework.TestCase;


public class Nextday extends TestCase{
	/**
	 * 测试类：Date
	 * 测试方法：date
	 * 1.语句覆盖
	 */
	@Test
	public void testDate() {
		Date date=new Date(10, 12, 2001);
		assertEquals(10,date.getMonth().getCurrentPos());
		assertEquals(12, date.getDay().getCurrentPos());
		assertEquals(2001, date.getYear().getCurrentPos());
	}

	/**
	 * 测试类：Date
	 * 测试方法：increment
	 * 1.分支覆盖、条件覆盖
	 *   d.increment()：F
	 *   m.increment()：T
	 */
	@Test
	public void testDateIncrement1() {
		Date date=new Date(10, 31, 1000);
		date.increment();
		Date expectedDate=new Date(11, 1, 1000);
		assertEquals(expectedDate,date);
	}

	/**
	 * 测试类：Date
	 * 测试方法：increment
	 * 1.边界值测试
	 * 	   取值范围：  年：不等于0的整数   月：1-12    日：范围随年月变化 
	 * 2.分支覆盖、条件覆盖
	 *   d.increment()：F
	 *   m.increment()：F
	 */
	@Test
	public void testDateIncrement2() {
		Date date=new Date(12, 31, 2012);
		date.increment();
		Date expectedDate=new Date(1, 1, 2013);
		assertEquals(expectedDate,date);
	}
	/**
	 * 测试类：Date
	 * 测试方法：increment
	 * 1.边界值测试
	 * 	   取值范围：  年：不等于0的整数   月：1-12    日：范围随年月变化 
	 * 2.分支覆盖、条件覆盖
	 *   d.increment()：T
	 *   m.increment()：T
	 */
	@Test
	public void testDateIncrement3() {
		Date date=new Date(2, 28, 2012);
		date.increment();
		Date expectedDate=new Date(2, 29, 2012);
		assertEquals(expectedDate,date);
	}

	/**
	 * 测试类：Date
	 * 测试方法：printDate
	 * 1.语句覆盖
	 *   将控制台输出重定向到文件out.txt，然后从文件中读取输出，与期望输出比较
	 */
	@Test
	public void testPrintDate() {
		try {
			Date date=new Date(2, 28, 2012);			
			PrintStream ps=new PrintStream(new FileOutputStream("out.txt"));		
			System.setOut(ps);
			date.printDate();
			FileReader reader=new FileReader("out.txt");
			@SuppressWarnings("resource")
			BufferedReader buffer=new BufferedReader(reader);
			String line;
			line = buffer.readLine();
			assertEquals("2/28/2012",line);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	/**
	 * 测试类：Date
	 * 测试方法：getDay
	 * 1.边界值测试
	 * 2.语句覆盖
	 */
	@Test
	public void testDateGetDay() {
		Date date=new Date(2, 28, 2012);	
		assertEquals(28,date.getDay().getCurrentPos());		
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：getMonth
	 * 1.边界值测试
	 * 2.语句覆盖
	 */
 	@Test
	public void testDateGetMonth() {
		Date date=new Date(12, 31, 1999);	
		assertEquals(12,date.getMonth().getCurrentPos());	
	}

	/**
	 * 测试类：Date
	 * 测试方法：getYear
	 * 1.边界值测试
	 * 2.语句覆盖
	 */
	@Test
	public void testDateGetYear() {
		Date date=new Date(1, 1, 1000);	
		assertEquals(1000,date.getYear().getCurrentPos());	
	} 

	/**
	 * 测试类：Date
	 * 测试方法：equals
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   o instanceof Date：T
	 *   this.y.equals(((Date) o).y)：T 
	 *   this.m.equals(((Date) o).m)：T
	 *   this.d.equals(((Date) o).d)：T
	 *   this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)&& this.d.equals(((Date) o).d)：T
	 */
	public void testDateEqualsObject1(){
		Date date1=new Date(2, 28, 2012);
		Date date2=new Date(2, 28, 2012);		 
		boolean b=date1.equals(date2);
		assertTrue(b);		 
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：equals
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   o instanceof Date：T
	 *   this.y.equals(((Date) o).y)：T 
	 *   this.m.equals(((Date) o).m)：T
	 *   this.d.equals(((Date) o).d)：F
	 *   this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)&& this.d.equals(((Date) o).d)：F
	 */
	public void testDateEqualsObject2(){
		Date date1=new Date(2, 28, 2012);
		Date date2=new Date(2, 29, 2012);	
		boolean b=date1.equals(date2);
		assertFalse(b); 
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：equals
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   o instanceof Date：T
	 *   this.y.equals(((Date) o).y)：T 
	 *   this.m.equals(((Date) o).m)：F
	 *   this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)&& this.d.equals(((Date) o).d)：F
	 */
	public void testDateEqualsObject3(){
		Date date1=new Date(2, 28, 2012);
		Date date2=new Date(1, 28, 2012);
		boolean b=date1.equals(date2);
		assertFalse(b);
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：equals
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   o instanceof Date：T
	 *   this.y.equals(((Date) o).y)：F 
	 *   this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)&& this.d.equals(((Date) o).d)：F
	 */
	public void testDateEqualsObject4(){
		Date date1=new Date(2, 28, 2012);
		Date date2=new Date(2, 28, 2001);	
		boolean b=date1.equals(date2);
		assertFalse(b); 
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：equals
	 * 1.无效等价类测试
	 * 2.条件覆盖、分支覆盖
	 *   o instanceof Date：F
	 */
	public void testDateEqualsObject5(){
		Date date1=new Date(8, 8, 2008);
		int i=1; 	
		boolean b=date1.equals(i);
		assertFalse(b); 
	}
	
	/**
	 * 测试类：Date
	 * 测试方法：toString
	 * 1.边界值测试
	 * 2.语句覆盖
	 */
 	@Test
	public void testDateToString() {
		Date date=new Date(1, 31, 1996);
		String str=date.toString();
		assertEquals("1/31/1996",str);
	}
 
 	
 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   currentPos <= m.getMonthSize()：F
	 */
	@Test
	public void testDayIncrement1() {
		Year year=new Year(2009);
		Month month=new Month(12, year);
		Day day=new Day(31, month);
		boolean b=day.increment();
		assertFalse(b);	
	}
	
 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   currentPos <= m.getMonthSize()：T
	 */
	@Test
	public void testDayIncrement2() {
		Year year=new Year(2009);
		Month month=new Month(12, year);
		Day day1=new Day(30, month);
		boolean b1=day1.increment();
		assertTrue(b1);
	}

 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   m != null：T
	 *   m.isValid()：T
	 *   m != null && m.isValid()：T
	 *   this.currentPos >= 1：T 
	 *   this.currentPos <= m.getMonthSize()：T
	 *   this.currentPos >= 1 && this.currentPos <= m.getMonthSize()：T
	 */
	@Test
	public void testDayIsValid1() {
		Year year=new Year(2000);
		Month month=new Month(1, year);
		Day day=new Day(1, month);
		boolean b=day.isValid();
		assertTrue(b);		
	}

 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   m != null：T
	 *   m.isValid()：T
	 *   m != null && m.isValid()：T
	 *   this.currentPos >= 1：T 
	 *   this.currentPos <= m.getMonthSize()：F
	 *   this.currentPos >= 1 && this.currentPos <= m.getMonthSize()：F
	 */
	@Test
	public void testDayIsValid2() {
		Year year=new Year(1999);
		Month month=new Month(2, year);
		try {
			Day day=new Day(29, month);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid day", e.getMessage());
		}
	}

 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.无效等价类测试  
	 * 2.分支覆盖、条件覆盖
	 *   m != null：F
	 */
	@Test
	public void testDayIsValid3() {
		Month month=null;
		try {
			Day day=new Day(1, month);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid day", e.getMessage());
		}
	}

 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.无效等价类测试
	 * 2.分支覆盖、条件覆盖
	 *   m != null：T
	 *   m.isValid()：T
	 *   m != null && m.isValid()：T
	 *   this.currentPos >= 1：F 
	 *   this.currentPos >= 1 && this.currentPos <= m.getMonthSize()：F
	 */
	@Test
	public void testDayIsValid4() {
		Year year=new Year(319);
		Month month=new Month(2, year);;
		try {
			Day day=new Day(0, month);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid day", e.getMessage());
		}
	}
 	/**
	 * 测试类：Day
	 * 测试方法：increment
	 * 1.无效等价类测试
	 * 2.分支覆盖、条件覆盖
	 *   m != null：T
	 *   m.isValid()：F
	 */
	@Test
	public void testDayIsValid5() {
		Year year=new Year(200);
		Month month=new Month(2, year);;
		try {
			month.setMonth(0, year);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());
		}
		try {
			Day day=new Day(12, month);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid day", e.getMessage());
		}		
	}
	/**
	 * 测试类：Day
	 * 测试方法：day
	 * 1.边界值测试
	 */
	@Test
	public void testDay() {
		Year year=new Year(1992);
		Month month=new Month(1, year);
		Day day=new Day(1, month);
		assertEquals(1, day.getDay());
	}

	/**
	 * 测试类：Day
	 * 测试方法：setDay
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   this.isValid()：T
	 */
	@Test
	public void testDaySetDay1() {
		Year year=new Year(2000);
		Month month=new Month(12, year);
		Day day=new Day(29, month);
		assertEquals(29, day.getDay());
		day.setDay(31, month);
		assertEquals(31, day.getDay());
	}

	/**
	 * 测试类：Day
	 * 测试方法：setDay
	 * 1.边界值测试
	 * 2.分支覆盖、条件覆盖
	 *   this.isValid()：T
	 */
	@Test
	public void testDaySetDay2() {
		Year year=new Year(2000);
		Month month=new Month(12, year);
		Day day=new Day(29, month);
		assertEquals(29, day.getDay());
		try {
			day.setDay(0, month);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid day", e.getMessage());
		}
	}
	/**
	 * 测试类：Day
	 * 测试方法：getDay
	 * 1.边界值测试
	 */
	@Test
	public void testDayGetDay() {
		Year year=new Year(2030);
		Month month=new Month(2, year);
		Day day=new Day(28, month);
		assertEquals(28, day.getDay());
	}

	/**
	 * 测试类：Day
	 * 测试方法：equalsObject
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   o instanceof Day：T
	 *   this.currentPos == ((Day) o).currentPos：T
	 *   this.m.equals(((Day) o).m)：T
	 *   this.currentPos == ((Day) o).currentPos&& this.m.equals(((Day) o).m)：T
	 */
	@Test
	public void testDayEqualsObject1(){
		Year year=new Year(2002);
		Month month=new Month(3, year);
		Day day=new Day(31, month);
		Day day1=new Day(31, month);
		boolean b=day.equals(day1);
		assertTrue(b);		
	}
	
	/**
	 * 测试类：Day
	 * 测试方法：equalsObject
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   o instanceof Day：T
	 *   this.currentPos == ((Day) o).currentPos：F
	 *   this.currentPos == ((Day) o).currentPos&& this.m.equals(((Day) o).m)：F
	 */
	@Test
	public void testDayEqualsObject2(){
		Year year=new Year(2002);
		Month month=new Month(3, year);
		Day day=new Day(31, month);
		Day day1=new Day(30, month);
		boolean b=day.equals(day1);
		assertFalse(b);		
	}
	
	/**
	 * 测试类：Day
	 * 测试方法：equalsObject
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   o instanceof Day：T
	 *   this.currentPos == ((Day) o).currentPos：T
	 *   this.m.equals(((Day) o).m)：F
	 *   this.currentPos == ((Day) o).currentPos&& this.m.equals(((Day) o).m)：F
	 */
	@Test
	public void testDayEqualsObject3(){
		Year year=new Year(1562);
		Month month=new Month(9, year);
		Month month1=new Month(11, year);
		Day day=new Day(30, month);
		Day day1=new Day(30, month1);
		boolean b=day.equals(day1);
		assertFalse(b);	
	}
	
	/**
	 * 测试类：Day
	 * 测试方法：equalsObject
	 * 1.无效等价类测试
	 * 2.条件测试、分支测试
	 *   o instanceof Day：F
	 */
	@Test
	public void testDayEqualsObject4(){
		Year year=new Year(1992);
		Month month=new Month(9, year);
		Day day=new Day(30, month);
		int i=10;
		boolean b=day.equals(i);
		assertFalse(b);	
	}
	
	
	/**
	 * 测试类：Month
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   currentPos>12：T
	 */
	@Test
	public void testMonthIncrement1() {
		Year year=new Year(2009);
		Month month=new Month(12, year);
		boolean b=month.increment();
		assertFalse(b);		
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：increment
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   currentPos>12：F
	 */
	@Test
	public void testMonthIncrement2() {
		Year year=new Year(2009);
		Month month=new Month(10, year);
		boolean b=month.increment();
		assertTrue(b);
	}

	/**
	 * 测试类：Month
	 * 测试方法：isVaild
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   y != null && y.isValid()：T&&T=T
	 *   this.currentPos >= 1 && this.currentPos <= 12：T&&F=F 
	 */
	@Test
	public void testMonthIsValid1() {
		Year year=new Year(1990);
		try {
			Month month=new Month(13, year);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());
		}				
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：isVaild
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   y != null && y.isValid()：T&&T=T
	 *   this.currentPos >= 1 && this.currentPos <= 12：T&&T=T 
	 */
	@Test
	public void testMonthIsValid2() {
		Year year=new Year(1990);
		Month month=new Month(1, year);
		boolean b=month.isValid();
		assertTrue(b);
	}

	/**
	 * 测试类：Month
	 * 测试方法：isVaild
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 */
	@Test
	public void testMonthIsValid3() {
		Year year = new Year(1000);
		try {
			year.setYear(0);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month",e.getMessage());
		}
		try {
			Month month=new Month(1, year);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month",e.getMessage());
		}	
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：isVaild
	 * 1.边界值测试
	 * 2.条件测试、分支测试
	 *   y != null && y.isValid()：F&&X=F 
	 */
	@Test
	public void testMonthIsValid4() {
		Year year=null;
		try {
			Month month=new Month(1, year);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());
		}	
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：month
	 * 1.边界值测试
	 * 2.语句覆盖 
	 */
	@Test
	public void testMonth() {
		Year year=new Year(1789);
		Month month=new Month(12, year);
		assertEquals(12, month.getCurrentPos());
	}

	/**
	 * 测试类：Month
	 * 测试方法：setMonth
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   !this.isValid():F
	 */
	@Test
	public void testMonthSetMonth1() {
		Year year=new Year(1002);
		Month month=new Month(12, year);
		month.setMonth(1, year);
		assertEquals(1, month.getCurrentPos());		
	}

	/**
	 * 测试类：Month
	 * 测试方法：setMonth
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖 
	 *   !this.isValid():T
	 */
	@Test
	public void testMonthSetMonth2() {
		Year year=new Year(1002);
		Month month=new Month(1, year);
		try {
			month.setMonth(0, year);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());
		}
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：getMonth
	 * 1.语句覆盖 
	 */
	@Test
	public void testMonthGetMonth() {
		Year year=new Year(2010);
		Month month=new Month(9, year);
		assertEquals(9, month.getMonth());		
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：getMonthSize
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   y.isLeap()：T 
	 */
	@Test
	public void testGetMonthSize1() {
		Year year=new Year(1996);
		Month month=new Month(2, year);
		assertEquals(29, month.getMonthSize());		
	}

	/**
	 * 测试类：Month
	 * 测试方法：getMonthSize
	 * 1.边界值测试
	 * 2.条件覆盖、分支覆盖
	 *   y.isLeap()：F
	 */
	@Test
	public void testGetMonthSize2() {		
		Year year=new Year(2100);
		Month month=new Month(2, year);
		assertEquals(28, month.getMonthSize());
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：equals
	 * 1.条件覆盖、分支覆盖
	 *   o instanceof Month：T
	 *   this.currentPos == ((Month) o).currentPos&& this.y.equals(((Month) o).y)：T&&T=T
	 */
	@Test
	public void testMonthEqualsObject1() {
		Year year=new Year(2002);
		Month month=new Month(3, year);
		Month month1=new Month(3, year);
		boolean b=month.equals(month1);
		assertTrue(b);		
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：equals
	 * 1.条件覆盖、分支覆盖
	 *   o instanceof Month：T
	 *   this.currentPos == ((Month) o).currentPos&& this.y.equals(((Month) o).y)：F&&T=F
	 */
	@Test
	public void testMonthEqualsObject2() {
		Year year=new Year(2002);
		Month month=new Month(3, year);		
		Month month1=new Month(12, year);
		boolean b=month.equals(month1);
		assertFalse(b);
	}

	/**
	 * 测试类：Month
	 * 测试方法：equals
	 * 1.条件覆盖、分支覆盖
	 *   o instanceof Month：T
	 *   this.currentPos == ((Month) o).currentPos&& this.y.equals(((Month) o).y)：T&&F=F
	 */
	@Test
	public void testMonthEqualsObject3() {
		Year year=new Year(2002);
		Year year1=new Year(2012);
		Month month=new Month(2, year);		
		Month month1=new Month(2, year1);
		boolean b=month.equals(month1);
		assertFalse(b);
	}
	
	/**
	 * 测试类：Month
	 * 测试方法：equals
	 * 1.条件覆盖、分支覆盖
	 *   o instanceof Month：F
	 */
	@Test
	public void testMonthEqualsObject4() {
		Year year=new Year(2002);
		Month month=new Month(3, year);		
		int i=1;
		boolean b=month.equals(i);
		assertFalse(b);
	}
	

	
	/**
	 *  测试类：Year
	 *  测试方法：increment
	 *  1.条件覆盖、分支覆盖
	 *  currentPos == 0：F
	 */
	@Test
	public void testYearIncrement1() {
		Year year=new Year(2009);
		boolean b=year.increment();
		assertEquals(2010, year.getCurrentPos());
		assertTrue(b);	
	}

	/**
	 *  测试类：Year
	 *  测试方法：increment
	 *  1.条件覆盖、分支覆盖
	 *  currentPos == 0：T
	 */
	@Test
	public void testYearIncrement2() {
		Year year=new Year(-1);
		boolean b=year.increment();
		assertEquals(1, year.getCurrentPos());
		assertTrue(b);	
	}
	/**
	 *  测试类：Year
	 *  测试方法：isVaild
	 *  1.边界值测试
	 *  2.条件覆盖、分支覆盖
	 *    this.currentPos != 0：T
	 */
	@Test
	public void testYearIsValid1() {
		Year year=new Year(1666);
		boolean b=year.isValid();
		assertTrue(b);	
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isVaild
	 *  1.无效等价类测试
	 *  2.条件覆盖、分支覆盖
	 *    this.currentPos != 0：F
	 */
	@Test
	public void testYearIsValid2() {
		try {
			Year year=new Year(0);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());
		}	
	}

	/**
	 *  测试类：Year
	 *  测试方法：Year 
	 */
	@Test
	public void testYear() {
		Year year=new Year(1666);
		assertEquals(1666, year.getCurrentPos());
	}

	/**
	 *  测试类：Year
	 *  测试方法：setYear 
	 *  1.无效等价类测试
	 *  2.条件覆盖、分支覆盖
	 *    !this.isValid()：T
	 */
	@Test
	public void testYearSetYear1() {
		Year year=new Year(1666);
		assertEquals(1666, year.getCurrentPos());		
		try {
			year.setYear(0);
		} catch (IllegalArgumentException e) {
			assertEquals("Not a valid month", e.getMessage());		
		}
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：setYear 
	 *  1.条件覆盖、分支覆盖
	 *    !this.isValid()：F
	 */
	@Test
	public void testYearSetYear2() {
		Year year=new Year(1666);
		year.setYear(1000);
		assertEquals(1000, year.getCurrentPos());		
	}

	/**
	 *  测试类：Year
	 *  测试方法：getYear 
	 */
	@Test
	public void testYearGetYear() {
		Year year=new Year(2001);
		assertEquals(2001, year.getYear());
	}

	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  T&&((T&&F)||F)=F
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  F
	 */
	@Test
	public void testIsLeap1() {		
		Year year1=new Year(1800);
		assertFalse(year1.isLeap());
	}

	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  T&&((T&&F)||T)=T
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  F
	 */
	@Test
	public void testIsLeap2() {
		Year year2=new Year(2000);
		assertTrue(year2.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  T&&((F&&T)||F)=T
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  F
	 */
	@Test
	public void testIsLeap3() {
		Year year3=new Year(1991);
		assertFalse(year3.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  F
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  T&&((T&&F)||F)=F
	 */
	@Test
	public void testIsLeap4() {
		Year year4=new Year(-1991);
		assertFalse(year4.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  F
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  T&&((T&&T)||F)=T
	 */
	@Test
	public void testIsLeap5() {
		Year year5=new Year(-1021);
		assertTrue(year5.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  F
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  T&&((T&&F)||F)=F
	 */
	@Test
	public void testIsLeap6() {
		Year year6=new Year(-1801);
		assertFalse(year6.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  F
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  T&&((T&&F)||T)=T
	 */
	@Test
	public void testIsLeap7() {
		Year year7=new Year(-2001);
		assertTrue(year7.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：isLeap 
	 *  1.条件覆盖、分支覆盖
	 *  currentPos >= 0&& (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0))：
	 *  T&&((T&&T)||F)=T
	 *  currentPos < 0&& ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1))：
	 *  F
	 */
	@Test
	public void testIsLeap8() {
		Year year8=new Year(1020);
		assertTrue(year8.isLeap());
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：equals
	 *  1.条件覆盖、分支覆盖
	 *    o instanceof Year：T
	 *    this.currentPos == ((Year) o).currentPos：T 
	 */  
	@Test
	public void testYearEqualsObject1() {
		Year year=new Year(2002);		
		Year year1=new Year(2002);
		boolean b=year.equals(year1);
		assertTrue(b);		
	}

	/**
	 *  测试类：Year
	 *  测试方法：equals
	 *  1.条件覆盖、分支覆盖
	 *    o instanceof Year：T
	 *    this.currentPos == ((Year) o).currentPos：F
	 */  
	@Test
	public void testYearEqualsObject2() {
		Year year=new Year(2002);		
		Year year2=new Year(1002);
		boolean b2=year.equals(year2);
		assertFalse(b2);
		int i=1;
		boolean b3=year.equals(i);
		assertFalse(b3);
	}
	
	/**
	 *  测试类：Year
	 *  测试方法：equals
	 *  1.条件覆盖、分支覆盖
	 *    o instanceof Year：F 
	 */  
	@Test
	public void testYearEqualsObject3() {
		Year year=new Year(2002);				
		int i=1;
		boolean b3=year.equals(i);
		assertFalse(b3);
	}

	
}
