
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: (Give a brief description for each Class) JavaFX bootstrap class
 * Due: 07/07/2025
 * Platform/compiler: MacOS openjdk21 temurin
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Oguz Can Yilmazlar
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXDriver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 600, 350));
		stage.setTitle("Cybersecurity Encryption and Decryption");
		stage.show();
	}
}
