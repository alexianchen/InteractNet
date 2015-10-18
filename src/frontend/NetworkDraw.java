package frontend;

import backend.NetworkData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

//This takes the data generated in the backend and draws it. It also handles backend data input.
public class NetworkDraw extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	NetworkData db = new NetworkData();
	private Timer timer;
	public NetworkDraw(){
		db = new NetworkData();
		timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				db.RefreshNetwork();
			}
		});
		timer.start();
		
	}
	
	private void draw(Graphics g){
		Graphics2D G2D = (Graphics2D)g;
		G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		G2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//draw points
		G2D.setStroke(new BasicStroke(10));
		G2D.setColor(Color.black);
		for(int i = 0; i < db.point_set.size(); i++){
			G2D.draw(new Line2D.Float(db.point_set.get(i).x, db.point_set.get(i).y, db.point_set.get(i).x, db.point_set.get(i).y));
		}
		
		//draw lines
		G2D.setStroke(new BasicStroke(2));
		for(int i = 0; i < db.line_set.size(); i++){
			G2D.draw(new Line2D.Float(db.line_set.get(i).line_start_x, db.line_set.get(i).line_start_y, db.line_set.get(i).line_end_x, db.line_set.get(i).line_end_y));
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	@Override
	public void actionPerformed(ActionEvent e){
			repaint();
	}
}
