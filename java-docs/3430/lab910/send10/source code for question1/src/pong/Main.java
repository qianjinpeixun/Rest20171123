package pong;

import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Main extends Application {

    Circle gameBall = new Circle(20, Color.web("red", 1));
    Label plrScoreDraw = new Label("0");
    Label compScoreDraw = new Label("0");
    double speed = 2;// Ball Speed
    int compScore = 0;
    Random rndInst = new Random();// Random instance
    double xVel;
    double yVel;
    Rectangle paddlePlayer = new Rectangle(16, 128, Color.web("red", 1));
    Rectangle paddleComputer = new Rectangle(16, 128, Color.web("red", 1));
    int plrScore = 0;
    boolean pause = false;

    @Override
    public void start(Stage primaryStage) {

        try {

            paddlePlayer.setX(0);
            paddlePlayer.setY(137);
            paddlePlayer.setWidth(16);
            paddlePlayer.setHeight(128);

            paddleComputer.setX(764);
            paddleComputer.setY(0);
            paddleComputer.setWidth(16);
            paddleComputer.setHeight(128);

            xVel = Math.cos(rndInst.nextInt(5) + 5) * speed;
            yVel = Math.sin(rndInst.nextInt(5) + 5) * speed;

            Pane root = new Pane();
            Scene scene = new Scene(root, 800, 600);
            plrScoreDraw.setTranslateX(300);
            plrScoreDraw.setTranslateY(20);
            plrScoreDraw.setFont(new Font(30));

            compScoreDraw.setTranslateX(450);
            compScoreDraw.setTranslateY(20);
            compScoreDraw.setFont(new Font(30));

            gameBall.setTranslateX(300);
            gameBall.setTranslateY(300);

            root.getChildren().add(plrScoreDraw);
            root.getChildren().add(compScoreDraw);

            root.getChildren().add(paddlePlayer);
            root.getChildren().add(paddleComputer);
            root.getChildren().add(gameBall);

            Rectangle line1 = new Rectangle(800, 3, Color.web("green", 1));
            Rectangle line2 = new Rectangle(3, 600, Color.web("green", 1));
            line1.setX(0);
            line1.setY(70);
            line2.setX(400);
            line2.setY(0);

            root.getChildren().add(line1);
            root.getChildren().add(line2);
            primaryStage.setScene(scene);
            primaryStage.show();

            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });

            // handle mouse move events
            scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getY() > 5 && mouseEvent.getY() < 600 - 40 - 128) {
                        paddlePlayer.setY(mouseEvent.getY());
                    }
                }
            });

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        public void run() {
                            if (!pause) {
                                double newx = gameBall.getTranslateX() + xVel;
                                double newy = gameBall.getTranslateY() + yVel;
                                gameBall.setTranslateX(newx);
                                gameBall.setTranslateY(newy);

                                // Check for bottom wall, if the ball is out of
                                // windows, reset the location
                                if (gameBall.getTranslateY() > 600 - 20 - 45) {
                                    gameBall.setTranslateY(gameBall.getTranslateY() - 65);
                                    yVel = -yVel;
                                }

                                // Check for top wall, if the ball is out of
                                // windows, reset the location
                                if (gameBall.getTranslateY() < 0) {
                                    gameBall.setTranslateY(0);
                                    yVel = -yVel;
                                }

                                // Check for computer paddle, set the computer
                                // player' paddle in a correct position in order
                                // to
                                // hit the ball
                                // computer player never fail this game
                                // as a result, do not need to check if computer
                                // player will fail with 15 times

                                if (gameBall.getBoundsInParent().intersects(paddleComputer.getBoundsInParent())) {
                                    gameBall.setTranslateX(gameBall.getTranslateX() - 36);
                                    xVel = -xVel;
                                }

                                // Check for player paddle.
                                if (gameBall.getBoundsInParent().intersects(paddlePlayer.getBoundsInParent())) {
                                    gameBall.setTranslateX(gameBall.getTranslateX() + 20);
                                    xVel = -xVel;
                                }

                                // Check for left wall for human player
                                if (gameBall.getTranslateX() < 0.1) {

                                    // if fail with 15 times
                                    if (plrScore == 14) {
                                        // show a message to ask if want to
                                        // continue
                                        // or not
                                        plrScoreDraw.setText(String.valueOf(plrScore + 1));
                                        pause = true;
                                        Toolkit.getDefaultToolkit().beep();
                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        alert.setTitle("Pong");
                                        alert.setContentText("Try again?");

                                        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                                        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                                        alert.getButtonTypes().setAll(okButton, noButton);
                                        alert.showAndWait().ifPresent(type -> {
                                            if (type == okButton) {
                                                // if continue tro play
                                                // 'both score set to zero
                                                plrScore = 0;
                                                plrScoreDraw.setText(String.valueOf(plrScore));
                                                compScore = 0;
                                                compScoreDraw.setText(String.valueOf(compScore));
                                                pause = false;
                                            } else if (type == noButton) {
                                                Platform.exit();
                                                System.exit(0);
                                            }
                                        });

                                    }

                                    // show the current fail times
                                    plrScore += 1;
                                    // 'show the current fail times
                                    gameBall.setTranslateX(300);
                                    gameBall.setTranslateY(300);
                                    plrScoreDraw.setText(String.valueOf(plrScore));
                                }

                                // Check for right wall.
                                if (gameBall.getTranslateX() > 800 - 20 - 16) {
                                    compScore += 1;

                                    gameBall.setTranslateX(300);
                                    gameBall.setTranslateY(300);
                                    compScoreDraw.setText(String.valueOf(compScore));
                                }

                                // Set the computer player to move according to
                                // the
                                // ball's position."

                                if (gameBall.getTranslateY() > 5 && gameBall.getTranslateY() < 600 - 40) {
                                    paddleComputer.setTranslateY(gameBall.getTranslateY() - 70);
                                }

                            }
                        }
                    });
                }
            };

            timer.schedule(task, 0, 10);

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
