/**
* This is a pojo class to store linked nodes information
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;
/**
*Pojo class to store linked nodes info
*/
class LinkedNodes {
	private  String source;
	private String dest;
	public  String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

	private double prob;

	public LinkedNodes(String _src, String _dest, double _prob) {
		this.source = _src;
		this.dest = _dest;
		this.prob = _prob;
	}
}
