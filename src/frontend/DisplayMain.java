package frontend;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class DisplayMain extends JFrame{
	private static final long serialVersionUID = 1L;
	final NetworkDraw draw = new NetworkDraw();
	public DisplayMain() {
		initUI();
	}
	
	private void initUI(){
		add(draw);
		setSize(800, 600);
		setTitle("Networks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				DisplayMain ex = new DisplayMain();
				ex.setVisible(true);
				}
			});
	}
}

