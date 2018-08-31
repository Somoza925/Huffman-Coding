import java.util.Comparator;
public class TreeWeightComparator implements Comparator <Node>{
	public int compare(Node x, Node y) {
		if (y.weight() > x.weight()) {
			return -1;
		} else {
			return 1;
		}
	}
}
