/**
* helper class
*
* @author  CSUF Tech Travellers
* @version 1.0
* @since   2022-03-02 
*/
package graphProb;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
*Utility class
*/
public class Utility {

	public static Set<String> getKeys(Map<String, Double> map, Double value) {

		Set<String> result = new HashSet<>();
		if (map.containsValue(value)) {
			for (Map.Entry<String, Double> entry : map.entrySet()) {
				if (Objects.equals(entry.getValue(), value)) {
					result.add(entry.getKey());
				}

			}
		}
		return result;

	}
}
