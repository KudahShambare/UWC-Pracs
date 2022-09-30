/*
Kudakwashe R Shamabre 4075731
CSC212 2022
Practical Assignment 1
*/
//Graph class 
class Graph{
static Node [] graphNodes;
	//CONSTRUCTOR  Method for Graph
public Graph(Node [] graphNodes){
	this.graphNodes=graphNodes;
}
//get list of all names in the array passed
public static String[] getNeighbors(Neighbors [] arr){
	String[] arrNeighbors=new String[arr.length];
	for(int k=0;k<arr.length;k++){
	arrNeighbors[k]=arr[k].name;
	}
return arrNeighbors;
}
//get node from city name
public static Node getNodes(String name){
	for(int i=0;i<graphNodes.length;i++){
		if(graphNodes[i].nodeName.equals(name)) return graphNodes[i];
	}
	return new Node(null,null);
}
//check if 2 cities are connected
public static boolean connected(Node sourceNode, Node destinationNode){

	boolean returnValue=false;

String[]sourceNodeNeighbors=getNeighbors(sourceNode.neighbors);
String [] destinationNodeNeighbors=getNeighbors(destinationNode.neighbors);

//at most 2 nodes have N-1 edges between them, where N is the total number of nodes in a graph;
//for(int a=0;a<graphNodes.length;a++){

	//Assumptuion: directed graph
	
//check if destinationNode is a neighbor of sourceNode
for(int i=0;i<sourceNodeNeighbors.length;i++){
	if(sourceNodeNeighbors[i].equals(destinationNode.nodeName)){
		returnValue=true;
		System.out.println(" connected");
		//Path nodePath=new Path(sourceNode,destinationNode,0);
		
		return returnValue;
	}

//connected(nextNode,destinationNode);
}
	//experiment
/*
int count=0;
	//while(returnValue==false ){
		Node nextNode=getNodes(sourceNodeNeighbors[count+2]);
		//System.out.println(nextNode);
		connected(nextNode,destinationNode);
	//	count++;
	//}


	//experimental code!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//if nodes are not directly we have to check 
for(int j=0;j<sourceNodeNeighbors.length;j++){

	System.out.println(sourceNodeNeighbors[j]);
}
*/
//end of experiment!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//}
	
System.out.println("not connected");

		return returnValue;
}


}
