import java.io.*;
import java.util.*;

/** A data structure that can answer point update & range min queries. */
public class MinSegmentTree {
	public final int len;
	private final int[] segtree;  // index 0 is not in use

	private int combine(int a, int b) { return Math.min(a, b); }

	private void build(int[] arr, int at, int atLeft, int atRight) {
		if (atLeft == atRight) {
			segtree[at] = arr[atLeft];
			return;
		}
		int mid = (atLeft + atRight) / 2;
		build(arr, 2 * at, atLeft, mid);
		build(arr, 2 * at + 1, mid + 1, atRight);
		segtree[at] = combine(segtree[2 * at], segtree[2 * at + 1]);
	}

	public void update(int node, int left, int right, int x, int y, int value) {
		if (x <= left && right <= y) {
			segtree[node] += value;
		} 
		else{
			int middle = (left + right) / 2;
			if (x <= middle) {
				update(2 * node + 1, left, middle, x, y, value);
			}
			if (y >= middle + 1) {
				update(2 * node + 2, middle + 1, right, x, y, value);
			}
			segtree[node] = segtree[2 * node + 1] + segtree[2 * node + 2];
		}
	}

	public String toString(){
		return "Array: "+ Arrays.toString(segtree); 
	}
	public int kValue(int index){
		return segtree[index];


	}

	/** Sets the value at ind to val. */
	void set(int a, int b, int u) { update(1, 0, len, a, b, u); }

	

	public MinSegmentTree(int len) {
		this.len = len;
		segtree = new int[len * 4];
		Arrays.fill(segtree, Integer.MAX_VALUE);
	}

	public MinSegmentTree(int[] arr) {
		this.len = arr.length;
		segtree = new int[len * 4];
		build(arr, 1, 0, len - 1);
	}
}