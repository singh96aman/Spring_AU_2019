package TaxiProblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Random;


public class TaxiProblem {
	
	 static int MAX_TAXI_IN_STAND = 2;
	 static int MAX_PASSENGER_IN_TAXI = 2;
	 static int MAX_PASSENGER = 25;
	 static int MAX_TAXI = 10;
	 static int MAX_DESTINATION = 5;
	
	 static Queue<Taxi> TaxiQueue = new LinkedList<>(); 
	 static Queue<Passenger> PassengerQueue = new LinkedList<>();
	 static TaxiStand taxiStand = new TaxiStand();
	 
	static class Passenger{
		String name, destination;
		Passenger(String name, String destination){
			this.name = name;
			this.destination = destination;
		}
	}
	
	static class Taxi{
		String name, destination;
		int passengers;
		ArrayList<Passenger> passengerList;
		Taxi(String name, String destination){
			this.name=name;
			this.destination=destination;
			passengers=0;
			passengerList = new ArrayList<Passenger>(MAX_PASSENGER_IN_TAXI);
		}
	}
	
	static class CreatePassenger extends Thread{
		
		static int counter=0, MAX_PASSENGER;
		
		CreatePassenger(int n){
			MAX_PASSENGER=n;
		}
		
		static Random rn = new Random();
		public void run() {
			while(counter<MAX_PASSENGER) 
			{
				Passenger passenger = new Passenger("Passenger-"+counter,"Location-"+rn.nextInt(MAX_DESTINATION));
				System.out.println("Creating Passenger "+passenger.name+" with destination "+passenger.destination);
				if(taxiStand.listTaxi.size()==0) 
				{
					//Wait Maybe
				}else 
				{
					Iterator<Taxi> iterator = taxiStand.listTaxi.iterator();
					boolean flag=false;
					while(iterator.hasNext()) 
					{
						Taxi taxi = iterator.next();
						while(taxi!=null && PassengerQueue.peek()!=null && taxi.destination.equals(PassengerQueue.poll().destination) && taxi.passengers<MAX_PASSENGER_IN_TAXI) {
							taxi.passengerList.add(PassengerQueue.poll());
							taxi.passengers++;
							System.out.println("***"+taxi.name+" with destination "+taxi.destination+" is full and is leaving***");
						}
						
						if(taxi!=null && taxi.destination.equals(passenger.destination) && taxi.passengers<MAX_PASSENGER_IN_TAXI) 
						{
							taxi.passengerList.add(passenger);
							System.out.println("Passenger "+passenger.name+" is travelling in Taxi "+taxi.name+" to destination "+taxi.destination);
							taxi.passengers++;
							if(taxi.passengers==MAX_PASSENGER_IN_TAXI) {
								System.out.println("***"+taxi.name+" with destination "+taxi.destination+" is full and is leaving***");
								taxiStand.listTaxi.remove(taxi);
								taxiStand.occupied--;
								taxiStand.listTaxi.add(TaxiQueue.poll());
								taxiStand.occupied++;
								Iterator<Taxi> t = taxiStand.listTaxi.iterator();
//								while(t.hasNext()) {
//									Taxi temp = t.next();
//									System.out.print(temp.name+" ");
//								}
								System.out.println();
							}
							flag=true;
							break;
						}else if(taxi!=null && taxi.destination.equals("TaxiStand")) 
						{
							taxi.destination=passenger.destination;
							taxi.passengerList.add(passenger);
							System.out.println("Passenger "+passenger.name+" is travelling in Taxi "+taxi.name+" to destination "+taxi.destination);
							taxi.passengers++;
							flag=true;
							break;
						}
					}
					if(!flag) {
						PassengerQueue.add(passenger);
						System.out.println(passenger.name+" is added to the Passenger Queue");
					}
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter++;	
		}
	}
	}
	
	static class CreateTaxi extends Thread{
		
		static int counter=0, MAX_TAXI;
		
		public CreateTaxi(int n) {
			MAX_TAXI=n;
		}
		
		public void run() {
			
			while(counter<MAX_TAXI) {
				Taxi taxi = new Taxi("Taxi-"+counter,"TaxiStand");
				System.out.println("Creating Taxi "+taxi.name+" with destination "+taxi.destination);
				if(taxiStand.occupied<MAX_TAXI_IN_STAND) {
					taxiStand.listTaxi.add(taxi);
					taxiStand.occupied++;
					if(taxiStand.occupied==MAX_TAXI_IN_STAND)
						System.out.println("Taxi Stand is Full");
				}else {
					TaxiQueue.add(taxi);
					System.out.println(taxi.name+" is added the queue");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter++;
			}
		}
	}
	
	static class TaxiStand{
		int occupied=0;
		ArrayList<Taxi> listTaxi = new ArrayList<Taxi>(MAX_TAXI_IN_STAND);
	}
	
	public static void main(String[] args) {
			CreateTaxi t = new CreateTaxi(MAX_TAXI);
			t.start();
			CreatePassenger p = new CreatePassenger(MAX_PASSENGER);
			p.start();
	}
}
