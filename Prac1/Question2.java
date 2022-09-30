/*
Kudakwashe R Shamabre 4075731
CSC212 2022
Practical Assignment 1
*/
import java.util.*; //import all items from java utility library
import java.io.* ; //import all items from java io library

class Question2{

//main method
	public static void main(String[] args){
		//Read csv file

		try{
//get csv file
File csv=new File("household-deliveries.csv");
//variable to store number of  lines in the csv file
ArrayList <String> households=new ArrayList <String>();
Scanner myScanner= new Scanner(csv);

while(myScanner.hasNextLine()){
	households.add(myScanner.nextLine());
}
//remove first lie
households.remove(0);
//System.out.println(households);
//households as array
String [] householdsArray= households.toArray(new String[0]);
//System.out.println(Arrays.toString(householdsArray));
//All hosehold names 
String [] householdNames=new String[householdsArray.length];
//household neighbors
String [] householdNeighbors=new String[householdsArray.length];

for(int i=0;i<householdsArray.length;i++){
	householdNames[i]=householdsArray[i].substring(0,1);
   householdNeighbors[i]=householdsArray[i].substring(2);

}
//System.out.println(Arrays.toString(householdNames));
//stem.out.println(Arrays.toString(householdNeighbors));

//Nodes array
Node [] allNodes=new Node[householdNames.length];

//create Neighbor object
for(int i=0;i<householdNames.length;i++){
//System.out.println(i);
	String[] singleHouseholdNeighbors=householdNeighbors[i].split(";");
//System.out.println(Arrays.toString(singleHouseholdNeighbors));
	//Neighbors array
Neighbors[] allNeighbors=new Neighbors[singleHouseholdNeighbors.length/2];

	for(int j=0;j<singleHouseholdNeighbors.length;j++){
//System.out.println(singleHouseholdNeighbors[j]);
if(j%2==0){
//System.out.println(singleHouseholdNeighbors[j]);
	String neighborName=singleHouseholdNeighbors[j];
	int neighborDistance=Integer.parseInt(singleHouseholdNeighbors[j+1]);
	//System.out.println(neighborDistance);
	Neighbors neighbor=new Neighbors(neighborName,neighborDistance);
allNeighbors[j/2]=neighbor;

}
	Node householdNode=new Node(householdNames[i],allNeighbors);
	allNodes[i]=householdNode;


	}
	

}
//System.out.println(Arrays.toString(allNodes));
//create household graph
Graph householdGraph=new Graph(allNodes);
//check if 2 nodes are connected
//ask user for 2 nodes to compare
Scanner scan = new Scanner(System.in);
System.out.println("Hello wecome to the Bellman-Ford Shortest Path Algorithm");
System.out.println("Please give use the index of your Starting City (0-8):");
int start=scan.nextInt();
System.out.println("Please give use the index of your Ending City (0-8):");
int end=scan.nextInt(); 

householdGraph.connected(allNodes[start],allNodes[end]);



}
catch(Exception e){
	System.out.println(e);
}



}


}