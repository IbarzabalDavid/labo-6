import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
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
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);
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
        Label label=new Label("Bienvenue dans le modificateur d'images!");
        label.setPadding(new Insets(5));


//PLACEMENTS & NAMES
        file.getItems().addAll(load);
        load.getItems().addAll(pic1, pic2, pic3);
        action.getItems().addAll(reset);
        MenuBar menuBar = new MenuBar(file, action);
        ContextMenu contextMenu=new ContextMenu(file,action);


        VBox vb=new VBox(lumT,lum,conT,con,teiT,tei,satT,sat);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);

        HBox hb=new HBox(imageView,vb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        BorderPane section = new BorderPane();
        section.setTop(menuBar);
        section.setBottom(label);
        section.setCenter(hb);
        section.setOnContextMenuRequested(event -> {
            contextMenu.show(section, event.getScreenX(), event.getScreenY());
        });


//SetScene
        primaryStage.setScene(new Scene(section));

//ACTIONS
     // menu
        pic1.setOnAction((event) ->{
            imageView.setImage(image1);
            reset.fire();
            label.setText("Image 1 chargée");
        });
        pic2.setOnAction((event) ->{
            imageView.setImage(image2);
            reset.fire();
            label.setText("Image 2 chargée");
        });
        pic3.setOnAction((event) ->{
            imageView.setImage(image3);
            reset.fire();
            label.setText("Image 3 chargée");
        });
        reset.setOnAction((event) ->{
            lum.setValue(0);
            con.setValue(0);
            tei.setValue(0);
            sat.setValue(0);
            label.setText("Réinitialisation des ajustement de couleurs");
        });
     //Setting imageView
        ColorAdjust imageColors = new ColorAdjust();
        imageView.setEffect(imageColors);
        lum.valueProperty().addListener((that, oldValue, newValue)->{
            imageColors.setBrightness((double)newValue);
        });
        con.valueProperty().addListener((that, oldValue, newValue)->{
            imageColors.setContrast((double)newValue);
        });
        tei.valueProperty().addListener((that, oldValue, newValue)->{
            imageColors.setHue((double)newValue);
        });
        sat.valueProperty().addListener((that, oldValue, newValue)->{
            imageColors.setSaturation((double)newValue);
        });





//SHOW
        primaryStage.show();
    }
}


