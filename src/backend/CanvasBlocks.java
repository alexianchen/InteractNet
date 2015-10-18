package backend;
import java.util.*;
import backend.Tree;
public class CanvasBlocks {
	private Tree tree;
	public CanvasBlocks(List<Float> float_set){
		tree = new Tree(float_set);
	}
	public int blockcount = 1;
	public void addblock(){
		addblock(tree);
	}
	private void addblock(Tree tree){
		//if both sides of the tree don't exist(leaf)
		if((tree.left == null) && (tree.right == null)){
			tree.left = new Tree(Tree.cloneList(tree.data));
			tree.right = new Tree(Tree.cloneList(tree.data));
			blockcount++;
			tree.right.data.set(0, (float)blockcount);
			if((tree.data.get(3) - tree.data.get(1)) > (tree.data.get(4) - tree.data.get(2))){
				tree.left.data.set(3, (float)0.5 * (tree.data.get(3) + tree.data.get(1)));
				tree.left.data.set(4, tree.data.get(4));
				tree.right.data.set(1, (float)0.5 * (tree.data.get(3) + tree.data.get(1)));
				tree.right.data.set(2, tree.data.get(2));
			}
			else{
				tree.left.data.set(3, tree.data.get(3));
				tree.left.data.set(4, (float)0.5 * (tree.data.get(4) + tree.data.get(2)));
				tree.right.data.set(1, tree.data.get(1));
				tree.right.data.set(2, (float)0.5 * (tree.data.get(4) + tree.data.get(2)));
			}
			List<Float> changedata = new ArrayList<Float>();
			changedata.add(new Float(tree.right.data.get(0) + tree.left.data.get(0)));
			tree.data = Tree.cloneList(changedata);
		}
		else{
			if (tree.right.data.get(0) < tree.left.data.get(0)){
				addblock(tree.right);
			}
			else{
				addblock(tree.left);
			}
			tree.data.set(0, new Float(tree.left.data.get(0) + tree.right.data.get(0)));
		}
	}
	public List<Float> search(int index){
		return search(tree, index);
	}
	private List<Float> search(Tree tree, int index){
		if(tree.left == null & tree.right == null){
			if (tree.data.get(0) == index){
				return tree.data;
			}
			else{
				return null;
			}
		}
		else{
			List<Float> r1 = search(tree.right, index);
			List<Float> r2 = search(tree.left, index);
			if (r1 == null){
				return r2;
			}
			else{
				return r1;
			}
		}
	}
}
