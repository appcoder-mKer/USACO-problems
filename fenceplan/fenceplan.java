package fenceplan;
import java.util.*;  
import java.io.*;  
public class fenceplan {  

    private static class network{
        HashMap<Integer, Node> cowNetwork = new HashMap<>();

        public void addNode(Integer cow, Node neighbors){
            cowNetwork.put(cow,neighbors);
        }

        public long BFS(){
            Queue<Node> queue = new LinkedList<>();
            Set<Node> visited = new HashSet<>();
            long minX = Long.MAX_VALUE;
            long maxX = 0;
            long minY = Long.MAX_VALUE;
            long maxY = 0;
            long answer = 0; 
            long answerMin = Long.MAX_VALUE; 
            
            for(int i = 1; i<=cowNetwork.size();i++){
                if (visited.contains(cowNetwork.get(i))){
                    continue;
                }
                queue.add(cowNetwork.get(i));
                visited.add(cowNetwork.get(i));
                // System.out.println(i);

                while (!queue.isEmpty()) {
                    Node currentNode = queue.poll();
                    for(Node neighbor : currentNode.neighbors){
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                    maxX = Math.max(currentNode.x, maxX);
                    maxY = Math.max(currentNode.y, maxY);
                    minX = Math.min(currentNode.x, minX);
                    minY = Math.min(currentNode.y, minY);
                    
                }
            
                Long temp1 = maxX-minX;
                    Long temp2 = maxY-minY;
                answer = (2*temp1)+(2*temp2);
                // System.out.println("maxX:"+maxX);
                // System.out.println("minX:"+minX);
                // System.out.println("maxY:"+maxY);
                // System.out.println("minY:"+minY);
                // System.out.println(answer);


                if (answer<answerMin) {
                    answerMin = answer;
                }
                minX = Long.MAX_VALUE;
                    maxX = 0;
                    minY = Long.MAX_VALUE;
                    maxY = 0;
                    answer = 0; 


            }
            return answerMin;

        }
        public network(){
        }

    }

    
    private static class Node {
        public int cow;
        public long x;
        public long y;
        public ArrayList<Node> neighbors;

        public Node(int cow, long x, long y) {
            this.cow = cow;
            this.x = x;
            this.y = y;
            neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public String toString(){
            return "Cow: "+cow +" X: "+x+" Y: "+y+" Neighbors: ";
        }
    }



    public static void main(String[] args) throws IOException{  
        File inputFile = new File("fenceplan.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        Scanner fileScanner = new Scanner(inputFile);
        int numOfCows = fileScanner.nextInt();
        int numOfPairs = fileScanner.nextInt();
        network classObj= new network();
        
        for(int i = 1; i<=numOfCows;i++){
            Node tempCow = new Node(i, fileScanner.nextInt(), fileScanner.nextInt());
            classObj.addNode(i, tempCow);
        }


        for(int i = 1; i<= numOfPairs;i++){
            int tempInt = fileScanner.nextInt();
            int nodeNeeded = fileScanner.nextInt();
            classObj.cowNetwork.get(tempInt).addNeighbor(classObj.cowNetwork.get(nodeNeeded));
            classObj.cowNetwork.get(nodeNeeded).addNeighbor(classObj.cowNetwork.get(tempInt));
        }
        long answer = classObj.BFS();
        out.println(answer);
        
//26819096



            out.close();  
        }  
}  