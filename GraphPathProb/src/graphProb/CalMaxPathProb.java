/**
* This is the main class to calculate the maximum probability,path and the most reliable city
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CalMaxPathProb {

	@SuppressWarnings("unchecked")
	public Result maxProbability(int n, String nodes[], String[][] edges, double[] succProb, String start, String end,
			boolean returnProbablePath) {
		Result output = new Result();
		//create adjMap to keep track of nodes reachable from each other with their probabilities
		Map<String, List<LinkedNodes>> adjMap = new HashMap<String, List<LinkedNodes>>();
		for (int i = 0; i < nodes.length; i++)
			adjMap.put(nodes[i], new ArrayList<LinkedNodes>());
		int idx = 0;
		for (String[] edge : edges) {
			adjMap.get(edge[0]).add(new LinkedNodes(edge[0], edge[1], succProb[idx]));
			adjMap.get(edge[1]).add(new LinkedNodes(edge[1], edge[0], succProb[idx]));
			idx++;
		}

		//Using priority Queue with a comparator to compare the elements of the queue and assign the element with the highest probability a higher priority
		PriorityQueue<Path> pQueue = new PriorityQueue<Path>(
				(a, b) -> Double.compare(b.getCurrentProb(), a.getCurrentProb()));
		//adding start node to pQueue
		pQueue.offer(new Path(1.0, start, start, null));

		//creating visited set to keep track of an already visited node
		Set<String> visited = new LinkedHashSet<String>();

		while (!pQueue.isEmpty()) {
			int size = pQueue.size();

			while (size-- > 0) {
				Path currentPath = pQueue.poll(); //retrieving head of the queue
				String node = currentPath.getCurrentNode();

				//if destination node is found
				if (node.equals(end)) {
					if (returnProbablePath) {
						//adding destination node to the captured path
						currentPath.getOutputPath().add(end);
						Set<String> finalPath = new LinkedHashSet<String>(currentPath.getOutputPath());
						//setting most probable path
						output.setMaxProbPath(finalPath.toString());
					}
					//setting maximum probability value
					output.setMaxProbValue(currentPath.getCurrentProb());
					return output;
				}
				if (visited.contains(node)) {
					continue;
				}
				//if not visited add to the set
				visited.add(node);

				//get the list of adjacent nodes for each node
				for (LinkedNodes LinkedNodes : adjMap.get(node)) {
					ArrayList<String> prevNodes = new ArrayList<String>();
					
					//code below to keep track of the predecessor nodes in order to return the most probable path
					if (returnProbablePath) {
						if (currentPath.getOutputPath() == null || currentPath.getOutputPath().size() == 0) {
							//creating new path
							prevNodes.add(LinkedNodes.getSource());
						} else {
							//adding to existing path
							prevNodes = currentPath.getOutputPath();
							prevNodes.add(LinkedNodes.getSource());
						}
					}
                    //computing the product of the probability of the current node being processed with the linked nodes probabilities and adding to the priority queue
					pQueue.offer(new Path(currentPath.getCurrentProb() * LinkedNodes.getProb(), LinkedNodes.getDest(),
							LinkedNodes.getSource(), prevNodes));

				}

			}
		}

		return output;
	}

}
