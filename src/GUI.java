package hw4;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * handles making the gui and the file chooser
 * 
 * @author Alex
 *
 */
public class GUI {
	private boolean loaded = false;
	private File file = null;
	private Solver solver;
	private GridPane gp;
	Maze maze;

	/**
	 * handles the main menu and the buttons
	 * 
	 * @param primaryStage
	 *            main stage
	 */
	public void menu(Stage primaryStage) {
		BorderPane bp = new BorderPane();
		Scene sc = new Scene(bp, 650, 650);
		sc.getStylesheets().add("hw4/application.css");

		VBox top = new VBox();
		top.getStyleClass().add("subBackground");
		Label title = new Label("Maze Solver");
		title.getStyleClass().add("title");
		top.getChildren().add(title);

		VBox bottom = new VBox();
		bottom.getStyleClass().add("background");
		HBox options = new HBox(2);
		options.getStyleClass().add("subBackground");
		Button load = new Button("Load");
		Button solve = new Button("Solve");
		options.getChildren().add(load);
		options.getChildren().add(solve);
		bottom.getChildren().add(options);

		ScrollPane sp = new ScrollPane();
		sp.getStyleClass().add("background");
		gp = new GridPane();
		gp.getStyleClass().add("background");
		sp.setContent(gp);

		bp.setTop(top);
		bp.setCenter(sp);
		bp.setBottom(bottom);

		primaryStage.setScene(sc);
		primaryStage.show();

		load.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				fileChooser(primaryStage);
				refreshMaze();
				loaded = true;
			}
		});

		solve.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				if (loaded) {
					solver = new Solver();
					solver.solve(maze);
					refreshMaze();
				}
			}
		});
	}

	/**
	 * handles the file chooser
	 * 
	 * @param primaryStage
	 *            main stage
	 */
	public void fileChooser(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		file = fileChooser.showOpenDialog(primaryStage);
		try {
			maze = new Maze(file);
			menu(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * refreshes the map at the grid pane in the center of the main menu
	 */
	public void refreshMaze() {
		for (int i = 0; i < maze.getxSize(); i++) {
			for (int j = 0; j < maze.getySize(); j++) {
				if (maze.getBlock(i, j) == 'S') {
					Label start = new Label("S");
					start.getStyleClass().add("start");
					start.setMinWidth(30);
					start.setMinHeight(30);
					gp.add(start, j, i);
				} else if (maze.getBlock(i, j) == 'E') {
					Label end = new Label("E");
					end.getStyleClass().add("end");
					end.setMinWidth(30);
					end.setMinHeight(30);
					gp.add(end, j, i);
				} else if (maze.getBlock(i, j) == '1' && maze.getBlock(i, j) != 'C') {
					Label path = new Label();
					path.getStyleClass().add("path");
					path.setMinWidth(30);
					path.setMinHeight(30);
					gp.add(path, j, i);
				} else if (maze.getBlock(i, j) == 'P') {
					Label solution = new Label();
					solution.getStyleClass().add("solution");
					solution.setMinWidth(30);
					solution.setMinHeight(30);
					gp.add(solution, j, i);
				} else if (maze.getBlock(i, j) == '0'){
					Label wall = new Label();
					wall.getStyleClass().add("wall");
					wall.setMinWidth(30);
					wall.setMinHeight(30);
					gp.add(wall, j, i);
				}
			}
		}
	}
}
