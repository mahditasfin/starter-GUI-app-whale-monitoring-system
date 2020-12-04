package guiApp.observation;

import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SubmitButtonBox extends HBox {
    private ObservationData data;
    private String label = "Submit";
    private Button button;

    public SubmitButtonBox(ObservationData pData) {
      data = pData;
      button = new Button(label);
      button.setId("myButton");
      button.setOnAction(actionEvent -> submit());
      getChildren().add(button);

      // style: mouse over submit button
      DropShadow shadow = new DropShadow();
      shadow.setBlurType(BlurType.ONE_PASS_BOX);
      shadow.setColor(Color.DARKGRAY);
      button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(shadow));
      button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
    }

    private void submit() {
      data.addObservation();
    }
    public String getWhaleFromButton(){
        return data.getWhale();
    }
    public int getNumberFromButton(){
        return data.getNumber();
    }

  }
