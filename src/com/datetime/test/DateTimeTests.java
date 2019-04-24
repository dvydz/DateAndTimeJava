package com.datetime.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeTests {

	public static void main(String[] args) {
		
		Instant i1=Instant.now();
		
		//SimpleDateFormat and currentTimeMillis
			System.out.println("***SimpleDateFormat and currentTimeMillis***");
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS z");
			long dateMilli=System.currentTimeMillis();
			String format=sdf.format(dateMilli);
			System.out.print(dateMilli+" equals ");
			System.out.println(format);
			
			SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date dt=null;
			try { dt = sdff.parse("01/22/2000 13:40:31"); } 
			catch (ParseException e) {e.printStackTrace(); }
			System.out.println(dt);
			System.out.println("----------------------------------------------");
			
		//DateTimeFormatter(new java 8)
			System.out.println("***DateTimeFormatter***");
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM-dd-yyyy");
			String formattedDate=dtf.format(LocalDate.now());
			System.out.println("DateTimeFormatter: "+formattedDate);
			System.out.println("----------------------------------------------");
		
		//Find the time interval it took to do a job/
			System.out.println("***Find the time interval it took to do a job***");
			SimpleDateFormat sdf2=new SimpleDateFormat("ss.SSS");
			long startTime=System.currentTimeMillis();
			System.out.println("-\\___/- DOING SOMETHING TO KILL TIME");
			long endTime=System.currentTimeMillis();
			System.out.println("Time it took: "+(sdf2.format(endTime-startTime)));
			System.out.println("----------------------------------------------");
		
		//Java.util.Date to get time
			System.out.println("***Java.util.Date to get time***");
			java.util.Date date=new java.util.Date();
			long time=date.getTime();
			System.out.println(sdf.format(time));
			System.out.println("OR the othe way");
			long milli=System.currentTimeMillis();
			java.util.Date date1=new java.util.Date(milli);
			System.out.println(sdf.format(date1));
			System.out.println("----------------------------------------------");
			
		//Compare two dates using comparable
			System.out.println("***Compare two dates using comparable***");
			java.util.Date d1=new java.util.Date();
			java.util.Date d2=new java.util.Date();
			System.out.println("0:Equal,1:greater,-1:smaller ! Result="+d1.compareTo(d2));
			System.out.println("----------------------------------------------");
			
		//Calendar, GregorianCalendar, Current date
			System.out.println("***Calendar, GregorianCalendar, Current date***");
			System.out.print("Current Date: ");
			Calendar calendar=new GregorianCalendar();
			System.out.print(calendar.get(Calendar.MONTH)+1+"/");
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"/");
			int year=calendar.get(Calendar.YEAR);
			System.out.println(year);
		//Custom date set for Calendar, GregorianCalendar 
			System.out.print("Custom Date: ");
			calendar.set(Calendar.MONTH, 11);
			calendar.set(Calendar.DAY_OF_MONTH, 31);
			calendar.set(Calendar.YEAR, 1999);
			System.out.print(calendar.get(Calendar.MONTH)+1+"/");
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"/");
			System.out.println(calendar.get(Calendar.YEAR));
		//adding a day
			System.out.print("After adding a day: ");
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			System.out.print(calendar.get(Calendar.MONTH)+1+"/");
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"/");
			System.out.println(calendar.get(Calendar.YEAR));
		//subtracting a day
			System.out.print("After Subtracting a day: ");
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			System.out.print(calendar.get(Calendar.MONTH)+1+"/");
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"/");
			System.out.println(calendar.get(Calendar.YEAR));
			System.out.println("----------------------------------------------");
			
		//Setting a different timezone(CST)
			System.out.println("***Setting a different timezone(CST)***");
			TimeZone timeZone1 = TimeZone.getTimeZone("CST");
			Calendar calendar1 = new GregorianCalendar();
			long timeEDT = calendar1.getTimeInMillis();
			System.out.println("CurrentTime(EDT)  = " + timeEDT);
			System.out.println("hour     = " + calendar1.get(Calendar.HOUR_OF_DAY));
			calendar1.setTimeZone(timeZone1);
			long timeTX = calendar1.getTimeInMillis();
			System.out.println("timeTX   = " + timeTX);
			System.out.println("hour     = " + calendar1.get(Calendar.HOUR_OF_DAY));
			System.out.println("----------------------------------------------");
		
		//Instant of time
			System.out.println("*****Instant of time******");
			Instant now=Instant.now();
			System.out.println("Epoch Second :"+now.getEpochSecond());
			System.out.println("Instant right now         :"+now);
			Instant later=now.plusSeconds(10);
			System.out.println("Instant 10 seconds later  :"+later);
			Instant earlier=now.minusMillis(50);
			System.out.println("Instant 50 millis earlier :"+earlier);
		//Duration between instant
			Instant i2=Instant.now();
			Duration duration=Duration.between(i1, i2);
			System.out.println("\nDuration between 2 instant i1 and i2: "+duration.toMillis()+" millis");
			System.out.println("----------------------------------------------");
		
		//LocalDate
			LocalDate localDate1=LocalDate.now();					//for current date
			LocalDate localDate2=LocalDate.of(2000, 8, 05);		//custom date
			Month month1=localDate1.getMonth();
			System.out.println("Month1: " + month1);
			Month month2=localDate2.getMonth();
			System.out.println("Month2: "+month2);
			System.out.println("Custom date(2000-08-05) Plus 2 years: "+localDate2.plusYears(2));
			//LocalTime, LocalDateTime and ZonedDateTime are done in the similar manner
			
	}

}
