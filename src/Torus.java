import java.util.*;

class State {
	int[] board;
	State parentPt;
	int depth;

	public State(int[] arr) {
		this.board = Arrays.copyOf(arr, arr.length);
		this.parentPt = null;
		this.depth = 0;
	}

	public State[] getSuccessors() {
		
		//Index of the zero in the board (initialized to cause out of bounds error)
		int zeroPos = 10;
		
		//Array of States to be returned
		State[] successors = new State[4];
		
		//Find the index of the zero in the board
		for (int i = 0; i < this.board.length; i++) {
			if (this.board[i] == 0) {
				zeroPos = i;
			}
		}
		//Declare States
		State state1;
		State state2;
		State state3;
		State state4;
		
		//If the zero is in the first column
		if (zeroPos == 0 || zeroPos == 3 || zeroPos == 6) {
			state1 = new State(this.swap(zeroPos, ((zeroPos + 1) % 9)));
			state2 = new State(this.swap(zeroPos, ((zeroPos + 2) % 9)));
			state3 = new State(this.swap(zeroPos, ((zeroPos + 3) % 9)));
			state4 = new State(this.swap(zeroPos, ((zeroPos + 6) % 9)));
		} 
		
		//If the zero is in the second column
		else if (zeroPos == 1 || zeroPos == 4 || zeroPos == 7) {
			state1 = new State(this.swap(zeroPos, ((zeroPos + 1) % 9)));
			state2 = new State(this.swap(zeroPos, ((zeroPos + 3) % 9)));
			state3 = new State(this.swap(zeroPos, ((zeroPos + 6) % 9)));
			state4 = new State(this.swap(zeroPos, ((zeroPos + 8) % 9)));
		}
		
		//If the zero is in the third column
		else if(zeroPos == 2 || zeroPos == 5 || zeroPos == 8) {
			state1 = new State(this.swap(zeroPos, ((zeroPos + 3) % 9)));
			state2 = new State(this.swap(zeroPos, ((zeroPos + 6) % 9)));
			state3 = new State(this.swap(zeroPos, ((zeroPos + 7) % 9)));
			state4 = new State(this.swap(zeroPos, ((zeroPos + 8) % 9)));
		}
			
		
		// TO DO: get all four successors and return them in sorted order
		
		return successors;
	}

	//Method to swap two array elements are the input indices
	public int[] swap(int index1, int index2) {
		
		//Copy board
		int[] boardCopy = Arrays.copyOf(this.board, this.board.length);
		//Swap elements
		int temp = boardCopy[index1];
		boardCopy[index1] = boardCopy[index2];
		boardCopy[index2] = temp;
		
		return boardCopy;
	}
	
	public void printState(int option) {
		
		// TO DO: print a torus State based on option (flag)
		
	}

	public String getBoard() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			builder.append(this.board[i]).append(" ");
		}
		return builder.toString().trim();
	}

	public boolean isGoalState() {
		for (int i = 0; i < 9; i++) {
			if (this.board[i] != (i + 1) % 9)
				return false;
		}
		return true;
	}

	public boolean equals(State src) {
		for (int i = 0; i < 9; i++) {
			if (this.board[i] != src.board[i])
				return false;
		}
		return true;
	}
}

public class Torus {

	public static void main(String args[]) {
		if (args.length < 10) {
			System.out.println("Invalid Input");
			return;
		}
		int flag = Integer.valueOf(args[0]);
		int[] board = new int[9];
		for (int i = 0; i < 9; i++) {
			board[i] = Integer.valueOf(args[i + 1]);
		}
		int option = flag / 100;
		int cutoff = flag % 100;
		if (option == 1) {
			State init = new State(board);
			State[] successors = init.getSuccessors();
			for (State successor : successors) {
				successor.printState(option);
			}
		} else {
			State init = new State(board);
			Stack<State> stack = new Stack<>();
			List<State> prefix = new ArrayList<>();
			int goalChecked = 0;
			int maxStackSize = Integer.MIN_VALUE;

			// needed for Part E
			while (true) {				
				stack.push(init);
				while (!stack.isEmpty()) {
					//TO DO: perform iterative deepening; implement prefix list
					
				}
				
				if (option != 5)
					break;
				
				//TO DO: perform the necessary steps to start a new iteration
			        //       for Part E

			}
		}
	}
}
