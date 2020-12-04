package guiApp.observation;

import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class LastUpdatePanel extends HBox implements Observer {
  private static final int ROW_HEIGHT = 24;
  private Text title;
  private Text info;
  private TextFlow fullText;
  private String lastSpecies = "-";
  private int lastNumber = 0;
  private ObservationData data;


  public LastUpdatePanel(ObservationData pData) {
    data = pData;
    data.addObserver(this);
    title = new Text("\n\n\tLast update");
    title.setFont(new Font(18));
    info = new Text("\n\n\tSpecies:  " + lastSpecies + "\n\tNumber: " + lastNumber);
    info.setFont(new Font(14));

    fullText = new TextFlow(title, info);
    fullText.setMinSize(TextFlow.USE_PREF_SIZE, TextFlow.USE_PREF_SIZE);

    getChildren().add(fullText);
  }

  public void newObservation(String aWhale, int aNumber) {
    lastSpecies = aWhale;
    lastNumber = aNumber;
    updateInfo();
  }

  private void updateInfo() {
    info.setText("\n\n\tSpecies:  " + lastSpecies + "\n\tNumber: " + lastNumber);
  }

  public String getWhaleFromUpdate(){
    return data.getWhale();
  }
  public int getNumberFromUpdate(){
    return data.getNumber();
  }

}
