package ik.ijse.dep10.media_player;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class AppInitializer extends Application {

    private boolean mute = false;
    private boolean volume = false;
    private MediaPlayer mediaPlayer;
    double t2=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainMethod(primaryStage);
        primaryStage.setTitle("Audio Player...");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public void mainMethod(Stage stage) {
        ImageView imgPlay = new ImageView();
        ImageView imgPause = new ImageView();
        ImageView imgStop = new ImageView();
        ImageView imgRepeat = new ImageView();
        ImageView imgVolume = new ImageView();
        ImageView imgCenter = new ImageView();

        Button btnOpen = new Button("OPEN");
        Label lblSongName = new Label("Add a song from library...");
        Label lblTitle = new Label("AUDIO PLAYER");
        Label lblVol = new Label("0%");
        Slider sliderVolume = new Slider();

        btnOpen.setMinWidth(60);
        btnOpen.setStyle("-fx-base:coral");

        lblVol.setTextFill(Color.rgb(0,0,200,0.8));
        lblVol.setFont(Font.font(20));
        lblVol.setMinWidth(60);

        lblTitle.setTextFill(Color.BLUE);
        lblTitle.setFont(Font.font(40));
        lblTitle.setMaxWidth(Double.MAX_VALUE);
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setPadding(new Insets(0,0,20,10));

        lblSongName.setMaxWidth(Double.MAX_VALUE);
        lblSongName.setAlignment(Pos.CENTER);
        lblSongName.setFont(Font.font(16));
        lblSongName.setTextFill(Color.DARKBLUE);
        lblSongName.setBackground(Background.fill(Color.LIGHTSKYBLUE));

        lblSongName.setAlignment(Pos.CENTER);
        HBox.setHgrow(lblTitle, Priority.ALWAYS);
        //txtSongName.setPadding(new Insets(0,100,0,100));

        Image icnPlay = new Image(this.getClass().getResource("/image/play.png").toString());
        Image icnPause = new Image(this.getClass().getResource("/image/pause.png").toString());
        Image icnStop = new Image(this.getClass().getResource("/image/stop.png").toString());
        Image icnRepeat = new Image(this.getClass().getResource("/image/repeat.png").toString());
        Image icnSound = new Image(this.getClass().getResource("/image/sound.png").toString());
        Image icnMute = new Image(this.getClass().getResource("/image/mute.png").toString());
        Image icnMusic = new Image(this.getClass().getResource("/image/music.png").toString());


        imgPlay.setImage(icnPlay);
        imgPlay.setFitWidth(50);
        imgPlay.setFitHeight(50);


        imgPause.setImage(icnPause);
        imgPause.setFitWidth(50);
        imgPause.setFitHeight(50);


        imgStop.setImage(icnStop);
        imgStop.setFitWidth(50);
        imgStop.setFitHeight(50);


        imgRepeat.setImage(icnRepeat);
        imgRepeat.setFitWidth(50);
        imgRepeat.setFitHeight(50);


        imgVolume.setImage(icnSound);
        imgVolume.setFitWidth(50);
        imgVolume.setFitHeight(50);


        imgCenter.setImage(icnMusic);
        imgCenter.setFitWidth(300);
        imgCenter.setFitHeight(300);

        VBox vBoxCenter = new VBox(imgCenter);
        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setPadding(new Insets(20,20,50,20));

        HBox hBoxBottom = new HBox(20,imgPlay, imgPause,imgStop,imgRepeat,imgVolume,sliderVolume,lblVol);
        hBoxBottom.setAlignment(Pos.CENTER);
        hBoxBottom.setPadding(new Insets(10,0,20,0));

        VBox vBoxTop = new VBox(10, lblTitle, btnOpen, lblSongName);
        vBoxTop.setPadding(new Insets(10));
        hBoxBottom.setMaxWidth(Double.MAX_VALUE);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBoxTop);
        borderPane.setBottom(hBoxBottom);
        borderPane.setCenter(vBoxCenter);
        borderPane.setPadding(new Insets(10));
        borderPane.setBorder(Border.stroke(Color.LIGHTSKYBLUE));

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinWidth(600);
        stage.setMinHeight(600);

    }
}
