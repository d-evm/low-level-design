// Existing system/tool that only works with JSON input
class JSONAnalyticsTool {
    private String jsonData;

    JSONAnalyticsTool(String input) {
        this.jsonData = input;
    }

    // Method that analyses JSON data
    public void analyseData() {
        if (jsonData.contains("{") && jsonData.contains("}")) {
            System.out.println("Analysing JSON data: " + jsonData);
        } else {
            System.out.println("[ERROR] Invalid JSON format.");
        }
    }
}

// Target Interface - defines how the client wants to interact
interface DataAnalyzer {
    void analyseData();
}

// Class Adapter - extends JSONAnalyticsTool AND implements DataAnalyzer
class XMLtoJSONClassAdapter extends JSONAnalyticsTool implements DataAnalyzer {

    public XMLtoJSONClassAdapter(String xmlData) {
        // Convert XML to JSON before passing to parent constructor
        super(convertXMLtoJSON(xmlData));
    }

    // Mock conversion logic (in real case: use a parser)
    private static String convertXMLtoJSON(String xml) {
        System.out.println("Converting XML data to JSON: " + xml);
        return "{ \"data\": \"" + xml + "\" }";
    }

    // No need to override analyseData(), parent already has it
    // but we can if we want to add extra behavior
    @Override
    public void analyseData() {
        super.analyseData();
    }
}

// Client code
public class XmlToJson {
    public static void main(String[] args) {
        String xmlData = "<data>Some random data</data>";

        // Case 1: Direct use of JSONAnalyticsTool with valid JSON
        JSONAnalyticsTool jsonAnalyticsTool = new JSONAnalyticsTool("{ \"data\": \"Valid JSON data\" }");
        jsonAnalyticsTool.analyseData();

        System.out.println("-------------------------------");

        // Case 2: Passing XML directly → fails
        jsonAnalyticsTool = new JSONAnalyticsTool(xmlData);
        jsonAnalyticsTool.analyseData();

        System.out.println("-------------------------------");

        // Case 3: Using Class Adapter to make XML compatible
        DataAnalyzer adapter = new XMLtoJSONClassAdapter(xmlData);
        adapter.analyseData();
    }
}
