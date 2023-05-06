import java.lang.Math;

class State {

 private int hValue;
 private int pos9;
 private int[] board = new int[9];



 public State( int[] aboard ) {

 setHValue(aboard);
 setPos9(aboard);
 printState(aboard);


 }


 //set position of 9

 public void setPos9(int[] arr){

    int count = 0;
    while(arr[count] != 9 ){
        count++;
    }

int indexOf9 = count;
this.pos9 = indexOf9;

 }

 //get index of 9

 public int getPos9(){
    return this.pos9;
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

//print contents of state

 public void printState(int[] arr){

    System.out.println("Current State\n");

    System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    System.out.println(arr[3] + " " + arr[4] + " " + arr[5]);
    System.out.println(arr[6] + " " + arr[7] + " " + arr[8]);

        System.out.println("\n");
 }



 //move top 

 public int[] moveTop(int[] arr,State state){

    // verify if 9 can be movedTop
    int ninePos = state.getPos9();
    
    if(ninePos > 2){

        int toBeSwappedWith = arr[ninePos-3];

        int[] newState = new int[9];

       for(int i=0;i<newState.length;i++){
          
          if(i == ninePos){
        newState[i] = toBeSwappedWith;
          }
          else if( i == ninePos-3){
              newState[i] = 9;
          }else{
            newState[i] = arr[i];
          }

       }
       printState(newState);
       return newState;
    }else{

        System.out.println("Cannot move nine on top");

        return arr ;
    }

 }

 //move down

 public int[] moveDown(int[] arr, State state){

    //verify if  9 can be moved down

    int ninePos = state.getPos9();

    if(ninePos<5){

        int toBeSwappedWith = arr[ninePos+3];
        int[] newState = new int[9];

       for(int i=0;i<newState.length;i++){
          
          if(i == ninePos){
        newState[i] = toBeSwappedWith;
          }
          else if( i == ninePos+3){
              newState[i] = 9;
          }else{
            newState[i] = arr[i];
          }

      }

        printState(newState);
       return newState;

    }
    else{


        System.out.println("Cannot move nine down");

        return arr ;

    }



 }


} 