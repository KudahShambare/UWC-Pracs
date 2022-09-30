/*
Kudakwashe R Shamabre 4075731
CSC212 2022
Practical Assignment 1
*/
//node class --- a node represents a single nodeName with an airport for Q1 and sigle household for Q2
class Node{
String  nodeName;
Neighbors [] neighbors;


//CONSTRUCTOR  Method for Node
public Node(String nodeName,Neighbors [] neighbors){

this.nodeName=nodeName;
this.neighbors=neighbors;
}
}