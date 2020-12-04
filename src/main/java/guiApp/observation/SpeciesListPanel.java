package guiApp.observation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class SpeciesListPanel extends HBox {
  private static final int ROW_HEIGHT = 24;
  ListView<String> list = new ListView<String>();
  private ObservationData data;

  SpeciesListPanel(ObservationData pData) {
    data = pData;
    ObservableList<String> items = FXCollections.observableArrayList(data.getWhaleSpecies()); //hmm, we've seen this before
    list.setItems(items);
    list.setPrefHeight(items.size() * ROW_HEIGHT + 2);
    list.getSelectionModel().select(0);

    list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        String cap = newValue.substring(0, 1).toUpperCase() + newValue.substring(1);
        data.setWhale(cap);
      }
    });

    getChildren().add(list);
  }
}
