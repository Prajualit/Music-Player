import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    static int choice;

    static void displayMenu(int choice) {
        while (choice != 4) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\nWelcome to the Music Player!\n\n");
            System.out.println("1. Play Music");
            System.out.println("2. Pause Music");
            System.out.println("3. Reset Music");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");
            choice = scanner.nextInt();
            scanner.close();
        }
    }

    public static void main(String[] args) {

        // MUSIC PLAYER USING JAVA

        Scanner scanner = new Scanner(System.in);

        displayMenu(choice);

        String musicFilePath = "C:\\NITH\\Java\\Music Player\\music.wav";
        File file = new File(musicFilePath);
        if (!file.exists()) {
            System.out.println("Music file not found at: " + musicFilePath);
            System.exit(0);
        }

        if (choice == 1) {
            playMusic(file);
            displayMenu(choice);
            choice = scanner.nextInt();
        } else if (choice == 2) {
            pauseMusic(file);
            displayMenu(choice);
            choice = scanner.nextInt();
        } else if (choice == 3) {
            resetMusic(file);
            displayMenu(choice);
            choice = scanner.nextInt();
        } else if (choice == 4) {
            System.out.println("\nExiting the music player. Goodbye!\n");
            System.exit(0);
        } else {
            System.out.println("\nInvalid choice. Please select a valid option.\n");
            displayMenu(choice);
            choice = scanner.nextInt();
        }

        scanner.close();
    }

    public static void playMusic(File file) {
        try (AudioInputStream AudioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioStream);
            clip.start();
            System.out.println("\nPlaying music...\n");
        } catch (FileNotFoundException e) {
            System.out.println("Music file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error playing music: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public static void pauseMusic(File file) {
        try (AudioInputStream AudioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioStream);
            clip.stop();
            System.out.println("\nMusic paused.\n");
        } catch (FileNotFoundException e) {
            System.out.println("Music file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error pausing music: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error pausing music: " + e.getMessage());
        }
    }

    public static void resetMusic(File file) {
        try (AudioInputStream AudioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioStream);
            clip.setFramePosition(0); // Reset to the beginning
            clip.start(); // Start playing from the beginning
            System.out.println("\nMusic reset and playing from the beginning.\n");
        } catch (FileNotFoundException e) {
            System.out.println("Music file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error resetting music: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error resetting music: " + e.getMessage());
        }
    }
}