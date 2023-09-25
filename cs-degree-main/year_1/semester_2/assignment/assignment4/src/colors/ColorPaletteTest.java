// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package colors;

/**
 * The ColorPaletteTest class is a test class for the ColorPalette class. It demonstrates the usage
 * of the ColorPalette to retrieve RGB values for colors in the palette.
 */
public class ColorPaletteTest {

    /**
     * The main method is the entry point of the ColorPaletteTest application.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.WHITE, Color.BLACK};
        ColorPalette palette = new ColorPalette(colors);

        for (Color color : colors) {
            int red = palette.getColorByName(color.name()).getRed();
            int green = palette.getColorByName(color.name()).getGreen();
            int blue = palette.getColorByName(color.name()).getBlue();

            System.out.println("Color: " + color.name());
            System.out.println("RGB values: (" + red + ", " + green + ", " + blue + ")\n");
        }
    }
}
