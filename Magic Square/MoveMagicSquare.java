

public class  MoveMagicSquare{


//main method

 public static void main(String[] args) {

 	int[] initialState =  {6,9,8,7,1,3,2,5,4};

 	State initial = new State(initialState);

 	System.out.println(initial.moveTop(initialState,initial));




	}


}


