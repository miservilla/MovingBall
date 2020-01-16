import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MovingBall extends Application
{
    @Override
    public void start(Stage stage)
    {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 600, 600);
        scene.setFill(Color.CADETBLUE);

        PhongMaterial materialBLUE = new PhongMaterial();
        materialBLUE.setDiffuseColor(Color.BLUE);
        Sphere sphere = new Sphere(50, 50);
        sphere.setMaterial(materialBLUE);
        sphere.relocate(0,0);
        canvas.getChildren().add(sphere);


        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.show();

        Bounds bounds = canvas.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5),
                new KeyValue(sphere.layoutYProperty(), bounds.getMaxY()-sphere.getRadius())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }


}
