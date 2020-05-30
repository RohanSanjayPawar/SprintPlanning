package com.sprintplanning.au.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sprintplanning.au.model.Task;
import com.sprintplanning.au.model.enums.TaskPriority;
import com.sprintplanning.au.model.enums.WorkStatus;

public class ExcelGenerator {

	public ExcelGenerator() 
	{
		
	}
	public List<Task> excel() throws FileNotFoundException, IOException, ParseException {
    FileInputStream file = new FileInputStream(new File("D:\\sprint1.xlsx"));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
	 
   int c1=sheet.getLastRowNum(); 
   
   //workbook.getsheet.getrowlength -> len
   List<Task> task = new ArrayList<>();
    for(int i=1;i<=c1;i++)
    {
    	Task t = new Task();
    	
    	  String s=workbook.getSheetAt(0).getRow(i).getCell(0).toString();
    	  t.setId(s);
          
    	   String s1=workbook.getSheetAt(0).getRow(i).getCell(1).toString();
    	   t.setName(s1);
           
    	   String s2=workbook.getSheetAt(0).getRow(i).getCell(2).toString();
           t.setProjectId(s2);
           
    	   String s3=workbook.getSheetAt(0).getRow(i).getCell(3).toString();
           t.setParentId(s2);
           
    	   String s4=workbook.getSheetAt(0).getRow(i).getCell(4).toString();
    	   double value = Double.valueOf(s4);
   		   t.setHours(value);
   		   
	   		String s7=workbook.getSheetAt(0).getRow(i).getCell(7).toString();
	   		switch(s7) {
			case "LOW":
				t.setPriority(TaskPriority.LOW);
				break;
			case "NORMAL":
				t.setPriority(TaskPriority.NORMAL);
				break;
			case "HIGH":
				t.setPriority(TaskPriority.HIGH);
				break;
			default:
				t.setPriority(TaskPriority.LOW);
				break;
		 }
	   
	        
	 	   String s8=workbook.getSheetAt(0).getRow(i).getCell(8).toString();
	        switch(s8) {
			case "STARTED":
				t.setStatus(WorkStatus.STARTED);
				break;
			case "ON_HOLD":
				t.setStatus(WorkStatus.ON_HOLD);
				break;
			case "WORK_IN_PROGRESS":
				t.setStatus(WorkStatus.WORK_IN_PROGRESS);
				break;
			case "YET_TO_START":
				t.setStatus(WorkStatus.YET_TO_START);
				break;
			case "COMPLETED":
				t.setStatus(WorkStatus.COMPLETED);
				break;
			default:
				t.setStatus(WorkStatus.STARTED);
				break;
		}


        
          System.out.println(workbook.getSheetAt(0).getRow(i).getCell(5));
          String parse =workbook.getSheetAt(0).getRow(i).getCell(5).toString();
          String par[]=parse.split("-");
          switch(par[1])
          {
          case "Jan":par[1]="01";break;
          case "Feb":par[1]="02";break;
          case "Mar":par[1]="03";break;
          case "Apr":par[1]="04";break;
          case "May":par[1]="05";break;
          case "Jun":par[1]="06";break;
          case "Jul":par[1]="07";break;
          case "Aug":par[1]="08";break;
          case "Sep":par[1]="09";break;
          case "Oct":par[1]="10";break;
          case "Nov":par[1]="11";break;
          case "Dec":par[1]="12";break;
          default:System.out.println("do nothing");
          }
         
          System.out.println(Arrays.toString(par));
          String time = String.join("-", par[2],par[1],par[0]);  
          System.out.println(time);
          t.setStartDate(Date.valueOf(time));

          System.out.println(workbook.getSheetAt(0).getRow(i).getCell(6));
          String parse1 =workbook.getSheetAt(0).getRow(i).getCell(5).toString();
          String par1[]=parse1.split("-");
          switch(par1[1])
          {
          case "Jan":par1[1]="01";break;
          case "Feb":par1[1]="02";break;
          case "Mar":par1[1]="03";break;
          case "Apr":par1[1]="04";break;
          case "May":par1[1]="05";break;
          case "Jun":par1[1]="06";break;
          case "Jul":par1[1]="07";break;
          case "Aug":par1[1]="08";break;
          case "Sep":par1[1]="09";break;
          case "Oct":par1[1]="10";break;
          case "Nov":par1[1]="11";break;
          case "Dec":par1[1]="12";break;
          default:System.out.println("do nothing");
          }
         
          System.out.println(Arrays.toString(par));
          String time1 = String.join("-", par[2],par[1],par[0]);  
          System.out.println(time1);
          t.setEndDate(Date.valueOf(time1));   
          System.out.println(t.toString());
          task.add(t);
    }
    for(Task student: task) {
        System.out.println(student.toString());  // Will invoke overrided `toString()` method
    }
    return task; 
}
	}
