import java.util.Comparator;

public class RealCompare implements Comparator<HuffmanNode>{
//let it from min to max
	public RealCompare() {
		// TODO Auto-generated constructor stub
	}

	
	public int compare(HuffmanNode a,HuffmanNode b) {
		return a.data - b.data;
	}
}
