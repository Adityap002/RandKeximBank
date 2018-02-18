package com.KeximBank.properties;

import java.io.IOException;

import com.KeximBank.master.Liberary;

public class BasicScript {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Liberary lib = new Liberary();
		
		// instantiate FF browser and launch application
		lib.openApp();
		
		//Login with Admin user
		lib.adminLogin("Admin", "Admin");
		
		Thread.sleep(2000);
		
		/*//Click on Brnaches Button
		lib.brnches("Chelesea", "MANCHESTER United", "20300", "UK", "England", "MANCHESTER");*/
		
		/*//Create new Roles
		lib.roles("Nokia1", "C");*/
		
		//Create new Emp
		lib.employee("Adityap", "@123Aditya", "Asst.Manager", "Manikonda Branch");
		
		//Logout from the application
		lib.logoutApp();
		
		//Quit browser
		lib.quitBrowser();
		

	}

}
