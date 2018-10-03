import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }

    public void start(Stage primaryStage){




//VARIABLES
     //Stage
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Laboratoire 6");
     //MENU
        Menu file = new Menu("Fichiers");
        Menu action = new Menu("Actions");
        Menu load = new Menu("Charger une image");
        MenuItem pic1 = new MenuItem("Image #1");
        MenuItem pic2 = new MenuItem("Image #2");
        MenuItem pic3 = new MenuItem("Image #3");
        MenuItem reset = new MenuItem("Réinitialiser");
     //Centre
        Image image = new Image("default.jpg");
        Image image1 = new Image("image1.jpg");
        Image image2 = new Image("image2.jpg");
        Image image3 = new Image("image3.jpg");
        ImageView imageViewdef = new ImageView(image);
        imageViewdef.setFitHeight(500);
        imageViewdef.setFitWidth(500);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(500);
        imageView1.setFitWidth(500);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(500);
        imageView2.setFitWidth(500);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(500);
        imageView3.setFitWidth(500);
        Slider lum=new Slider(-1,1,0);
        lum.setMaxWidth(140);
        Slider con=new Slider(-1,1,0);
        con.setMaxWidth(140);
        Slider tei=new Slider(-1,1,0);
        tei.setMaxWidth(140);
        Slider sat=new Slider(-1,1,0);
        sat.setMaxWidth(140);
        Label lumT=new Label("Luminosité");
        Label conT=new Label("Contraste");
        Label teiT=new Label("Teinte");
        Label satT=new Label("Saturation");
     //Bottom
        Label welcome=new Label("  Bienvenue dans le modificateur d'images!");
        Label resetT=new Label("  Réinitialisation des ajustement de couleurs");
        Label pic1T=new Label("  Image 1 chargée");
        Label pic2T=new Label("  Image 2 chargée");
        Label pic3T=new Label("  Image 3 chargée");

//PLACEMENTS & NAMES
        file.getItems().addAll(load);
        load.getItems().addAll(pic1, pic2, pic3);
        action.getItems().addAll(reset);
        MenuBar menuBar = new MenuBar(file, action);

        VBox vb=new VBox(lumT,lum,conT,con,teiT,tei,satT,sat);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);

        HBox hb=new HBox(imageViewdef,vb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        BorderPane section = new BorderPane();
        section.setTop(menuBar);
        section.setBottom(welcome);
        section.setCenter(hb);



//SetScene
        primaryStage.setScene(new Scene(section));

//ACTIONS

//SHOW
        primaryStage.show();
    }
}


