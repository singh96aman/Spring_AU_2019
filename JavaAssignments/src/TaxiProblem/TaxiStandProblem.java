/*********************************************************************
* 	Taxi Stand Multithreading Problem
*	Submission By : Aman Singh Thakur
*	How does it work ?
* 		+ There are 2 threads that run in paralled 'Create Passenger' & 'Create Taxi'
*		+ Create Taxi creates Taxi and adds to TaxiStand if TaxiStand has space for it, otherwise adds it to TaxiQueue
*		+ Create Passenger creates Passenger and -
			-> Checks if a Passenger with same destination is waiting in PassengerQueue
			-> Checks if a Passenger is waiting in PassengerQueue and a new Taxi arrives with no location
			-> Checks if the created Passenger has the same destination as a taxi in Taxi Queue
			-> Checks if the created Passenger has a new Taxi with no lcoation
*/

package TaxiProblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import java.util.concurrent.CopyOnWriteArrayList; 

public class TaxiStandProblem {

		static int MAX_TAXI_IN_STAND = 5;
	 static int MAX_PASSENGER_IN_TAXI = 4;
	 static int MAX_PASSENGER = 50;
	 static int MAX_TAXI = 25;
	 static int MAX_DESTINATION = 10;
	 
	 static CopyOnWriteArrayList<Taxi> TaxiQueue = new CopyOnWriteArrayList<Taxi>(); 
	 static CopyOnWriteArrayList<Passenger> PassengerQueue = new CopyOnWriteArrayList<Passenger>(); 
	
	 
	static class Passenger{
		String name, destination;
		static int count=0;
		Passenger(String name, String destination){
			this.name = name;
			this.destination = destination;
		}
		public static Passenger createRandomPassenger() {
			Random rn = new Random();
			Passenger passenger = new Passenger("Passenger-"+Passenger.count,"Location-"+rn.nextInt(MAX_DESTINATION));
			System.out.println("Creating Passenger "+passenger.name+" with destination "+passenger.destination);
			Passenger.count++;
			return passenger;
		}
	}
	
	static class Taxi{
		String name, destination;
		int passengers, time;
		static int count=0;
		CopyOnWriteArrayList<Passenger> passengerList; 
		Taxi(String name, String destination){
			this.name=name;
			this.destination=destination;
			passengers=0;
			time=0;
			passengerList = new CopyOnWriteArrayList<Passenger>();
		}
		public static Taxi createRandomTaxi() {
			Taxi taxi = new Taxi("Taxi-"+Taxi.count,"TaxiStand");
			System.out.println("Creating Taxi "+taxi.name+" with destination "+taxi.destination);
			Taxi.count++;
			return taxi;
		}
		public String toString() {
			String str = this.name+" has Passenger ";
			Iterator<Passenger> iterator = this.passengerList.iterator();
			while(iterator.hasNext()) {
				str+=iterator.next().name+" ";
			}
			return str;
		}
	}
	
	static class TaxiStand{
		static int occupied=0;
		static CopyOnWriteArrayList<Taxi> listTaxi = new CopyOnWriteArrayList<Taxi>();
		public static boolean addToTaxiIfPossible(Passenger passenger) {
			synchronized (TaxiStand.class) {
				Iterator<Taxi> iterator = TaxiStand.listTaxi.iterator();
				while(iterator.hasNext()) {
					Taxi temp = iterator.next();
					if(temp.destination.equals("TaxiStand") && PassengerQueue.size()!=0) {
						//System.out.println("Case 1");
						Passenger tempPassenger = PassengerQueue.remove(0);
						temp.passengerList.add(tempPassenger);
						temp.passengers++;
						temp.destination=tempPassenger.destination;
						System.out.println(tempPassenger.name+" is added to cab "+temp.name+" to location "+temp.destination);
						if(!addToTaxiIfPossible(passenger)) {
							System.out.println(passenger.name+" is added to the Passenger Queue");
							PassengerQueue.add(passenger);
						}
						return true;
					}else if(PassengerQueue.size()!=0 && temp.destination.equals(PassengerQueue.get(0).destination)) {
						//System.out.println("Case 2");
						Passenger tempPassenger = PassengerQueue.remove(0);
						temp.passengerList.add(tempPassenger);
						temp.passengers++;
						System.out.println(tempPassenger.name+" is added to cab "+temp.name+" to location "+temp.destination);
						if(!addToTaxiIfPossible(passenger)) {
							System.out.println(passenger.name+" is added to the Passenger Queue");
							PassengerQueue.add(passenger);
						}
						return true;
					}
					else if(temp.destination.equals(passenger.destination) && temp.passengers<MAX_PASSENGER_IN_TAXI) {
						//System.out.println("Case 3");
						temp.passengerList.add(passenger);
						temp.passengers++;
						System.out.println(passenger.name+" is added to cab "+temp.name+" to location "+temp.destination);
						return true;
					}else if(temp.destination.equals("TaxiStand") && temp.passengers<MAX_PASSENGER_IN_TAXI) {
						//System.out.println("Case 4");
						temp.passengerList.add(passenger);
						temp.passengers++;
						temp.destination=passenger.destination;
						System.out.println(passenger.name+" is added to cab "+temp.name+" to location "+temp.destination);
						return true;
					}
				}
				return false;
			}
		}
		
		public static void removeCabs() {
			//handle both cases
			synchronized (TaxiStand.class) {
				Iterator<Taxi> iterator = TaxiStand.listTaxi.iterator();
				int i=0;
				while(iterator.hasNext()) {
					Taxi temp = iterator.next();
					if(temp.time==3) {
						System.out.println("Removing Cab "+temp.name+" due to Timeout with "+temp.passengerList.size()+" passengers");
						TaxiStand.listTaxi.remove(i);
					}else if(temp.passengerList.size()==3) {
						System.out.println("Removing Cab "+temp.name+" as the Cab is full "+temp.passengerList.size()+" passengers");
						TaxiStand.listTaxi.remove(i);
					}else
						i++;
				}
			}
		}
		
		public static void addTime() {
			Iterator<Taxi> iterator = TaxiStand.listTaxi.iterator();
			while(iterator.hasNext()) {
				Taxi temp = iterator.next();
				temp.time++;
			}
		}
		
		public static void printState() {
			synchronized (TaxiStand.class) {
				System.out.println("*****************************\n");
				Iterator<Taxi> iterator = TaxiStand.listTaxi.iterator();
				while(iterator.hasNext()) {
					Taxi taxi = iterator.next();
					System.out.println(taxi);
				}
				System.out.println("\n*****************************");
			}
		}
	}
	
	static class CreatePassenger extends Thread{
		public void run() {
			while(Passenger.count<MAX_PASSENGER) {
				synchronized(this) {
					Passenger passenger = Passenger.createRandomPassenger();
					if(TaxiStand.listTaxi.size()==0) {
						System.out.println(passenger.name+" is added to the Passenger Queue");
						PassengerQueue.add(passenger);
					}else {
						if(!TaxiStand.addToTaxiIfPossible(passenger)) {
							System.out.println(passenger.name+" is added to the Passenger Queue");
							PassengerQueue.add(passenger);
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				TaxiStand.printState();
				}
			}
		}
	}
	
	static class CreateTaxi extends Thread{
		public void run() {
			while(Taxi.count<MAX_TAXI) {
				synchronized(this) {
					Taxi taxi = Taxi.createRandomTaxi();
					TaxiStand.removeCabs(); //Both cases handled
					if(TaxiQueue.size()!=0 && TaxiStand.listTaxi.size()<MAX_TAXI_IN_STAND) {
						TaxiStand.listTaxi.add(TaxiQueue.remove(0));
						TaxiQueue.add(taxi);
					}
					else if(TaxiStand.listTaxi.size()<MAX_TAXI_IN_STAND) {
						TaxiStand.listTaxi.add(taxi);
					}else {
						System.out.println(taxi.name+" is added to the Taxi Queue");
						TaxiQueue.add(taxi);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					TaxiStand.addTime();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		CreatePassenger passenger = new CreatePassenger();
		passenger.start();
		CreateTaxi taxi = new CreateTaxi();
		taxi.start();
	}
	
}
