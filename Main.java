import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {

    static Clip clip;
    static AudioInputStream audioStream;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String musicFilePath = "C:\\NITH\\Java\\Music-Player\\music.wav";
        File file = new File(musicFilePath);

        if (!file.exists()) {
            System.out.println("Music file not found at: " + musicFilePath);
            System.exit(0);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error loading music: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            System.exit(1);
        }

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n\nWelcome to the Music Player!\n");
            System.out.println("1. Play Music");
            System.out.println("2. Pause Music");
            System.out.println("3. Reset Music");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1 -> playMusic();
                case 2 -> pauseMusic();
                case 3 -> resetMusic();
                case 4 -> System.out.println("\nExiting the music player. Goodbye!\n");
                default -> System.out.println("\nInvalid choice. Please select a valid option.\n");
            }
        }

        scanner.close();
        clip.close();
    }

    public static void playMusic() {
        clip.start();
        System.out.println("\nPlaying music...\n");
    }

    public static void pauseMusic() {
        clip.stop();
        System.out.println("\nMusic paused.\n");
    }

    public static void resetMusic() {
        clip.setFramePosition(0);
        clip.start();
        System.out.println("\nMusic reset and playing from the beginning.\n");
    }
}
