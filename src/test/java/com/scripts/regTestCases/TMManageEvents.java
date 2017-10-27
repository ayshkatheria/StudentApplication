package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageEventsBL;

import utils.load.dataSource.ExcelLib;

import com.scripts.lib.commonFunction.Driver;

public class TMManageEvents extends Driver {
	ManageEventsBL mngeEvntbl;
	LoginBL loginLib;
	ExcelLib excelData;
	String userName, passWord, userType, districtName, eventName,
			selectDescription, candidateDescription, eventType,
			facilitatorDescription, timeZone, strtTme,endtime, drpdwnFacilitatorEvents,
			drpdwnCandidatesEvents, oldEventName, newEventName,
			candidateSubject;
	Random randomGenerator;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		mngeEvntbl = new ManageEventsBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		excelData.setExcelData("Events", 1, 2,
				"AutoEvent" + randomGenerator.nextInt(99999));
		userName = excelData.getExcelData("Login", 1, 1);
		passWord = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Manage Events with TM Admin");
		loginLib.login(userName, passWord, userType);
		mngeEvntbl.navigateToEventsTM();
	}

	//@Test(priority = 1)
	@Test
	public void verifyMandatoryFields() throws Exception {
		mngeEvntbl.verifyMandatoryFields();
		
		districtName = excelData.getExcelData("Events", 1, 1);
		eventName = excelData.getExcelData("Events", 1, 2);
		eventType = excelData.getExcelData("Events", 1, 3);
		selectDescription = excelData.getExcelData("Communication", 2, 6);
		candidateDescription = excelData.getExcelData("Communication", 4, 6);
		facilitatorDescription = excelData.getExcelData("Communication", 3, 6);
		timeZone = excelData.getExcelData("Events", 1, 4);
		strtTme = excelData.getExcelData("Events", 1, 5);
		endtime = excelData.getExcelData("Events", 1, 8);
		drpdwnFacilitatorEvents = excelData.getExcelData("Events", 1, 6);
		drpdwnCandidatesEvents = excelData.getExcelData("Events", 1, 7);
		mngeEvntbl.addEvents(userType, districtName, eventName, eventType,
				selectDescription, candidateDescription,
				facilitatorDescription, timeZone, strtTme,endtime,
				drpdwnFacilitatorEvents, drpdwnCandidatesEvents);
		
		districtName = excelData.getExcelData("Events", 1, 1);
		eventName = excelData.getExcelData("Events", 1, 2);
		eventType = excelData.getExcelData("Events", 1, 3);
		drpdwnCandidatesEvents = excelData.getExcelData("Events", 1, 7);
		candidateSubject = excelData.getExcelData("Communication", 4, 7);
		mngeEvntbl.searchEventsWithLogs(userType, districtName, eventName,
				eventType, drpdwnCandidatesEvents, candidateSubject);
		
			 districtName = excelData.getExcelData("Events", 1, 1);
			 oldEventName = excelData.getExcelData("Events", 1, 2);
			 eventType = excelData.getExcelData("Events", 1, 3);
			 excelData.setExcelData("Events", 1, 2, "AutoEventEdited"
			 + randomGenerator.nextInt(99999));
			 newEventName = excelData.getExcelData("Events", 1, 2);
			 mngeEvntbl.editEvents(userType, districtName, oldEventName, eventType,
			 newEventName);
	}

	/*@Test(priority = 2)
	public void addEvents() throws Exception {
		districtName = excelData.getExcelData("Events", 1, 1);
		eventName = excelData.getExcelData("Events", 1, 2);
		eventType = excelData.getExcelData("Events", 1, 3);
		selectDescription = excelData.getExcelData("Communication", 2, 6);
		candidateDescription = excelData.getExcelData("Communication", 4, 6);
		facilitatorDescription = excelData.getExcelData("Communication", 3, 6);
		timeZone = excelData.getExcelData("Events", 1, 4);
		strtTme = excelData.getExcelData("Events", 1, 5);
		endtime = excelData.getExcelData("Events", 1, 8);
		drpdwnFacilitatorEvents = excelData.getExcelData("Events", 1, 6);
		drpdwnCandidatesEvents = excelData.getExcelData("Events", 1, 7);
		mngeEvntbl.addEvents(userType, districtName, eventName, eventType,
				selectDescription, candidateDescription,
				facilitatorDescription, timeZone, strtTme,endtime,
				drpdwnFacilitatorEvents, drpdwnCandidatesEvents);
	}

	@Test(priority = 3)
	public void searchEventsWithLogs() throws Exception {
		districtName = excelData.getExcelData("Events", 1, 1);
		eventName = excelData.getExcelData("Events", 1, 2);
		eventType = excelData.getExcelData("Events", 1, 3);
		drpdwnCandidatesEvents = excelData.getExcelData("Events", 1, 7);
		candidateSubject = excelData.getExcelData("Communication", 4, 7);
		mngeEvntbl.searchEventsWithLogs(userType, districtName, eventName,
				eventType, drpdwnCandidatesEvents, candidateSubject);
		
		
	}*/

/*	
	 @Test(priority = 4)
	 public void viewSchedulePage() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 eventName = excelData.getExcelData("Events", 1, 2);
	 eventType = excelData.getExcelData("Events", 1, 3);
	 mngeEvntbl.viewSchedulePage(userType, districtName, eventName,
	 eventType);
	 }
	
	 @Test(priority = 5)
	 public void viewFacilitatorPage() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 eventName = excelData.getExcelData("Events", 1, 2);
	 eventType = excelData.getExcelData("Events", 1, 3);
	 mngeEvntbl.viewFacilitatorPage(userType, districtName, eventName,
	 eventType);
	 }
	
	 @Test(priority = 6)
	 public void viewCandidatePage() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 eventName = excelData.getExcelData("Events", 1, 2);
	 eventType = excelData.getExcelData("Events", 1, 3);
	 mngeEvntbl.viewCandidatePage(userType, districtName, eventName,
	 eventType);
	 }*/                                                                              //Commented for sanity
	
	/* @Test(priority = 7)
	 public void editEvents() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 oldEventName = excelData.getExcelData("Events", 1, 2);
	 eventType = excelData.getExcelData("Events", 1, 3);
	 excelData.setExcelData("Events", 1, 2, "AutoEventEdited"
	 + randomGenerator.nextInt(99999));
	 newEventName = excelData.getExcelData("Events", 1, 2);
	 mngeEvntbl.editEvents(userType, districtName, oldEventName, eventType,
	 newEventName);
	 }*/
	
/*	 @Test(priority = 8)
	 public void printEventSingleRecord() throws Exception {
	 mngeEvntbl.printEventSingleRecord();
	 }
	
	 @Test(priority = 9)
	 public void deactivateEvents() throws Exception {
	 mngeEvntbl.deactivateEvents();
	 }
	
	 @Test(priority = 10)
	 public void dwldExcel() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 drpdwnCandidatesEvents = excelData.getExcelData("Events", 1, 7);
	 candidateDescription = excelData.getExcelData("Communication", 4, 6);
	 mngeEvntbl.dwldExcel(userType, districtName, drpdwnCandidatesEvents,
	 candidateDescription);
	 }
	
	 @Test(priority = 11)
	 public void printEventMultipleRecord() throws Exception {
	 districtName = excelData.getExcelData("Events", 1, 1);
	 mngeEvntbl.printEventMultipleRecord(userType, districtName);
	 }                                                                        //Commented for sanity
*/
	@AfterClass
	public void logout() throws InterruptedException {
		loginLib.logout();
	}
}