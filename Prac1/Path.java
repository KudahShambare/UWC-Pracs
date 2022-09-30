/*
Kudakwashe R Shamabre 4075731
CSC212 2022
Practical Assignment 1
*/
//Paths between 2 Nodes Class
class Path{
	Node from;
	Node to;
	int pathCounter;
	Node [] via;
//Path constructer
	public Path(Node from , Node to,int pathCounter){
		this.from=from;
		this.to=to;
		this.pathCounter=pathCounter;
	}
}