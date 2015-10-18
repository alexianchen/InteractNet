package backend;
//the encapulation of a point

import java.util.Random;

public class Point {
	private Random rand = new Random();
	final float max_x = 800.0f;
	final float min_x = 0.0f;
	final float max_y = 575.0f;
	//seems to only show this many in, so can't really do anything about it.
	final float min_y = 0.0f;
	public float x = 0;
	public float y = 0;
	public Point(float x_int, float y_int){
		x = x_int;
		y = y_int;
	}
	public Point(){
		x = rand.nextFloat() * (max_x - min_x) + min_x;
		y = rand.nextFloat() * (max_y - min_y) + min_y;
	}
}