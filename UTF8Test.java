import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UTF8Test {
    public static void main(String[] args) {
        String string = "";
        String path = "";
        
        // open a file for testing
        try{
        	path = UTF8Test.class.getResource("").getPath();        	     	
        	BufferedReader in = new BufferedReader(new FileReader(path + "test_utf.txt"));
        	
        	string = in.readLine();
        	
        	in.close();        	        	
        	
        } catch(IOException e) {
        	System.err.println(e);
        	System.exit(1);
        }
        
        // call removeEmoji() method
        string = RemoveEmojiFromString.removeEmoji(string, RemoveEmojiFromString.REMOVE);
    }
}