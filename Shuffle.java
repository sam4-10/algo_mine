import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Shuffle {
    public static void shuffle(List<String> list){
        Set<String> playedList = new HashSet<>();

        Random random = new Random();


       while (true){
           int randomIndex = random.nextInt(list.size());
           System.out.println("index generated: " + randomIndex);
           String song = getNextSong(list.get(randomIndex), playedList);
           if(null != song){
               System.out.println("selected song: " + song);
           }
           if(playedList.size() == list.size()){
               return;

           }
       }

    }

    public static String getNextSong(String selectedSong,Set<String> playedList ){

     if(!playedList.contains(selectedSong)){
         playedList.add(selectedSong);
         return selectedSong;
     }else{
         return null;
     }

    }
    public static void main( String args[] ) {
        shuffle(List.of("you will never walk alone","glory man-utd"));
    }
}
