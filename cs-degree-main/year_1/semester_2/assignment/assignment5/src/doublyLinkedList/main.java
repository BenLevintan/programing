// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package doublyLinkedList;
import java.util.Scanner;

/**
 * The main class that demonstrates the functionality of the DoublyLinkedList class.
 */
public class main {
    private static DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    /**
     * Enum representing the menu options.
     */
    private enum Menu {
        ADD_FIRST("Add element to the front of the list"),
        ADD_LAST("Add element to the end of the list"),
        REMOVE("Remove element from the list"),
        DISPLAY_FORWARD("Print the list in forward order"),
        DISPLAY_BACKWARD("Print the list in backward order"),
        EXIT("End");

        private final String description;

        Menu(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * The main method that runs the program and interacts with the user.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu choice;
        do {
            displayMenu();
            System.out.print("Please enter a menu entry: ");
            choice = getMenuChoice(scanner);

            switch (choice) {
                case ADD_FIRST:
                    int firstElement = readInteger(scanner, "Enter an element you want to add to the start: ");
                    list.addFirst(firstElement);
                    break;
                case ADD_LAST:
                    int lastElement = readInteger(scanner, "Enter an element you want to add to the end: ");
                    list.addLast(lastElement);
                    break;
                case REMOVE:
                    int elementToRemove = readInteger(scanner, "Enter an element to remove: ");
                    Integer removedElement = list.remove(elementToRemove);
                    if (removedElement != null) {
                        System.out.println("Removed element: " + removedElement);
                    } else {
                        System.out.println("Element was not found in the list.");
                    }
                    break;
                case DISPLAY_FORWARD:
                    System.out.println("List in forward order:");
                    list.printForward();
                    break;
                case DISPLAY_BACKWARD:
                    System.out.println("List in backward order:");
                    list.printBackward();
                    break;
                case EXIT:
                    System.out.println("Exiting the program, thanks for using it :)");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != Menu.EXIT);
    }
    /**
     * Method prints out the menu
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        for (Menu option : Menu.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option.getDescription());
        }
    }
    /**
     * Method gets an input from the user
     */
    private static Menu getMenuChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= Menu.values().length) {
                    break;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Invalid choice. Please enter a valid menu number: ");
        }
        return Menu.values()[choice - 1];
    }

    /**
     * Method checks user input
     */
    private static int readInteger(Scanner scanner, String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return value;
    }
}
