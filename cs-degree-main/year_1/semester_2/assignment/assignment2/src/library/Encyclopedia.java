// Assignment: 2
// Author: Ben Levintan, ID: 318181831

package library;
/**
 * The Encyclopedia class represents an encyclopedia publication.
 * It is a subclass of the Publication class.
 */
public class Encyclopedia extends Publication{

    /**
     * The volume number of the encyclopedia.
     */
    int volume;
    /**
     * The name of the editor of the encyclopedia.
     */
    String editor;

    /**
     * Constructs an Encyclopedia object with the given title, publisher, quantity, editor, and volume number.
     * @param title the title of the encyclopedia
     * @param publisher the publisher of the encyclopedia
     * @param qty the quantity of the encyclopedia
     * @param editor the name of the editor of the encyclopedia
     * @param volume the volume number of the encyclopedia
     */
    Encyclopedia(String title,String publisher, int qty , String editor, int volume){

        super(title,publisher,qty);
        this.editor = editor;
        this.volume = volume;

    }

    /**
     * Returns the volume number of the encyclopedia.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns the name of the editor of the encyclopedia.
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Returns a String representation of the Encyclopedia object.
     */
    @Override
    public String toString() {
        String str = NUMBER +"-Ency\t"+ getTitle() + " vol." + volume + "\n\t\tpublished by " + getPublication() + " edited by ";
        if(editor.equals(""))
            return str + "unknown";
        else
            return str + editor;
    }
}
