package moocastGold;
import java.io.*;
import java.util.*;  
public class moocast {  

    public static class DisjointSets{
        int[] parents;
        int[] sizes; 

        public DisjointSets(int size){
            parents = new int[size];
            sizes = new int[size]; 
            for(int i = 0; i<size; i++){
                parents[i] = i; 
                sizes[i] = 1; 
            }
        }

        public int find(int x){
            return parents[x]==x?x:(parents[x] = find(parents[x]));
        }

        public int distance(int x1, int y1, int x2, int y2){
            int x = (int)Math.pow((x2-x1),2);
            int y = (int)Math.pow((y2-y1),2);
            return x+y;
        }


        public boolean unite(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot == yRoot){
                return false;
            }

            if(sizes[xRoot]<sizes[yRoot]){
                return unite(yRoot,xRoot);
            }

            parents[yRoot] = xRoot;
            sizes[xRoot]+= sizes[yRoot];
            return true; 
        }

        public boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }


    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
    StreamTokenizer in = new StreamTokenizer(br);
    PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));


    in.nextToken();
    int numOfCows = (int)in.nval;
    ArrayList<Integer[]> edges = new ArrayList<>();
    DisjointSets dsu = new DisjointSets(numOfCows);
    int[] xCoor= new int[numOfCows];
    int[] yCoor= new int[numOfCows];

    for(int i = 0; i<numOfCows;i++){
        in.nextToken();
        xCoor[i] = (int)in.nval;
        in.nextToken();
        yCoor[i] = (int)in.nval;
    }

    for(int i = 0; i<numOfCows;i++){
        for(int j= 0; j<i;j++){
            int distance = dsu.distance(xCoor[i], yCoor[i], xCoor[j], yCoor[j]);
            edges.add(new Integer[]{i,j,distance});
        }
    }

    Collections.sort(edges,new Comparator<Integer[]>(){
        @Override
        public int compare(Integer[] A1, Integer[] A2){
            if(A1[2]<A2[2]){
                return -1;
            }
            if(A2[2]<A1[2]){
                return 1;
            }
            return 0;
        }
    });

    //keep building it up till all the verticies are united and have representative
    //return the distance
    int answer = 0;
    int edgesUsed = 0;
    for(Integer[] edge: edges){
        if(edgesUsed == numOfCows-1){
            break;
        }
        if(dsu.unite(edge[0], edge[1])){
            answer = Math.max(answer, edge[2]);
            edgesUsed++;
        }
    }

    pw.println(answer);
        }
}