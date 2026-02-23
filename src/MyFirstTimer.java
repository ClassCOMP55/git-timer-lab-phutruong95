import acm.graphics.*;
import acm.program.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;

	private static final int STEP_MS = 1000;        
	private static final int START_DELAY_MS = 3000; //wait 3 seconds
	private static final int STOP_AT = 10;

	private GLabel myLabel;
	private Timer t;
	private int numTimes;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		numTimes = 0;

		myLabel = new GLabel("times called? " + numTimes, 0, 100);
		add(myLabel);

		t = new Timer(STEP_MS, this);

		t.setInitialDelay(START_DELAY_MS);

		t.start();
	}

	public void actionPerformed(ActionEvent e) {
		numTimes++;

		myLabel.move(5, 0);
		myLabel.setLabel("times called? " + numTimes);

		if (numTimes == STOP_AT) {
			t.stop();
		}
	}

	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}