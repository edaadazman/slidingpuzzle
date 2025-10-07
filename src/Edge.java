public class Edge extends Piece {
    private boolean claimed;

    public Edge() {
        super(0, null); // Edge has no value, no initial owner
        this.claimed = false;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void claim(String playerName) {
        this.claimed = true;
        setOwner(playerName);
    }

    @Override
    public boolean isEmpty() {
        return !claimed;
    }

    @Override
    public boolean canMoveTo(Piece target) {
        return !claimed; // Can only claim unclaimed edges
    }

    @Override
    public String getDisplayString() {
        return claimed ? "-" : " ";
    }
}