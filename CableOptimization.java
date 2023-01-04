public class CableOptimization {
    
    //the cables we need 
    private NeedType [] needArray; 

    //the cables we have 
    private HaveType [] haveArray; 

    //each index of the need array has 
    //1. how many of each cable we need 
    //2. whether or not the index has been traversed 
    private class NeedType {

        //how many we need 
        private int needNum; 
        //whether or not this has been traversed/finalized 
        private boolean needTraversed; 

        private NeedType(int needNum, boolean needTraversed) {
            this.needNum = needNum; 
            this.needTraversed = false; 
        }
    }

    //each index of the have array has 
    //1. how many of each cable we have
    //2. whether or not the index has been traversed 
        private class HaveType {

            //how many we have 
            private int haveNum; 
            //whether or not this has been traversed/finalized
            private boolean haveTraversed; 
    
            private NeedType(int haveNum, boolean haveTraversed) {
                this.haveNum = haveNum; 
                this.haveTraversed = false; 
            }
    }

    //optimizes and prints out what is best 
    public void optimize () {
                
            //stopping condition for the algorithm, if our haves are all
            //traversed, then we cannot continue with the optimization 
            for (int i = 0; i < haveArray.length; i++){
                if(haveArray[i].haveTraversed == true) {
                    System.out.println("I have been optimized");
                    break; 
                }
            }

            //traverse what we have and compare it to what we need 
            int i = haveArray.length; 
            //traverse what we need and compare it to what we have 
            int j = needArray.length; 
                while (i >= 0 && j >= 0) {

                    //conditions for an index to be considered 
                    if (haveArray[i].haveNum != 0 && haveArray[i].haveTraversed == false) {

                            //if we need and have the same amount of cables 
                            if (needArray[j].needNum == haveArray[i].haveNum){

                                //we use haveArray[i].haveNum cables of size i for the 
                                // needArray[i].needNum cables of size j
                                System.out.print("We have "); 
                                System.out.print(haveArray[i].haveNum); 
                                System.out.print( "cables of size "); 
                                System.out.print(i); 
                                System.out.print("for the "); 
                                System.out.print(needArray[j].needNum); 
                                System.out.print( "cables of size j "); 
                                
                                haveArray[i].haveNum = haveArray[i].haveNum - needArray[i].needNum; 
                                haveArray[i].haveTraversed = true; 
                                j--; 
                                i--; 
                            }

                            //if we need less cables than we have for a given index 
                            else if (needArray[j].needNum < haveArray[i].haveNum){
                            
                                //we have have needArray[i].needNum cables of size i
                                //for the needArray[i].needNum cables of size j
                                System.out.print("We have "); 
                                System.out.print(needArray[j].needNum); 
                                System.out.print( "cables of size "); 
                                System.out.print(j); 
                                System.out.print("for the "); 
                                System.out.print(needArray[j].needNum); 
                                System.out.print( "cables of size j "); 

                                //we now have this many cables left over 
                                haveArray[i].haveNum = haveArray[i].haveNum - needArray[i].needNum; 

                                //loop through the lower indices until we do not have 
                                //anything left in the have array 
                                for(int opt = j-1; opt >= 0; opt--) {

                                    if (haveArray[i].haveNum > 0) {
                                    System.out.print("We have "); 
                                    System.out.print(needArray[j].needNum); 
                                    System.out.print( "cables of size "); 
                                    System.out.print(j); 
                                    System.out.print("for the "); 
                                    System.out.print(needArray[j].needNum); 
                                    System.out.print( "cables of size j "); 
                                }
                            }

                            }
                        
                        i++; 
                    }
                    else {
                        i--;
                        j--; 

                    }
              //  }
                
            }
    }
}
