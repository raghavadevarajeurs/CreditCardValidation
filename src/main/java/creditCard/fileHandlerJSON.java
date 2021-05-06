package creditCard;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class fileHandlerJSON extends fileCategorizer{
    static BufferedReader fileReader = null;
    public static List<creditCardInput> creditCardList = new ArrayList<creditCardInput>();

    public  List<creditCardInput> readFile(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            try {
                //Read JSON file
                fileReader = new BufferedReader(new FileReader(fileName));
                //validateFix(fileReader);
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(reader);
                //System.out.println(obj);
                JSONArray jsonList = (JSONArray) obj;
                // System.out.println(jsonList);


                jsonList.forEach( row -> parseJsonValue( (JSONObject) row) );

            } catch(Exception e) {
                System.out.println("Error in JSon Parser !!! Please check Json Input File");
                e.printStackTrace();
            }
            //jsonObject.put("arrayName",reader);
            return creditCardList;
        }
        catch (Exception e) {
            System.out.println("Error in JsonFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;

    }

    //not being used
    private void validateFix (BufferedReader fileReader) {

        String line;
        try{
            while((line = fileReader.readLine()) != null && line.length() != 0) {
                if(line.contains("CardNumber"))
                {
                    String[] tokens = line.split(":");
                    //System.out.println(line);
                    //System.out.println(tokens[0]);
                    tokens[1] = tokens[1].replace(",", "").trim();
                    if(tokens[1].matches("[A-Za-z0-9-,]+")){
                        System.out.println("--if---");
                        System.out.println(tokens[1]);
                        System.out.println("-----");
                        if(!tokens[1].contains("\"\"")) {
                            System.out.println("Double quote missing for value: "+tokens[1]);
                        }
                    }
                    else {
                        System.out.println("--else---");
                        System.out.println(tokens[1]);
                    }

                }

            }
        }
        catch(Exception e) {
            System.out.println("Error in JSon Parser !!! Please check Json Input File format.");
            e.printStackTrace();
        }

    }

    private  void parseJsonValue(JSONObject row)
    {
        String CardNumber = row.get("CardNumber").toString();
        if(CardNumber == null || CardNumber.trim().isEmpty() || CardNumber.isEmpty()) {
            CardNumber = "";
        }
        System.out.println("CardNumber" +CardNumber);

        String ExpirationDate = row.get("ExpirationDate").toString();
        if(super.isDateValid(ExpirationDate)){
            ExpirationDate = (String) row.get("ExpirationDate").toString();
            //System.out.println(ExpirationDate);
        }
        else {
            System.out.println( ExpirationDate +" -Date format not supported");
            ExpirationDate="Unsupported Date Format";
        }
        String NameOfCardholder = (String) row.get("NameOfCardholder").toString();
        //System.out.println(NameOfCardholder);

        creditCardInput inputRow = new creditCardInput(CardNumber, ExpirationDate, NameOfCardholder);
        creditCardList.add(inputRow);
    }

    public  void writeFile(String fileName, List<creditCardInput> creditCardList)
    {
        try {
            JSONArray ccArr = new JSONArray();
            for( creditCardInput inputRow : creditCardList ) {
                System.out.println(inputRow.toString());
                JSONObject ccObj = new JSONObject();
                ccObj.put("CardNumber", inputRow.getCardNumber() );
                ccObj.put("CardType", inputRow.getCardType());
                ccObj.put("Error", inputRow.getError());
                ccArr.add(ccObj);
            }
            //Write JSON file
            try (FileWriter file = new FileWriter(fileName)) {

                file.write(ccArr.toJSONString().replace("},{", "},\n{"));
                file.write("\n");
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(Exception e) {
            System.out.println("Error in JSon Parser inside Json Writer !!!");
            e.printStackTrace();
        }
    }

}

