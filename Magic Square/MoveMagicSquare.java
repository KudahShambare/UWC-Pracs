import java.util.*;


public class  MoveMagicSquare{


	 	//check if you can move 9 on top

static boolean canMoveTop(State state){
	if(state.getPos9()<3){
		return false;
	}
	else{
		return true;
	}
}


	 	//check if you can move 9 down

static boolean canMoveDown(State state){
	if(state.getPos9()>5){
		return false;
	}
	else{
		return true;
	}
}


	 	//check if you can move 9 to the left

static boolean canMoveLeft(State state){
	if(state.getPos9()%3 == 0){
		return false;
	}
	else{
		return true;
	}
}

 	//check if you can move 9 to the left

static boolean canMoveRight(State state){
	if(state.getPos9() == 2 || state.getPos9() == 5 || state.getPos9() == 8 ){
		return false;
	}
	else{
		return true;
	}
}


//expand a state

public static State expandState(State currentState,int num){

	System.out.println("Iteration number: "+num);

 	PriorityQueue<State> children = new PriorityQueue<State>(); 


 	if(canMoveTop(currentState)){
 		int[] topChild = currentState.moveTop(currentState);
 		State topChildState = new State(topChild);
 		children.add(topChildState);
 	}

 	if(canMoveDown(currentState)){
 		int[] downChild = currentState.moveDown(currentState);
 		State downChildState = new State(downChild);
 		children.add(downChildState);
 	}

 	if(canMoveLeft(currentState)){
 		int[] leftChild = currentState.moveLeft(currentState);
 		State leftChildState = new State(leftChild);
 		children.add(leftChildState);
 	}
 
 	if(canMoveRight(currentState)){
 		int[] rightChild = currentState.moveRight(currentState);
 		State rightChildState = new State(rightChild);
 		children.add(rightChildState);
 	 	}


 	
return children.poll();



}

// check if we are at goal state

static boolean desiredState(State currentState, State desiredState){

	int[] currentStateArr = currentState.getBoard();
	int[] desiredStateArr = desiredState.getBoard();

	Object[] arr1 = { currentStateArr };
	Object[] arr2 = { desiredStateArr };


	return Arrays.deepEquals(arr1,arr2);
}



//main method

 public static void main(String[] args) {

 	int[] initialArr =  {6,9,8,7,1,3,2,5,4};
 	int[] goalArr = {6,1,8,7,5,3,2,9,4};






 	State initialState = new State(initialArr);
 	State goalState = new State(goalArr);

 	int count = 0;

 // find solution using greedy best first search algorithm
 	System.out.println("Initial State:");
 initialState.printState(initialState);

do{
	count++;
	State efficientChild = expandState(initialState,count);
	efficientChild.printState(efficientChild);
	initialState = efficientChild;
}
while(desiredState(initialState,goalState) == false || count==700);

}


}


