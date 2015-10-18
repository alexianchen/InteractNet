package backend;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
//this is the backend. It's main purpose is to handle point data and line data, and perform intilization and calculations.
public class NetworkData {
	final float max_x = 800.0f;
	final float min_x = 10.0f;
	final float max_y = 600.0f;
	final float min_y = 0.0f;
	
	private List<Float> pointrange = new ArrayList<Float>();
	public List<Line> line_set = new ArrayList<Line>();	
	public PointList point_set;
	Random rand;
	
	public NetworkData(){
		pointrange.add((float)1.0);
		pointrange.add(min_x);
		pointrange.add(min_y);		
		pointrange.add(max_x);		
		pointrange.add(max_y);
		point_set = new PointList(30, pointrange);
		
		rand = new Random();
		for(int i = 0; i < (point_set.size() - 1); i += 3){
			//create lines for Points
			line_set.add(new backend.Line(point_set.get(i), point_set.get(i + 1)));
		}
		
	}
	public void RefreshNetwork(){
		//refresh lines
		for(int i = 0; i < line_set.size(); i++){
			//should not refresh?
			if(!(line_set.get(i)).refresh_line()){
				line_set.add(new backend.Line(line_set.get(i).end, point_set.get(rand.nextInt(point_set.size()))));
				line_set.remove(i);
				i--;
			}
		}
	}
}
