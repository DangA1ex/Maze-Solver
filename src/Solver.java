package hw4;

/**
 * handles solving the map and contains a Linked Stack which is the solution to
 * the maze
 * 
 * @author Alex
 *
 */
public class Solver {
	private boolean solved;
	private LinkedStack<Integer[]> stack;
	private Maze maze;
	private Integer[] current;

	/**
	 * solves the but iterating through the map and looking for the exit
	 * 
	 * @param map
	 *            map to be solved
	 */
	public void solve(Maze map) {
		this.maze = map;
		this.current = new Integer[2];
		this.current[0] = maze.getStartX();
		this.current[1] = maze.getStartY();
		this.stack = new LinkedStack<Integer[]>();
		this.stack.push(current);

		while (!stack.isEmpty() && !solved) {
			if (validMove(current[0] + 1, current[1])) {
				addPosition(current[0] + 1, current[1]);
				if (maze.getBlock(current[0], current[1]) == 'E') {
					this.solved = true;
				}
				this.maze.setMap(current[0], current[1]);
			} else if (validMove(current[0], current[1] + 1)) {
				addPosition(current[0], current[1] + 1);
				if (maze.getBlock(current[0], current[1]) == 'E') {
					this.solved = true;
				}
				this.maze.setMap(current[0], current[1]);
			} else if (validMove(current[0] - 1, current[1])) {
				addPosition(current[0] - 1, current[1]);
				if (maze.getBlock(current[0], current[1]) == 'E') {
					this.solved = true;
				}
				this.maze.setMap(current[0], current[1]);
			} else if (validMove(current[0], current[1] - 1)) {
				addPosition(current[0], current[1] - 1);
				if (maze.getBlock(current[0], current[1]) == 'E') {
					this.solved = true;
				}
				this.maze.setMap(current[0], current[1]);
			} else {
				stack.pop();
				current = stack.top();
			}
		}

		if (solved) {
			do {
				map.solMap(stack.top()[0], stack.top()[1]);
				stack.pop();
			} while (!stack.isEmpty());
		}
	}

	/**
	 * adds the position to the stack and sets the current position at the new
	 * position
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	private void addPosition(int x, int y) {
		Integer[] newPosition = { x, y };
		this.stack.push(newPosition);
		this.current = newPosition;
	}

	/**
	 * checks if the position at the given position is not a wall and has not been
	 * checked
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @return whether or not the position is valid
	 */
	public boolean validMove(int x, int y) {
		if (y >= 0 && y < maze.getySize() && x >= 0 && x < maze.getxSize()) {
			if (maze.getBlock(x, y) != '0' && maze.getBlock(x, y) != 'C') {
				return true;
			}
		}

		return false;
	}
}
