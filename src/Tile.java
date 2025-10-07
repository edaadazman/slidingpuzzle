public class Tile extends Piece {
    private final boolean isBlank;

    public Tile(int value) {
        super(value);
        this.isBlank = (value == 0);
    }

    public boolean isBlank() {
        return isBlank;
    }

    @Override
    public boolean canMoveTo(Piece target) {
        // A tile can move to a position if the target is a blank tile
        return target instanceof Tile && ((Tile) target).isBlank();
    }

    @Override
    public String getDisplayString() {
        if (isBlank) {
            return " ";
        }
        return String.valueOf(value);
    }

    public static Tile createNumberedTile(int number) {
        return new Tile(number);
    }

    public static Tile createBlankTile() {
        return new Tile(0);
    }

    @Override
    public String toString() {
        if (isBlank) {
            return "[ ]";
        }
        return "[" + value + "]";
    }
}