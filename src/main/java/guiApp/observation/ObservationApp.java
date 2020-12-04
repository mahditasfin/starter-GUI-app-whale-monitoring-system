package guiApp.observation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ObservationApp extends Application{

  public static final int WIDTH = 200;

  private static final int GAP = 10;
  private static final int MARGIN = 20;

  /**
   * Launches the application.
   * @param pArgs This program takes no argument.
   */
  public static void main(String[] pArgs)
  {
    launch(pArgs);
  }

  @Override
  public void start(Stage pPrimaryStage)
  {
    ObservationData data = new ObservationData();

    GridPane root = createPane(); // The root of the GUI component graph
    root.add(new ObservationChartPanel(data), 0, 0, 1, 1);
    root.add(new InputObservationPanel(data), 0, 1, 1, 1);
    root.add(new SpeciesListPanel(data), 1, 1, 1, 1);
    root.add(new SubmitButtonBox(data), 0, 2, 1, 1);
    root.add(new LastUpdatePanel(data), 1, 0, 1, 1);

    pPrimaryStage.setTitle("Observation App");
    pPrimaryStage.setResizable(true);
    pPrimaryStage.setScene(new Scene(root));
    pPrimaryStage.show();
  }

  /*
   * Helper method to hid the details of creating
   * a nice looking grid.
   */
  private static GridPane createPane()
  {
    GridPane root = new GridPane();
    root.setHgap(GAP);
    root.setVgap(GAP);
    root.setPadding(new Insets(MARGIN));
    return root;
  }
}