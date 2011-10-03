package algvis;

public class BinHeapIncrKey extends Algorithm {
	int delta;
	BinomialHeap H;
	BinHeapNode v;
	
	public BinHeapIncrKey(BinomialHeap H, BinHeapNode v, int delta) {
		super(H.M);
		this.H = H;
		this.v = v;
		this.delta = delta;
		//setHeader("insertion");
	}
	
	@Override
	public void run() {
		if (H.minHeap) {
			v.key -= delta;
			if (v.key < 1) v.key = 1;
		} else {
			v.key += delta;
			if (v.key > InputField.MAX) v.key = InputField.MAX;
		}
		BinHeapNode w = v.parent;
		while (w != null && v.less(w)) {
			H.v = new BinHeapNode(v);
			H.v2 = new BinHeapNode(w);
			v.key = Node.NOKEY;
			w.key = Node.NOKEY;
			H.v.goTo(w);
			H.v2.goTo(v);
			mysuspend();
			v.key = H.v2.key;
			w.key = H.v.key;
			v.bgcolor = H.v2.bgcolor;
			w.bgcolor = H.v.bgcolor;
			H.v = null;
			H.v2 = null;
			v = w;
			w = w.parent;
		}
		if (v.less(H.min[H.active])) {
			H.min[H.active] = v;
		}
	}
}
