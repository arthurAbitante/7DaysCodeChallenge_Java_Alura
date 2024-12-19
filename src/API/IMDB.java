package API;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class IMDB {
		
	private static final String API_KEY = "dfe5831316419e036ead45de1a29450e";
	private static final String BASE_URL = "https://api.themoviedb.org/3";
	
	public static void main(String[] args) {
		
		try {
			String endpoint = "/movie/popular";
			String urlString = BASE_URL + endpoint + "?api_key=" + API_KEY;
			
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code: "+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder response = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				response.append(line);
			}
			System.out.println(response);
			conn.disconnect();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}