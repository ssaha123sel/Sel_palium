package com.mercury.test;			


import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;

public class Driver {

	public static void main(String[] args) throws InterruptedException, FindFailed, AWTException, IOException {
		MR M1 = new MR();
	//	M1.browserMercuryAppLaunch();
		//M1.loginwithproperty();
		//M1.loginDynamic("dasd", "dasd");
		/*M1.login();												
		System.out.println(M1.login());*/		
		//M1.loginSikuli();
		//M1.loginRobot();
		//M1.loginverify();
		//M1.RegisterClick();
		//M1.Register();
		//M1.submitclick();
		//M1.browserClose();
		M1.autoid();
	}

}
