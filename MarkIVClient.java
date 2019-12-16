/* This is the main client to test the coffee maker
 * @author Nhan Vo
 */
import CoffeeMaker.CoffeeMaker;
import CoffeeMakerAPI.CoffeeMakerAPI;
import CoffeePot.*;

public class MarkIVClient{
	public static void print(String s) {
		System.out.println(s);
	}
	public static void MorningRoutingCoffee(CoffeeMakerAPI api, CoffeeMaker markiv) throws InterruptedException {
		print("\nA. Coffee Lay makes a coffee cup in the morning routing.\n");
		api.putEmptyPotOnWarmer();				// Coffee lady put pot on warmer.
		api.fillBoilerWithWater();				// coffee lady fill water into boiler
		api.putFilterAndCoffeeGroundIntoFilterHolder();			// put coffee ground onto filter holder
		api.loadFilterHolderIntoReceptacle();				// load filter holder into receptacle
		api.selectCoffeeStrength(1);						// select the coffee strength
		api.pressBrewButton();								// press brew button
		markiv.getUpdate(api);		
		markiv.Brewing(9);									// start brew with interrupt 3/4
		api.liftPotFromWarmer();							// lift pot 
		api.interruptBrewing(9);							// interrupt brewing 3/4
		markiv.stopBrewingCycle();							// stop brewing
		markiv.getUpdate(api);								
		api.pourCoffeeCup();								// pour coffee to a cup													
		Extra ex = new Extra("Whip",3.99);
		api.addExtra(ex);									
		api.printCost();									// print cost
		Thread.sleep(1000);
		print("Coffee Lady rush to work ....... ");
		System.out.println("--------------------");
	
	}
	public static void EveCoffeeWithFriend(CoffeeMakerAPI api,CoffeeMaker markiv) throws InterruptedException {
		print("\n\nB. The coffee lady invited a friend over for coffee.\n");
		api.putEmptyPotOnWarmer();
		api.fillBoilerWithWater();
		api.putFilterAndCoffeeGroundIntoFilterHolder();
		api.loadFilterHolderIntoReceptacle();
		api.selectCoffeeStrength(0);
		api.pressBrewButton();
		markiv.getUpdate(api);
		markiv.Brewing(3);
		api.liftPotFromWarmer();
		api.interruptBrewing(3);
		markiv.stopBrewingCycle();
		markiv.getUpdate(api);
		api.pourCoffeeCup();
		api.returnCoffeePot();
		Extra ex = new Extra("Cinnamon",3.99);
		api.addExtra(ex);
		print("Coffee lady made a cup off coffee for herself");
		api.printCost();
		markiv.getUpdate(api);
		markiv.resumeBrewingCycle();
		markiv.DoneBrewing();
		api.pourCoffeeCup();
		Extra ex1 = new Extra("Mocha",5.0);
		api.addExtra(ex1);
		print("Coffee lady made a cup of coffee for her friend.");
		api.printCost();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException  {
		CoffeeMakerAPI api = new CoffeeMakerAPI();
		
		CoffeeMaker markiv = new CoffeeMaker(api);
		
		print("\n\nExpected deliverable:");
		MorningRoutingCoffee(api,markiv);
		EveCoffeeWithFriend(api,markiv);
		
	}

}
