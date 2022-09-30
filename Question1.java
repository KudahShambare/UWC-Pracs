/*
Kudakwashe R Shamabre 4075731
CSC212 2022
Practical Assignment 1
*/
import java.util.*; //import all items from java utility library
import java.io.* ; //import all items from java io library
import  java.lang.*; //import all items from the java lang library


class Question1{

	//get shortest path from a list of different paths

public static String shortestPath(Path[] allPaths){

	return "";

}

//main method

public static void main(String[] args){
// Read CSV
try{
//get csv file
File csv=new  File("airline-network.csv");
//variable to store number of  lines in the csv file
ArrayList <String> cities=new ArrayList <String>();
Scanner myScanner= new Scanner(csv);
//read user input
Scanner scan=new Scanner(System.in);

while(myScanner.hasNextLine()){
String line=myScanner.nextLine();
//remove commas at the end of each line
	StringBuffer myBuffer= new StringBuffer(line);
while(line.endsWith(",")){

	line=myBuffer.deleteCharAt(line.length()-1).toString();

}

cities.add(line);
}
//remove first element which contains headings
cities.remove(0);

//change arraylist to array
String [] cityArray=cities.toArray(new String[0]);
//Array to store graph Nodes

ArrayList<Node> allAirportCityNodes=new ArrayList<Node>();

//create city Nodes
for(int i=0;i<cityArray.length;i++){
	ArrayList <Neighbors> neighborList= new ArrayList<Neighbors>();
	//source city 
	String source=cityArray[i].substring(0,3);
	//destination city
	String [] destinations=cityArray[i].substring(4).split(",");
		//System.out.println(Arrays.toString(destinations));
		//create Neigbhor Objects from destination
			//get even indexes that have destination names
            for(int k=0;k<destinations.length;k++){
             	if(k%2==0){
             		int dist= Integer.parseInt(destinations[k+1]);
             		
Neighbors allNeighbors=new Neighbors(destinations[k],dist);
neighborList.add(allNeighbors);
             	}

             }

		//Create a Node for each City
              Neighbors [] neighborsArray=neighborList.toArray(new Neighbors[0]);
	Node myNode=new Node(source,neighborsArray);
		//add each node to allAirportCityNodes arr
	allAirportCityNodes.add(myNode);
	
}
//change allAirportCityNodes to array
Node [] allAirportCityNodesArray= allAirportCityNodes.toArray(new Node[0]);

//ask user for 2 nodes to compare
System.out.println("Hello wecome to the Dijkstra's Shortest Path Algorithm");
System.out.println("Please give use the index of your Starting City (0-10):");
int start=scan.nextInt();
System.out.println("Please give use the index of your Ending City (0-10):");
int end=scan.nextInt(); 

//Create the graph from Nodes
Graph cityGraph =new Graph(allAirportCityNodesArray);

cityGraph.connected(allAirportCityNodesArray[start],allAirportCityNodesArray[end]);


}

catch(Exception error){

System.out.println(error);

}





}


}
