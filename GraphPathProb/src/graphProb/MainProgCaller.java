/**
* This the starting execution point which calls the main function to calculate the maximum probability,path and the most reliable city
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainProgCaller {

	public static void main(String s[]) {
		//default nodes
		String[] nodes = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };
		try {
			//take user input
			Scanner sc = new Scanner(System.in);
			System.out.println("**Enter graph no as 1,2 or 3**");
			int i = sc.nextInt();
			double[] graphProb = null;
			String[][] graphEdges = null;
			String src = null;
			String dest = null;
			switch (i) {
			//Graph1
			case 1:
				graphEdges = new String[][] { { "A", "B" }, { "A", "C" }, { "D", "A" }, { "D", "G" }, { "D", "F" },
						{ "C", "F" }, { "B", "C" }, { "B", "F" }, { "B", "E" }, { "E", "F" }, { "F", "G" },
						{ "G", "H" }, { "F", "H" }, { "E", "H" } };
				graphProb = new double[] { 0.8, 0.7, 0.9, 0.8, 0.6, 0.9, 0.8, 0.6, 0.6, 0.8, 0.7, 0.9, 0.7, 0.6 };
				src = "A";
				dest = "F";
				break;
			//Graph2
			case 2:
				src = "C";
				dest = "A";
				graphProb = new double[] { 0.8, 0.6, 0.9, 0.8, 0.7, 0.9, 0.8, 0.6, 0.8, 0.9 };
				graphEdges = new String[][] { { "A", "B" }, { "B", "C" }, { "A", "D" }, { "D", "E" }, { "B", "E" },
						{ "E", "F" }, { "C", "F" }, { "E", "H" }, { "D", "G" }, { "G", "H" } };
				break;
			//Graph3
			case 3:
				graphEdges = new String[][] { { "A", "B" }, { "A", "E" }, { "A", "D" }, { "D", "H" }, { "B", "F" },
						{ "G", "C" }, { "B", "C" }, { "D", "C" }, { "E", "F" }, { "E", "H" }, { "H", "G" },
						{ "G", "F" } };
				graphProb = new double[] { 0.8, 0.8, 0.9, 0.7, 0.7, 0.6, 0.6, 0.9, 0.6, 0.8, 0.6, 0.9 };
				src = "E";
				dest = "C";
				break;
			default:
				System.out.println("Wrong Input::Please Enter again");
			}

			Map<String, Double> probMap = new HashMap<String, Double>();
			Double maxValueInMap = 0.0;

			CalMaxPathProb sol = new CalMaxPathProb();
			//calculating maximun probability for the given source and destination
			Result result = sol.maxProbability(8, nodes, graphEdges, graphProb, src, dest, true);

			//calculating reliability of each node with every other node
			for (String e : nodes) {
				double totalProb = 0.0;
				for (String k : nodes) {
					Result reliableCityResult = sol.maxProbability(8, nodes, graphEdges, graphProb, e, k, false);
					totalProb = totalProb + reliableCityResult.getMaxProbValue();
				}
              //creating a map of nodes with their total summed probabilities
				probMap.put(e, totalProb);
				//taking max probability value from the map
				maxValueInMap = (Collections.max(probMap.values()));

			}

			for (String key : Utility.getKeys(probMap, maxValueInMap)) {
				System.out.println("Most Reliable City for Part B is:: " + key);
			}

			System.out.println("Maximum Probable Path for Part A:: " + result.getMaxProbPath());
			System.out.println("Maximum Probability Value for Part A:: " + result.getMaxProbValue());
		}

		catch (Exception e) {
			System.out.println("ErrorOccured::Please Enter again with 1,2 or 3::" + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
