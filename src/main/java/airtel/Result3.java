package airtel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Common;
import java.io.*;
import java.util.*;

class Result3 {
	static void print(Object... x) {
		for (Object y : x)
			if (y instanceof long[][]) {
				System.out.println();
				for (long[] z : (long[][]) y) {
					System.out.println(Arrays.toString(z));
				}
			} else if (y instanceof long[]) {
				System.out.print(Arrays.toString((long[]) y) + ",");
			} else if (y instanceof int[][]) {
				System.out.println();
				for (int[] z : (int[][]) y) {
					System.out.println(Arrays.toString(z));
				}
			} else if (y instanceof int[]) {
				System.out.print(Arrays.toString((int[]) y) + ",");
			} else {
				System.out.print(y + ",");
			}
		System.out.println();
	}

	int n, m, q;
	int[][] ee;

	int[][] qq;

	int neighbors[][];
	int neighborDist[][];
	int cycleID[];
	int cycleDist[];
	int cycleLen[];
	int parent[];
	int parentDist[];
	int depth[];
	int ddepth[];
	int size[];
	int bfs[];
	int rbfs[];

	int[] hchild;
	int[] hparent;
	public int[][] hpaths;
	public int[] hpathID;
	public int[] hpathLoc;

	public Result3(int n, int m, int q, int[][] ee, int[][] qq) {
		this.n = n;
		this.m = m;
		this.q = q;
		this.ee = ee;
		for (int[] e : ee) {
			e[0]--;
			e[1]--;
		}
		this.qq = qq;
		for (int[] e : qq) {
			e[0]--;
			e[1]--;
		}
	}

	void solve() {
		getNeighbors();
		getCycles();
		getHeavy();
		for (int[] z : qq)
			System.out.println(getDist(z[0], z[1]));
		// print(parent);
		// print(parentDist);
		// print(ddepth);
		// print(cycleDist);
		// print(cycleID);
	}

	int getDist(int a, int b) {
		int c = getLCA(a, b);
		if (c == a)
			return ddepth[b] - ddepth[a];
		if (c == b)
			return ddepth[a] - ddepth[b];

		if (cycleID[c] < 0) {
			return ddepth[a] + ddepth[b] - ddepth[c] * 2;
		}
		int ca = c;
		int aa = getParent(a, depth[a] - depth[c] - 1);
		if (cycleID[aa] == cycleID[c])
			ca = aa;
		int cb = c;
		int bb = getParent(b, depth[b] - depth[c] - 1);
		if (cycleID[bb] == cycleID[c])
			cb = bb;
		return ddepth[a] + ddepth[b] - ddepth[ca] - ddepth[cb] + cdist(ca, cb);
	}

	private void getNeighbors() {
		int[] degree = new int[n];
		for (int[] e : ee) {
			degree[e[0]]++;
			degree[e[1]]++;
		}
		neighbors = new int[n][];
		neighborDist = new int[n][];
		for (int i = 0; i < n; ++i) {
			neighbors[i] = new int[degree[i]];
			neighborDist[i] = new int[degree[i]];
		}
		for (int[] e : ee) {
			int a = e[0], b = e[1];
			int da = --degree[a];
			int db = --degree[b];
			neighbors[a][da] = b;
			neighbors[b][db] = a;
			neighborDist[a][da] = e[2];
			neighborDist[b][db] = e[2];
		}

	}

	private void getCycles() {
		cycleID = new int[n];
		cycleDist = new int[n];
		cycleLen = new int[n];
		Arrays.fill(cycleID, -1);
		int cnum = 0;
		parent = new int[n];
		parentDist = new int[n];
		depth = new int[n];
		bfs = new int[n];
		int back = 0;
		int front = 0;
		bfs[front++] = 0;
		Arrays.fill(parent, -1);
		int k = 0;
		int[] parent0 = new int[n];
		Arrays.fill(parent0, -1);

		while (back < n) {
			k = bfs[back++];
			for (int i = 0; i < neighbors[k].length; ++i) {
				int c = neighbors[k][i];
				int d = neighborDist[k][i];
				if (c == parent0[k])
					continue;
				if (parent[c] != -1) {
					if (cycleID[k] == -1)
						labelCycle(k, c, d, cnum++);
					continue;
				}
				parent[c] = k;
				parent0[c] = k;
				parentDist[c] = d;
				bfs[front++] = c;
				depth[c] = depth[k] + 1;
			}
		}
		rbfs = new int[n];
		for (int i = 0; i < n; ++i)
			rbfs[i] = bfs[n - i - 1];

		ddepth = new int[n];
		for (int i : bfs) {
			int p = parent[i];
			if (p < 0)
				continue;
			depth[i] = depth[p] + 1;
			ddepth[i] = ddepth[p] + parentDist[i];
		}

	}

	private void getHeavy() {
		size = new int[n];
		hchild = new int[n];
		hparent = new int[n];
		int numLeaves = 0;
		Arrays.fill(hchild, -1);
		Arrays.fill(size, 1);
		Arrays.fill(hparent, -1);
		for (int i : rbfs) {
			if (hchild[i] >= 0)
				hparent[hchild[i]] = i;
			else
				numLeaves++;
			int p = parent[i];
			if (p < 0)
				continue;
			size[p] += size[i];
			if (hchild[p] < 0 || size[hchild[p]] < size[i])
				hchild[p] = i;
		}
		hpaths = new int[numLeaves][];
		hpathID = new int[n];
		hpathLoc = new int[n];
		int k = 0;
		for (int i = 0; i < n; ++i) {
			if (hchild[i] != -1)
				continue;
			List<Integer> path = new ArrayList<>();
			for (int c = i; c != -1; c = hparent[c]) {
				hpathID[c] = k;
				hpathLoc[c] = path.size();
				path.add(c);
			}
			hpaths[k++] = getArray(path);
		}

	}

	public int getParent(int v, int dist) {
		while (dist > 0) {
			if (hparent[v] == -1) {
				v = parent[v];
				dist--;
			} else {
				int[] path = hpaths[hpathID[v]];
				dist += hpathLoc[v];
				int z = Math.min(path.length - 1, dist);
				v = path[z];
				dist -= z;
			}
		}
		return v;
	}

	public int getLCA(int a, int b) {
		if (depth[a] > depth[b])
			a = getParent(a, depth[a] - depth[b]);
		if (depth[b] > depth[a])
			b = getParent(b, depth[b] - depth[a]);
		while (a != b) {
			if (hparent[a] == -1 || hparent[b] == -1) {
				a = parent[a];
				b = parent[b];
				continue;
			}
			int a0 = getPathRoot(a);
			int b0 = getPathRoot(b);

			if (depth[b0] == depth[a0]) {
				a = a0;
				b = b0;
			} else if (depth[b0] > depth[a0]) {
				a = getParent(a, depth[a] - depth[b0]);
				b = b0;
			} else {
				b = getParent(b, depth[b] - depth[a0]);
				a = a0;
			}
		}
		return a;
	}

	public int getPathRoot(int a) {
		int[] path = hpaths[hpathID[a]];
		return path[path.length - 1];
	}

	static int[] getArray(List<Integer> path) {
		int[] ret = new int[path.size()];
		int i = 0;
		for (int c : path)
			ret[i++] = c;
		return ret;
	}

	int cdist(int a, int b) {
		int len = cycleLen[cycleID[a]];
		int x = cycleDist[a] - cycleDist[b];
		if (x < 0)
			x += len;
		return Math.min(x, len - x);
	}

	private void labelCycle(int k, int c, int d, int cnum) {
		final int k0 = k, c0 = c;
		int klen = 0;
		int clen = 0;
		if (depth[c] > depth[k]) {
			clen += parentDist[c];
			c = parent[c];
		}
		while (c != k) {
			clen += parentDist[c];
			c = parent[c];
			klen += parentDist[k];
			k = parent[k];
		}
		int len = clen + klen + d;
		int root = k;
		cycleLen[cnum] = len;
		cycleID[root] = cnum;
		cycleDist[root] = 0;
		c = c0;
		int len0 = clen;
		while (c != root) {
			cycleID[c] = cnum;
			cycleDist[c] = len0;
			len0 -= parentDist[c];
			c = parent[c];
		}
		c = k0;
		len0 = clen + d;
		while (c != root) {
			cycleID[c] = cnum;
			cycleDist[c] = len0;
			len0 += parentDist[c];
			c = parent[c];
		}

		c = c0;
		while (c != root) {
			int cp = parent[c];
			parent[c] = root;
			parentDist[c] = cdist(c, root);
			c = cp;
		}
		c = k0;
		while (c != root) {
			int cp = parent[c];
			parent[c] = root;
			parentDist[c] = cdist(c, root);
			c = cp;
		}

	}

	static int[] getInts(BufferedReader br) throws IOException {
		String[] ss = new String[0];
		while (ss.length == 0 || "".equals(ss[0]))
			ss = br.readLine().split(" ");
		int[] ret = new int[ss.length];
		for (int i = 0; i < ss.length; ++i) {
			ret[i] = Integer.parseInt(ss[i]);
		}
		return ret;
	}

	static void goFile(String s) throws Exception {
		go(new FileReader(new File(s)));
	}

	static void go() throws Exception {
		go(new InputStreamReader(System.in));
	}

	static void go(Reader r) throws Exception {
		BufferedReader br = new BufferedReader(r);
		int[] nm = getInts(br);
		int n = nm[0], m = nm[1];
		int[][] ee = new int[m][];
		for (int i = 0; i < m; ++i)
			ee[i] = getInts(br);
		int q = getInts(br)[0];
		int[][] qq = new int[q][];
		for (int i = 0; i < q; ++i)
			qq[i] = getInts(br);
		Result3 ctp = new Result3(n, m, q, ee, qq);
		ctp.solve();
	}

	public static void main(String[] args) throws Exception {
		// goFile("input/temp.txt");
		go();
	}
}