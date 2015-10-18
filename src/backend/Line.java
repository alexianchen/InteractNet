package backend;
import backend.Point;
//TODO: Rewrite this completely, use trig and return functions
import java.util.Random;
public class Line {
	Random rand;
	public float line_start_x = 0.0f;
	public float line_start_y = 0.0f;
	public float line_end_x = 0.0f;
	public float line_end_y = 0.0f;
	public float x_speed = 0.0f;
	public float y_speed = 0.0f;
	public Point end;
	final float move_speed_max = 150.0f;
	final float move_speed_min = 100.0f;
	float move_speed = 0.0f;
	float tail_length = 10.0f;
	public Line(Point start, Point end){
		rand = new Random();
		calculate_speed(start, end);
	}
	private void calculate_speed(Point a, Point b){
		line_start_x = a.x;
		line_start_y = a.y;
		end = new Point(b.x, b.y);
		move_speed = (float)((rand.nextFloat() * (move_speed_max - move_speed_min)) + move_speed_min);		
		x_speed = (b.x - a.x) / move_speed;
		y_speed = (b.y - a.y) / move_speed;
		line_end_x = line_start_x;
		line_end_y = line_start_y;
	}
	public boolean refresh_line(){
		boolean retbool = false;
		if((((x_speed > 0) && (line_end_x <= (line_start_x + (tail_length * x_speed)))) || ((x_speed < 0) && (line_end_x >= (line_start_x + (tail_length * x_speed))))) || (((y_speed > 0) && (line_end_y <= (line_start_y + (tail_length * y_speed)))) || ((y_speed < 0) && (line_end_y >= (line_start_y + (tail_length * y_speed)))))){
				//above code finds a line with a beginning until 
				line_end_x += x_speed;
				line_end_y += y_speed;
				retbool = true;
		}
		else{
			//after the line reaches its full length
			line_end_x += x_speed;
			line_end_y += y_speed;
			//this basically says that before the end of the line reaches the point, continue
			if((((x_speed > 0) && (line_end_x <= end.x)) || ((x_speed < 0) && (line_end_x >= end.x))) || (((y_speed > 0) && (line_end_y <= end.y)) || ((y_speed < 0) && (line_end_y >= end.y)))){
					line_start_x += x_speed;
					line_start_y += y_speed;
					retbool = true;
			}else if((((x_speed > 0) && (line_start_x <= end.x)) || ((x_speed < 0) && (line_start_x >= end.x))) || (((y_speed > 0) && (line_start_y <= end.y)) || ((y_speed < 0) && (line_start_y >= end.y)))){
					retbool = false;
			}else{
				//continue if the end is met but the beginning is not, until falls into the former case.
				retbool = true;
			}
		}
	return(retbool);
	}
}
