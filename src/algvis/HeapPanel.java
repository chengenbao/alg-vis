package algvis;

public class HeapPanel extends VisPanel {
	private static final long serialVersionUID = -2488725769022251713L;

	public HeapPanel(AlgVis a) {
		super(a);
	}

	@Override
	public String getTitle() {
		return "heap";
	}

	@Override
	public void initDS() {
		D = new Heap(this);
		B = new PQButtons(this);
	}
}
