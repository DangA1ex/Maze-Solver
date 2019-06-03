package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * handles creation and manipulation of the maze
 * 
 * @author Alex
 *
 */
public class Maze {
	private char[][] map;
	private int xSize;
	private int ySize;
	private int startX;
	private int startY;

	/**
	 * default constructor for the maze
	 */
	public Maze() {
		this.xSize = 0;
		this.ySize = 0;
	}

	/**
	 * takes a text file and sets the size of the maze, the start position, and the
	 * acutal maze itself
	 * 
	 * @param file
	 *            text file to be parse
	 * @throws FileNotFoundException
	 *             exception if no file is found
	 */
	public Maze(File file) throws FileNotFoundException {
		this.xSize = 0;
		this.ySize = 0;
		String line = "";
		String[] mapSize = null, coordinate = null;
		ArrayList<Character> values = new ArrayList<Character>();
		Scanner s = new Scanner(file);

		line = s.nextLine();
		mapSize = line.split(" ");
		this.xSize = Integer.parseInt(mapSize[0]);
		this.ySize = Integer.parseInt(mapSize[1]);

		line = s.nextLine();
		coordinate = line.split(" ");
		this.startX = Integer.parseInt(coordinate[0]);
		this.startY = Integer.parseInt(coordinate[1]);

		while (s.hasNextLine()) {
			line = s.nextLine();
			for (int i = 0; i < ySize; i++) {
				values.add(line.charAt(i));
			}
		}
		s.close();

		setupMaze(values);
	}

	/**
	 * set the node at the given position as checked
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public void setMap(int x, int y) {
		this.map[x][y] = 'C';
	}
	
	/**
	 * set the node at the given position as checked
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public void solMap(int x, int y) {
		this.map[x][y] = 'P';
	}

	/**
	 * sets up the maze according to the given list of values
	 * 
	 * @param values
	 *            array list of values
	 */
	private void setupMaze(ArrayList<Character> values) {
		int count = 0;
		map = new char[xSize][ySize];

		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				map[i][j] = values.get(count);
				count++;
			}
		}
	}

	/**
	 * gets node at given position
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @return value at given position
	 */
	public char getBlock(int x, int y) {
		//if (y >= 0 && y < ySize && x >= 0 && x < xSize) {
			return map[x][y];
		//}
		//return ' ';
	}

	/**
	 * gets x coordinate of starting position
	 * 
	 * @return x coordinate of starting position
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * gets y coordinate of starting position
	 * 
	 * @return y coordinate of starting position
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * gets the number of columns
	 * 
	 * @return number of columns
	 */
	public int getxSize() {
		return xSize;
	}

	/**
	 * gets the number of rows
	 * 
	 * @return numbers of rows
	 */
	public int getySize() {
		return ySize;
	}

	/**
	 * prints the maze
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
