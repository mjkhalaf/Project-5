package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StationsHD {
	
	/**
	 * the list of stations are stored in this list
	 */
	private ArrayList<String> stationsList;
	/**
	 * list of stations with equal distance
	 */
	private ArrayList<String> equalHD;
	
	/**
	 * default constructor that invokes the method read()
	 * @throws IOException
	 */
	public StationsHD() throws IOException {
		read();
		
	}
	
	/**
	 * a method to read the stations from the Mesonet file and stores the stations in the ArrayList
	 * stationsList
	 * @throws IOException
	 */
	public void read() throws IOException {
		
		//intialize the array list 
		stationsList = new ArrayList<>();
		
		File file = new File("C:\\Users\\m7md2\\Desktop\\Java 2 Porjects\\Project55\\src\\Mesonet.txt");
		BufferedReader bw = new BufferedReader(new FileReader(file));
		
		String curr = bw.readLine();
		
		while (curr != null ) {
			curr = curr.substring(0,4);
			stationsList.add(curr);
			curr = bw.readLine();
		}
		bw.close();
	}
	
	/**
	 * calcualte the hamming distance between two stations
	 * @param stationID1
	 * @param stationID2
	 * @return hamming distance between two stations
	 */
	public int calcHD(String stationID1, String stationID2) {
		
		int hmDist = 0;
		
		for (int i = 0; i < 4; ++i) {
			
			if (stationID1.charAt(i) == stationID2.charAt(i) ) {
				hmDist += 0;
				
			}
			else {
				hmDist += 1;
			}
		}
		
		return hmDist;
		
	}
	/**
	 * finds the stations that has the same given hamming distance from a given station
	 * @param Station id
	 * @param dist (hamming distance)
	 * @return arraylist of the stations with the same given hamming distance
	 */
	public ArrayList<String> equalHamDist(String id, int dist) {
		
		equalHD = new ArrayList<>();
		
		for(int i = 0; i < stationsList.size(); i++) {
			
			if (calcHD(stationsList.get(i), id) == dist) {
				equalHD.add(stationsList.get(i));
			}
		}
		return equalHD;
	}
	/**
	 * finds out how many stations have the same given hamming dstance from a certain station
	 * @param  station id
	 * @param dist (hamming distnace)
	 * @return the number of stations
	 */
	public int countHamDist(String id, int dist) {
		
		int count = 0;
		
		for(int i = 0; i < stationsList.size(); i++) {
			
			if (calcHD(stationsList.get(i), id) == dist) {
				count++;
			}
		}
		return count;
	}
	/**
	 * finds the index of a certain staiton in the list of stations
	 * @param StationID
	 * @return index of station
	 */
	public int stationIndex(String StationID) {
		int index = 0;
		
		for (int i = 0; i < stationsList.size(); ++i) {
			
			if (StationID.equals(stationsList.get(i))) {
				index = i + 1;
				break;
			}
		}
		return index;
	}
	/**
	 * calculates the asceii average of a station
	 * @param StationID
	 * @return floor, ceiling and average of a station Asceii
	 */
	public int[] Avg(String StationID) {
		
		double sumA = 0;
		int ceiling = 0;
		int floor = 0;
		int avg = 0;
		for (int i = 0; i < StationID.length(); ++i) {
			sumA += StationID.charAt(i);
		}
		sumA = sumA / 4;
		floor = (int) sumA;
		ceiling = floor + 1;
		if(sumA - floor < 0.5) {
			avg = floor;
		}
		else {
			avg = ceiling;
		}
		int[] result = {floor,ceiling,avg};
		
		return result;
	}
	/**
	 * 
	 * @return the list of all the staitons
	 */
	public ArrayList<String> getStationsList() {
		return stationsList;
	}
	
}
