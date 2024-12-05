import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_Example {
    public static String getRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder answer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            answer.append(line);
        }
        reader.close();
        return answer.toString();
    }

    public static void parseUsers(String answer) {
        try {
            JSONArray users = new JSONArray(answer);
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                System.out.println("ID: " + user.getInt("id"));
                System.out.println("Name: " + user.getString("name"));
                System.out.println("Company: " + user.getString("company"));
                System.out.println("Username: " + user.getString("username"));
                System.out.println("Email: " + user.getString("email"));
                System.out.println("Address: " + user.getString("address"));
                System.out.println("Zip: " + user.getString("zip"));
                System.out.println("State: " + user.getString("state"));
                System.out.println("Country: " + user.getString("country"));
                System.out.println("Phone: " + user.getString("phone"));
                System.out.println("Photo: " + user.getString("photo"));
                System.out.println("------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error parsing users: " + e.getMessage());
        }
    }

    public static void parseTodos(String answer) {
        try {
            JSONArray todos = new JSONArray(answer);
            for (int i = 0; i < todos.length(); i++) {
                JSONObject todo = todos.getJSONObject(i);
                System.out.println("User ID: " + todo.getInt("userId"));
                System.out.println("ID: " + todo.getInt("id"));
                System.out.println("Title: " + todo.getString("title"));
                System.out.println("Status: " + todo.getBoolean("completed"));
                System.out.println("----------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error parsing todos: " + e.getMessage());
        }
    }
}