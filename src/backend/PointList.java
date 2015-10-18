package backend;
import java.util.*;


public class PointList {
	private CanvasBlocks canvas;
	private List<Point> point_set = new ArrayList<Point>(); 
	private Random rand = new Random();
	public PointList(int point_count, List<Float> dimensions) {
		canvas = new CanvasBlocks(dimensions);
		//canvasblocks starts with one block, add an extra point to accomadate that
		point_set.add(0, new Point(0, 0));
		for(int i = 0; i < point_count; i++){
			canvas.addblock();
			point_set.add(0, new Point(0, 0));
		}
		//sort the blocks
		for(int i = 0; i < canvas.blockcount; i++){
			point_set.remove(i);
			List<Float> iBlock = Tree.cloneList(canvas.search(i + 1));
			float x = rand.nextFloat() * (iBlock.get(3) - iBlock.get(1)) + iBlock.get(1);
			float y = rand.nextFloat() * (iBlock.get(4) - iBlock.get(2)) + iBlock.get(2);
			point_set.add(i, new Point(x, y));
		}
		System.out.println();
	}
	public Point get(int index){
		return point_set.get(index);
	}
	public int size(){
		return canvas.blockcount;
	}
	public void addPoint(){
		//keep in mind that every time you add a canvas block you also have to add a point, then you can redo the points
		canvas.addblock();
		point_set.add(new Point(0, 0));
		for(int i = 0; i < canvas.blockcount; i++){
			//get every leaf and return the data within
			//the block of every leaf is one more than the actual index in the list because its the tree starts as 1
			point_set.remove(i);
			System.out.println(i);
			List<Float> iBlock = Tree.cloneList(canvas.search(i + 1));
			float x = rand.nextFloat() * (iBlock.get(3) - iBlock.get(1)) + iBlock.get(1);
			float y = rand.nextFloat() * (iBlock.get(4) - iBlock.get(2)) + iBlock.get(2);
			point_set.add(i, new Point(x, y));
		}
	}
}
