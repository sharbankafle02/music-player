import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class music_player{
    public static void main(String[] args){
        String filepath="C:\\Users\\Sharban kafle\\.vscode\\Github\\music-player\\Buckle Up - Jeremy Korpas.wav";
        File file=new File(filepath);
        try(Scanner scanner=new Scanner(System.in)){
            AudioInputStream audiostream=AudioSystem.getAudioInputStream(file);
            Clip clip=AudioSystem.getClip();
            clip.open(audiostream);
            String response="";
            while(!response.equals("Q")){
                System.out.println("P->Play");
                System.out.println("S->Stop");
                System.out.println("R->Restart");
                System.out.println("Q->Quite");
                System.out.println("Enter your response: ");
                response=scanner.nextLine().toUpperCase();
                switch(response){
                    case "P"->clip.start();
                    case "S"->clip.stop();
                    case "R"->clip.setMicrosecondPosition(0);
                    case "Q"->clip.close();
                    default->System.out.println("Invalid!! response");
                }
            }
        }
        catch(LineUnavailableException e){
            System.out.println("OOPS!! File in not available");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("File is not supproted");
        }
        catch(FileNotFoundException e){
            System.out.println("OOPS!! file is not found");
        }
        catch(IOException e){
            System.out.println("OOPS!! Some thing went wrong");
        }
    }
}