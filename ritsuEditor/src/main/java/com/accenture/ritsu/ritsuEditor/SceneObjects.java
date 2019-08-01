package com.accenture.ritsu.ritsuEditor;

import javafx.scene.Group;
import javafx.scene.Node;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SceneObjects {

    Group group = new Group();

    public void add(Node node){
        group.getChildren().add(node);
    }
}
