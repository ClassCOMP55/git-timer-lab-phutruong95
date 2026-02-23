import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class BallLauncher extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;

	private static final int MS = 50;
	private static final int SPEED = 2;

	private ArrayList<GOval> balls;
	private Timer t;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		balls = new ArrayList<GOval>();
		addMouseListeners();
		t = new Timer(MS, this);
		t.start();
	}

	public void mousePressed(MouseEvent e) {
		for (GOval b : balls) {
			if (b.getX() < 100) {
				return;
			}
		}
		GOval ball = makeBall(SIZE / 2.0, e.getY());
		add(ball);
	}

	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x - SIZE / 2.0, y - SIZE / 2.0, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		balls.add(temp);
		return temp;
	}

	public void actionPerformed(ActionEvent e) {
		for (GOval b : balls) {
			b.move(SPEED, 0);
		}
	}

	public static void main(String[] args) {
		new BallLauncher().start();
	}
}