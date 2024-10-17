package playlistlagu;
import java.util.Scanner;

class Song {
    String title;
    Song next;

    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

class Playlist {
    private Song head;

    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
        System.out.println(title + " ditambahkan ke playlist.");
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Song current = head;
        System.out.println("Daftar lagu di playlist:");
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }
}

public class PlaylistLagu {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Playlist playlist = new Playlist();
        boolean running = true;

        while (running) {
            System.out.println("1. Tambah Lagu ke Playlist");
            System.out.println("2. Tampilkan Playlist");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = Input.nextInt();
            Input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String title = Input.nextLine();
                    playlist.addSong(title);
                    break;
                case 2:
                    playlist.displayPlaylist();
                    break;
                case 3:
                    running = false;
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        }

        Input.close();
    }
}

