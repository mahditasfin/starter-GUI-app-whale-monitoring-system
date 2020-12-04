package guiApp.observation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The observable object.
 */
public class ObservationData {

  public static final int DEFAULT_NUMBER = 5;
  public static final int MAX_NUMBER = 10;
  private static final String DEFAULT_WHALE = "Orca";

  private Map observations;

  private ArrayList<Observer> aObservers = new ArrayList<Observer>();
  private int aNumber = DEFAULT_NUMBER;
  private String aWhale = DEFAULT_WHALE;
  List<String> whaleSpecies = new ArrayList<String>();

  public ObservationData() {
    observations = new HashMap<String, Integer>();
    whaleSpecies.add("Orca");
    whaleSpecies.add("Humpback");
    whaleSpecies.add("Grey");
    whaleSpecies.add("Porpoise");
  }

  public List<String> getWhaleSpecies() {
    return whaleSpecies;
  }
  public Map<String,Integer> getObservations() {
    return observations;
  }

  public void addObserver(Observer pObserver) {
    aObservers.add(pObserver);
  }

  private void notifyObservers() {
    for (Observer observer : aObservers) {
      observer.newObservation(aWhale, aNumber);
    }
  }

  public void addObservation() {
    observations.compute(aWhale, (k, v) -> (v == null) ? aNumber : (Integer)v + aNumber);
    notifyObservers();
  }

  public void setNumber(int number) {
    if(number < 1) {
      number = 1;
    } else if(number > MAX_NUMBER) {
      number = MAX_NUMBER;
    }
    aNumber = number;
  }

  public void setWhale(String whale) {
    aWhale = whale;
  }

  public int getNumber() {
    return aNumber;
  }
  public String getWhale() {
    return aWhale;
  }
}