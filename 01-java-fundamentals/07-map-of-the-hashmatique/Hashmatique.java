import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
    // Add in at least 4 songs that are stored by title
    HashMap<String, String> songListMap = new HashMap<String, String>();
    songListMap.put("Seven Years" ,"Once I was seven years old, my mama told me");
    songListMap.put("Imagine" ,"Imagine there's no heaven It's easy if you try");
    songListMap.put("Breathe" ,"I can feel the magic floating in the air");
    songListMap.put("Piano Man" ,"It's nine o'clock on a Saturday");
    //pull out one song by its title
    System.out.println("Pull out one song by its title:");
    String oneSong = songListMap.get("Imagine");
    System.out.println(oneSong);
    //Print out all the track names and lyrics in the format Track: Lyrics
    
    Set<String> keys = songListMap.keySet();
    for (String key: keys) {
        System.out.println("Track: "+key+" || Lyrics: " +songListMap.get(key));
    }
}
}
