import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveEmojiFromString {

	public final static int REMOVE = 0;
	public final static int REPLACE = 1;
		
	public static String removeEmoji(String source, int optType) {
		String utf8tweet = "";
		String replaceType;
		
		if(optType == REPLACE)
			replaceType = " ";
		else
			replaceType = "";			
		
        try {
            byte[] utf8Bytes = source.getBytes("UTF-8");
            utf8tweet = new String(utf8Bytes, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        Pattern unicodeOutliers = Pattern.compile("[^\\x00-\\x7F]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(utf8tweet);

        System.out.println("Before: " + utf8tweet);
        utf8tweet = unicodeOutlierMatcher.replaceAll(replaceType);
        System.out.println("After: " + utf8tweet);		
				
		return utf8tweet;
	}	
}
