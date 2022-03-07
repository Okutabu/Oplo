package classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Clément
 */
public class ServerCommunication 
{ 
    public String sendGetRequest(String urlIn)
    {
        try
        {
            URL myurl = new URL(urlIn);
            HttpURLConnection httpUrl =(HttpURLConnection)myurl.openConnection();
            httpUrl.setRequestMethod("GET");
            String line = "";
            InputStreamReader reder = new InputStreamReader(httpUrl.getInputStream());
            BufferedReader bufferReader = new BufferedReader(reder);
            
            StringBuilder response = new StringBuilder();
            
            while((line = bufferReader.readLine()) != null)
            {
                response.append(line);
            }
            bufferReader.close();
            
            return response.toString().trim();
        }
        catch(Exception e)
        {
            return "Error while making http GET request on " + urlIn;
        }
    }
    
    public String sendPostRequest(String urlIn, String param)
    {
         try
         {
            URL myurl = new URL(urlIn);
            HttpURLConnection httpUrl =(HttpURLConnection)myurl.openConnection();
            httpUrl.setRequestMethod("POST");
            httpUrl.setDoOutput(true);
            
            OutputStream output = httpUrl.getOutputStream();
            output.write(param.getBytes("utf8"));
            output.flush();
            output.close();
            
            String line;
            InputStreamReader rder = new InputStreamReader(httpUrl.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(rder);
            
            StringBuilder response = new StringBuilder();
            
            while((line = bufferedReader.readLine()) != null)
            {
                response.append(line);
            }
            bufferedReader.close();
            
            return response.toString().trim();
        }
        catch(Exception e)
        {
            return "Error while making http POST request on " + urlIn;
        }
    }
}
