import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TollCalculator {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            // Load interchanges data from JSON file
            // Object obj = parser.parse(new FileReader("interchanges.json"));

            // JSONObject jsonObject = (JSONObject) obj;
            Object obj = parser.parse(new FileReader("interchanges.json"));
            JSONArray interchanges = new JSONArray();
            interchanges.add(obj);
            // JSONArray interchanges = (JSONArray) parser.parse(new FileReader("interchanges.json"));
            // Get starting and ending interchanges from user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter starting interchange: ");
            String startingInterchange = scanner.nextLine().toUpperCase();
            System.out.print("Enter ending interchange: ");
            String endingInterchange = scanner.nextLine().toUpperCase();

            // Calculate total distance between interchanges
            double totalDistance = 0;
            boolean foundStartingInterchange = false;
            for (Object interchangeObj : interchanges) {
                JSONObject interchange = (JSONObject) interchangeObj;
                // if (interchange.get("name").equals(startingInterchange)) {
                //     foundStartingInterchange = true;
                // } else if (interchange.get("name").equals(endingInterchange)) {
                //     totalDistance += Double.parseDouble((String) interchange.get("distance"));
                //     break;
                // }
                // if (foundStartingInterchange) {
                //     totalDistance += Double.parseDouble((String) interchange.get("distance"));
                // }

                if (interchange.containsKey("name") && interchange.get("name") != null 
                && interchange.get("name").equals(startingInterchange)){
                    foundStartingInterchange = true;
                }
                else if (interchange.containsKey("name") && interchange.get("name") != null 
                    && interchange.get("name").equals(endingInterchange)) {
                totalDistance += ((Number) interchange.get("distance")).doubleValue();
                // totalDistance += Double.parseDouble((String) interchange.get("distance"));
                System.out.println(totalDistance);
                break;
            }
        }

            // Calculate toll
            double toll = totalDistance * 0.25;
            System.out.println("Toll cost: $" + toll);
        }

         catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}