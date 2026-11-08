package mooTubeGold;
import java.util.*;  
import java.io.*;
import java.lang.reflect.Array;  


public class mootube {  

class DisjointSets {
	int[] parents;  // 0-indexed
	int[] sizes;

	public DisjointSets(int size) {
		parents = new int[size];
		sizes = new int[size];
		for (int i = 0; i < size; i++) {
			parents[i] = i;
			sizes[i] = 1;
		}
	}

	/** @return the "representative" node in x's component */
	public int find(int x) {
		return parents[x] == x ? x : (parents[x] = find(parents[x]));
	}

	/** @return whether the merge changed connectivity */
	public boolean unite(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) { return false; }

		if (sizes[xRoot] < sizes[yRoot]) { return unite(yRoot, xRoot); }
		parents[yRoot] = xRoot;
		sizes[xRoot] += sizes[yRoot];
		return true;
	}

	/** @return whether x and y are in the same connected component */
	public boolean connected(int x, int y) { return find(x) == find(y); }
}    

    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());       
                

    HashMap<Integer,ArrayList<Integer[]>> routes = new HashMap<>();
    int numOfVideos = Integer.parseInt(st.nextToken());
    int numOfQuestions = Integer.parseInt(st.nextToken());
    ArrayList<Integer> graph = new ArrayList<>();
    for(int i = 0; i < (numOfVideos-1)*3; i++){
		int x = Integer.parseInt(st.nextToken());
		if (!routes.containsKey(x)) {
			routes.put(x,new ArrayList<Integer[]>());
		}
		
		routes.get(x).add(new Integer[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});



	}
DisjointSets dsu = new DisjointSets(numOfVideos);
		for (int i = 0; i < numOfQuestions; i++) {
			int type = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			if (type == 0) {
				dsu.unite(u, v);
				routes.put()
			} else {
				if (dsu.connected(u, v)) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}

			if()

        }  
}  