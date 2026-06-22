import java.util.ArrayList;
import java.util.Scanner;

class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    public Video(String name) {
        videoName = name;
        checkout = false;
        rating = 0;
    }

    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        checkout = true;
    }

    public void doReturn() {
        checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }
}

class VideoStore {
    private ArrayList<Video> store = new ArrayList<>();

    public void addVideo(String name) {
        store.add(new Video(name));
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    public void doCheckout(String name) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void doReturn(String name) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void receiveRating(String name, int rating) {
        for (Video v : store) {
            if (v.getName().equalsIgnoreCase(name)) {
                v.receiveRating(rating);
                System.out.println("Rating \"" + rating +
                        "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void listInventory() {
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s\n",
                "Video Name", "Checkout Status", "Rating");
        System.out.println("----------------------------------------------------------");

        for (Video v : store) {
            System.out.printf("%-20s %-20s %-10d\n",
                    v.getName(),
                    v.getCheckout(),
                    v.getRating());
        }

        System.out.println("----------------------------------------------------------");
    }
}

public class VideoLauncher {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VideoStore store = new VideoStore();

        int choice;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("==========");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1..6): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    String addVideo = sc.nextLine();
                    store.addVideo(addVideo);
                    break;

                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    String checkoutVideo = sc.nextLine();
                    store.doCheckout(checkoutVideo);
                    break;

                case 3:
                    System.out.print("Enter the name of the video you want to return: ");
                    String returnVideo = sc.nextLine();
                    store.doReturn(returnVideo);
                    break;

                case 4:
                    System.out.print("Enter the name of the video you want to rate: ");
                    String rateVideo = sc.nextLine();

                    System.out.print("Enter the rating for this video: ");
                    int rating = sc.nextInt();
                    sc.nextLine();

                    store.receiveRating(rateVideo, rating);
                    break;

                case 5:
                    store.listInventory();
                    break;

                case 6:
                    System.out.println("Exiting...!!! Thanks for using the application.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
