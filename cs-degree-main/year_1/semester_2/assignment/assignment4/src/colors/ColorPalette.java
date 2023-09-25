// Assignment: 4
// Author: Ben Levintan, ID: 318181831

package colors;
/**
 * The ColorPalette class represents a palette of colors.
 */
public class ColorPalette {

    Color[] colors;
    /**
     * Constructs a ColorPalette with the specified array of colors.
     * @param colors the array of colors in the palette
     */
    public ColorPalette(Color[] colors){
        this.colors = colors;
    }
    /**
     * Retrieves a Color object from the palette based on the color name.
     * @param colorName the name of the color to retrieve
     * @return the Color object corresponding to the given color name, or null if not found
     */

    public Color getColorByName(String colorName){

        if(colorName.equals("BLACK"))
            return Color.BLACK;
        else if(colorName.equals("WHITE"))
            return Color.WHITE;
        else if(colorName.equals("BLUE"))
            return Color.BLUE;
        else if(colorName.equals("GREEN"))
            return Color.GREEN;
        else if(colorName.equals("RED"))
            return Color.RED;

        return null;
    }

}
