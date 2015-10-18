package backend;
import java.util.*;

public class Tree{
    public List<Float> data = new ArrayList<Float>();
   	public Tree left;
   	public Tree right;
   	public Tree(List<Float> inputdata) {
   		left = null;
		right = null;
		data = cloneList(inputdata);
    }
    public static List<Float> cloneList(List<Float> list) {
    	List<Float> clone = new ArrayList<Float>(list.size());
    	for(Float item: list) clone.add(new Float(item.floatValue()));
    	return clone;
    }
}
