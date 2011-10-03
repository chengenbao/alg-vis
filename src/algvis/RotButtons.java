package algvis;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JPanel;

public class RotButtons extends Buttons {
	private static final long serialVersionUID = 3851020370059429766L;
	IButton rotB;

	public RotButtons(VisPanel M) {
		super(M);
	}

	@Override
	public void actionButtons(JPanel P) {
		rotB = new IButton(M.a, "rotate");
		rotB.setMnemonic(KeyEvent.VK_R);
		rotB.addActionListener(this);
		P.add(rotB);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		super.actionPerformed(evt);
		if (evt.getSource() == rotB) {
			final Vector<Integer> args = I.getNonEmptyVI();
			Thread t = new Thread(new Runnable() {
				public void run() {
					for (int x : args) {
						((Rotations) D).rotate(x);
					}
				}
			});
			t.start();
		}
	}

	@Override
	public void enableNext() {
		super.enableNext();
		rotB.setEnabled(false);
	}

	@Override
	public void disableNext() {
		super.disableNext();
		rotB.setEnabled(true);
	}
}
