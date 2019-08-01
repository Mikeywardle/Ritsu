package com.accenture.ritsu.ritsuEditor;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.net.URL;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RitsuEditorApplication extends Application{

	private ConfigurableApplicationContext springContext;
	private static MouseClickState mouseClickState = MouseClickState.MOUSE_UP;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;

	private static double lastMouseX = 0;
	private static double lastMouseY = 0;

	public static final double dragSpeed = -1.2;
	public static final double zoomSpeed = 2;

	public static final double maxCameraZoom =350;
	public static final double minCameraZoom =-6000;

	private static Group group = new Group();


	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(RitsuEditorApplication.class);
		//BootFxController controller = springContext.getBean(BootFxController.class);
		//scene = new Scene(controller.getView());
		//scene.getStylesheets().add(CSS_PATH);
	}

	@Override
	public void start(Stage primaryStage) {
		Sphere sphere = new Sphere(50);
		Sphere sphere2 = new Sphere(50);

		InitaliseBackground();

		group.getChildren().add(sphere);
		group.getChildren().add(sphere2);

		Camera camera = new PerspectiveCamera();
		Scene scene = new Scene(group, WIDTH, HEIGHT);
		scene.setFill(Color.GRAY);
		scene.setCamera(camera);

		scene.setOnScroll((ScrollEvent event) -> {
			// Adjust the zoom factor as per your requirement
			double deltaY = event.getDeltaY();
			double newZoom = camera.getTranslateZ() + (deltaY * zoomSpeed);

			if(newZoom>minCameraZoom && newZoom<maxCameraZoom)
				camera.translateZProperty().set(newZoom);

		});

		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.isSecondaryButtonDown()) {
					mouseClickState = MouseClickState.RIGHT_DOWN;
				} else if(mouseEvent.isPrimaryButtonDown()) {
					mouseClickState = MouseClickState.LEFT_DOWN;
				}
			 }
		});

		scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseClickState == MouseClickState.LEFT_DOWN) {
					camera.translateXProperty().set(camera.getTranslateX() + (mouseEvent.getScreenX() - lastMouseX) * dragSpeed);
					camera.translateYProperty().set(camera.getTranslateY() + (mouseEvent.getScreenY() - lastMouseY) * dragSpeed);
				}

				lastMouseX= mouseEvent.getScreenX();
				lastMouseY = mouseEvent.getScreenY();
			}
		});

		scene.addEventHandler(MouseEvent.MOUSE_RELEASED, event ->{
			mouseClickState = MouseClickState.MOUSE_UP;});

		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				lastMouseX= mouseEvent.getScreenX();
				lastMouseY = mouseEvent.getScreenY();
			}
		});

		sphere.translateXProperty().set(WIDTH / 2);
		sphere.translateYProperty().set(HEIGHT / 2);

		sphere2.translateXProperty().set(WIDTH / 2 +120);
		sphere2.translateYProperty().set(HEIGHT / 2);

		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
				case SPACE:
					System.out.println(camera.getTranslateZ());
			}
		});

		primaryStage.setTitle("Ritsu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void InitaliseBackground() {
		PhongMaterial  material =  new PhongMaterial();
		URL url = getClass().getClassLoader().getResource("Background_Grid.png");
		Image backgroundMap = new Image(url.toString());
		material.setDiffuseMap(backgroundMap);
		int startDistance = 100;

		Box tile = new Box( 100,100,0.01);
		tile.translateXProperty().set(startDistance);
		tile.translateYProperty().set(startDistance);
		tile.translateZProperty().set(50);

		tile.setMaterial(material);
	}


	@Override
	public void stop() throws Exception {
		springContext.stop();
	}


	public static void main(String[] args) {
		launch(args);
	}
}