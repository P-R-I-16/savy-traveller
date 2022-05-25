/**
* This is a pojo class to store current path being traversed information
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;

import java.util.ArrayList;
/**
*Pojo class
*/
class Path {
	
	private double currentProb;
	private String currentNode;
	private String sourceNode;
	private String destNode;
	private ArrayList outputPath;
	public ArrayList getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(ArrayList outputPath) {
		this.outputPath = outputPath;
	}

	public String getDestNode() {
		return destNode;
	}

	public void setDestNode(String destNode) {
		this.destNode = destNode;
	}

	public String getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(String sourceNode) {
		this.sourceNode = sourceNode;
	}

	public double getCurrentProb() {
		return currentProb;
	}

	public void setCurrentProb(double currentProb) {
		this.currentProb = currentProb;
	}

	public String getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}



	public Path(double _currentProb, String _currentNode, String _src,ArrayList outputPath) {
		this.currentProb = _currentProb;
		this.currentNode = _currentNode;
		this.sourceNode = _src;
		this.outputPath=outputPath;
	}
}
