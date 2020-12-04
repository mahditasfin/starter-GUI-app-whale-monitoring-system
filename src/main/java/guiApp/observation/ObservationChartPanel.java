package guiApp.observation;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

import java.util.Map;

/**
 * A BarChart showing whale counts per Observation
 * see https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/chart/BarChart.html
 */
public class ObservationChartPanel extends HBox implements Observer {
  private ObservationData data;
  XYChart.Series series1;

  final NumberAxis xAxis = new NumberAxis();
  final CategoryAxis yAxis = new CategoryAxis();
  final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);

  public ObservationChartPanel(ObservationData pData) {
    data = pData;
    data.addObserver(this);
    bc.setTitle("Observation Summary");

    xAxis.setLabel("Count");
    xAxis.setTickLabelRotation(90);
    yAxis.setLabel("Species");
    yAxis.setAnimated(false);
    xAxis.setAnimated(true);

    series1 = new XYChart.Series();
    series1.setName("Observations Day 1");

    initializeChart();

    bc.getData().add(series1);
    getChildren().add(bc);
  }
  public void newObservation(String aWhale, int aNumber) {
    updateChart();
  }

  private void updateChart() {
    Map<String,Integer> observations = data.getObservations();
    for (Map.Entry<String, Integer> entry : observations.entrySet()) {
      series1.getData().add(new XYChart.Data(entry.getValue(), entry.getKey()));
    }
  }

  private void initializeChart() {
    for (String species : data.getWhaleSpecies()) {
      series1.getData().add(new XYChart.Data(0, species));
    }
  }
  public String getWhale(){
    return data.getWhale();
  }
  public int getNumber(){
    return data.getNumber();
  }
}
