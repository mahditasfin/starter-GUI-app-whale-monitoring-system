package guiApp.observation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class InputObservationPanel extends HBox {
  private ObservationData data;
  private Slider aSlider = createSlider();

  public InputObservationPanel(ObservationData pData) {
    data = pData;
    aSlider.setValue(data.DEFAULT_NUMBER);
    aSlider.setMax(data.MAX_NUMBER);
    getChildren().add(aSlider);
    aSlider.valueProperty().addListener(new ChangeListener<Number>()
    {
      public void changed(ObservableValue<? extends Number> pValue, Number pOld, Number pNew)
      {
        data.setNumber(pNew.intValue());
      }
    });
  }

  private static Slider createSlider() {
    Slider slider = new Slider(1, 10, 5);
    slider.setShowTickMarks(true);
    slider.setShowTickLabels(true);
    slider.setMinWidth(ObservationApp.WIDTH);
    slider.setMajorTickUnit(1);
    slider.setBlockIncrement(1);
    slider.setMinorTickCount(0);
    slider.setSnapToTicks(true);
    return slider;
  }
  public String getWhaleFromObservation(){
    return data.getWhale();
  }
  public int getNumberFromObservation(){
    return data.getNumber();
  }
}

