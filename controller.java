package student;

import java.util.Random;
import java.util.Scanner;

public class controller {

    public static void main(String[] args) {
        
        String keepcleaning=null;
        int totalCost=0;
        int costOfPath=0;
        int downMoves=0;
        int rightMoves=0;
        boolean hitsKey=false;
        boolean foundDirty=false;
        Scanner userInput = new Scanner (System.in);
        
        System.out.println("Welcome to the Vaccum Cleaner World simulator. Press any key to begin.");
    if(userInput.hasNext()) {
        hitsKey=true;
    }
        
        while(hitsKey)
        {
            System.out.println("Great! lets begin...");
            System.out.println("In this simulation there is an intelligent agent whos job is to clean dirty rooms. "
                    + "\nYou will choose the number of rooms(grid size)."
                    + "\nHow many rows would you like in the grid? ");
            hitsKey=false;
        }
        userInput.nextLine();
int rows=userInput.nextInt();
System.out.println("How many columns would you like in the grid? ");
int columns = userInput.nextInt();
int numRooms=rows*columns;

System.out.println("You choose a " + rows +"X"+columns+" grid.");
System.out.println("Thats a total of "+numRooms+" rooms!\n");
System.out.println("How many rooms should be dirty? ");
int dirtyRooms=userInput.nextInt();
int [][] board = new int[rows][columns];
System.out.println("Ok, there will be "+dirtyRooms+" dirty rooms.");
System.out.println("I will now randomly assign which rooms will be dirty and then print the grid."
        + "\nPress any key to continue.");

if(userInput.hasNext()) {
    hitsKey=true;
    
}
for(int i=0;i<board.length;i++) {
    for(int j=0;j<board[i].length;j++) {
        board[i][j]=0;
    }
}
Random rand = new Random();
for(int i=0; i<dirtyRooms;i++) {
    int randx=rand.nextInt(board.length);
    int randy=rand.nextInt(board.length);
    board[randx][randy]=1;
}
    
    while(hitsKey)
    {
        System.out.println("Awesome.....Heres what the grid looks like(An 1 indicates a dirty room)...");
        hitsKey=false;
    }
    userInput.nextLine();
    for(int i=0;i<board.length;i++) {
        for(int j = 0;j<board[i].length;j++) {
            System.out.print(board[i][j]+ "\t");
        }
        System.out.println();
    }
    System.out.println("Here are the settings for this problem: \n"
            + "\nInitial State: There are "+numRooms+" rooms, "+dirtyRooms+" of them are dirty.\n"
                    + "The vaccum must start at its home which is the first room (row 1 column 1 on the grid)\n"
                    + "Goal State: All rooms are cleaned in the lowest path cost possible.\n"
                    + "Actions: The vaccum can move left, right, up, or down into any room. The vaccum can suck.\n"
                    + "The vaccum must return to its home after each clean to reacharge.\n"
                    + "Path Cost: The cost to move in any direction is 1, the cost to suck is 2. There is no cost to return home after cleaning.\n"
                    + "Transition Model: A move in any direction places the vaccum in the desired room. Sucking cleans the room.\n"
                    + "Vaccum automatically returns home after cleaning a room.\n\n");
System.out.println("Now that we have gone over the logistics lets start cleaning! Press any key to continue.");
userInput.nextLine();
if(userInput.hasNext()) {
    hitsKey=true;
}
    
    while(hitsKey)
    {
        System.out.println("Great! lets begin...");
        System.out.println("The vaccum is cleaning its first room. ");
        hitsKey=false;
    }
  
    for(int i=0;i<rows&&!foundDirty;i++) {
        for(int j=0;j<columns&&!foundDirty;j++) {
            if(board[i][j]==1) {
                foundDirty=true;
            board[i][j]=0;
            downMoves=i;
            rightMoves=j;
            totalCost+=i+j+2;
            costOfPath=i+j+2;
            System.out.println("The vaccum has cleaned the room at "+(i+1)+"X"+(j+1)+" on the board with a cost of "+costOfPath);
            System.out.println("The moves that were made were "+downMoves+" down moves and "+rightMoves+" moves to the right.\n"
                    + "Those moves cost 1 point each. There was also 1 sucking move which has a cost of 2\n");
            costOfPath=0;
            dirtyRooms--;
            downMoves=0;
            rightMoves=0;
            System.out.println("There are "+dirtyRooms+" dirty rooms left. This is what the grid looks like now:\n ");
            for(int g=0;g<board.length;g++) {
                for(int m = 0;m<board[g].length;m++) {
                    System.out.print(board[g][m]+ "\t");
                }
                System.out.println();
            }
            userInput.nextLine();
            System.out.println("Press any key to continue.");
           
        }
            
        }
       
    }
    while(dirtyRooms>0) {
        foundDirty=false;
    if(userInput.hasNext()) {
        hitsKey=true;
    }
        
        while(hitsKey)
        {
           
            System.out.println("The vaccum is cleaning its next room. ");
            hitsKey=false;
        }
       
        for(int i=0;i<rows&&!foundDirty;i++) {
            for(int j=0;j<columns&&!foundDirty;j++) {
                if(board[i][j]==1) {
                board[i][j]=0;
                totalCost+=i+j+2;
                costOfPath=i+j+2;
                downMoves=i;
                rightMoves=j;
                System.out.println("The vaccum has cleaned the room at "+(i+1)+"X"+(j+1)+" on the board with a cost of "+costOfPath);
                System.out.println("The moves that were made were "+downMoves+" down moves and "+rightMoves+" moves to the right.\n"
                        + "Those moves cost 1 point each. There was also 1 sucking move which has a cost of 2\n");
                
                downMoves=0;
                rightMoves=0;
                costOfPath=0;
                dirtyRooms--;
                System.out.println("There are "+dirtyRooms+" dirty rooms left.");
                System.out.println("This is what things look like now: \n");
                for(int g=0;g<board.length;g++) {
                    for(int m = 0;m<board[g].length;m++) {
                        System.out.print(board[g][m]+ "\t");
                    }
                    System.out.println();
                }
                
                System.out.println("Press any key to continue."); 
                 keepcleaning = userInput.nextLine();
                 userInput.next();
              
            }
                
                
            }
            
           
           
        }
        if(keepcleaning!=null) {
            
            hitsKey=true;
        }
        
    }
    if(dirtyRooms==0) {
        System.out.println("All of the rooms have been cleaned! The total cost was "+totalCost);
        System.out.println("The goal state has been reached!! Thank you for playing the vaccum world simulator.");
    }
    }

}
