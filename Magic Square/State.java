import java.lang.Math;

class State {

 private int hValue;
 private int pos9;
 private int[] board = new int[9];



 public State( int[] aboard ) {

 setHValue(aboard);

 }


//set heurestic value

 public void setHValue(int[] arr){

int k = 15;
//rows

int row1Sum = arr[0]+arr[1]+arr[2];
int row2Sum = arr[3]+arr[4]+arr[5];
int row3Sum = arr[6]+arr[7]+arr[8];

int column1Sum = arr[0]+arr[3]+arr[6];
int column2Sum = arr[1]+arr[4]+arr[7];
int column3Sum = arr[2]+arr[5]+arr[8];

int diagonal1Sum = arr[0]+arr[4]+arr[8];
int diagonal2Sum = arr[6]+arr[4]+arr[2];

int rowSum = Math.abs((k-row1Sum))+Math.abs((k-row2Sum))+Math.abs((k-row3Sum));
int columnSum = Math.abs((k-column1Sum))+Math.abs((k-column2Sum))+Math.abs((k-column3Sum));
int diagonalSum = Math.abs((k-diagonal1Sum))+Math.abs((k-diagonal2Sum));

int heurestic = rowSum+columnSum+diagonalSum;

this.hValue = heurestic;

 }
 
 //get heurestic value

 public int getHValue(){

    return this.hValue;
 }



} 