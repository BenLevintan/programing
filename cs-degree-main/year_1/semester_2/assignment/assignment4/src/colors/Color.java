// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package colors;
/**
 * The Color enum represents different colors with their RGB values.
 */
public enum Color {
    /**
     * The fields are the representation of a color RGB values (red, green, blue).
     */
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0);

    private int red;
    private int green;
    private int blue;

    /**
     * Constructs a Color enum constant with RGB values.
     * @param red   the red component value (0-255)
     * @param green the green component value (0-255)
     * @param blue  the blue component value (0-255)
     */
    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Getters for each color component in RGB
     */

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
