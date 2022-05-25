/**
* This is a pojo class to store result from the maxprobability function
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;
/**
*Pojo class to store the result from main function
*/
public class Result {

	private String maxProbPath;
	private double maxProbValue=0.0;
	public String getMaxProbPath() {
		return maxProbPath;
	}
	public void setMaxProbPath(String maxProbPath) {
		this.maxProbPath = maxProbPath;
	}
	public double getMaxProbValue() {
		return maxProbValue;
	}
	public void setMaxProbValue(double maxProbValue) {
		this.maxProbValue = maxProbValue;
	}
}
