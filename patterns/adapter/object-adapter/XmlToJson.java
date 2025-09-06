// Existing system/tool that only works with JSON input
class JSONAnalyticsTool {
    final private String jsonData;

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

// Adapter class - converts XML input into JSON so that JSONAnalyticsTool can be used
class XMLtoJSONAdapter implements DataAnalyzer {
    final private JSONAnalyticsTool analyticsTool;

    public XMLtoJSONAdapter(String xmlData) {
        // Simulate conversion of XML → JSON
        System.out.println("Converting XML data to JSON: " + xmlData);
        String convertedData = convertXMLtoJSON(xmlData);

        // Pass converted data to the existing JSONAnalyticsTool
        this.analyticsTool = new JSONAnalyticsTool(convertedData);
    }

    // Mock conversion logic (in real case: use a parser)
    private String convertXMLtoJSON(String xml) {
        return "{ \"data\": \"" + xml + "\" }"; // Wraps XML as JSON
    }

    @Override
    public void analyseData() {
        analyticsTool.analyseData(); // Delegate call
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

        // Case 2: Passing XML directly → fails (tool only understands JSON)
        jsonAnalyticsTool = new JSONAnalyticsTool(xmlData);
        jsonAnalyticsTool.analyseData();

        System.out.println("-------------------------------");

        // Case 3: Using Adapter to make XML compatible with JSONAnalyticsTool
        DataAnalyzer adapter = new XMLtoJSONAdapter(xmlData);
        adapter.analyseData();
    }
}
