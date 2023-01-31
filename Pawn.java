public class Pawn extends Piece{
    public Pawn(int x, int y, Side side, Board board) {
        super(x, y, side, board);
    }
    @Override
    public boolean canMove(int destX, int destY) {
        if (x != 0 && x != 6) {
            if (board.get(x, y).getSide() == Side.BLACK && this.y == 1 && (destX != x + 1 || destX != x - 1)) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.WHITE && this.y == 6 && (destX != x + 1 || destX != x - 1)) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.BLACK && ((destX == x + 1 || destX == x - 1) && destY == y + 1) && board.get(destX, destY) != null) {
                return board.get(destX, destY).getSide() != board.get(x, y).getSide();
            }
            if (board.get(x, y).getSide() == Side.WHITE && ((destX == x + 1 || destX == x - 1) && destY == y - 1) && board.get(destX, destY) != null) {
                return board.get(destX, destY).getSide() != board.get(x, y).getSide();
            }
        }
        if (x == 0) {
            if (board.get(x, y).getSide() == Side.BLACK && this.y == 1 && destX != x + 1 && destY != y + 1) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.WHITE && this.y == 6 && destX != x + 1 && destY != y - 1) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.BLACK && (destX == x + 1 && destY == y + 1) && board.get(destX, destY) != null) {
                return board.get(destX, destY).getSide() != board.get(x, y).getSide();
            }
        }
        if (board.get(x, y).getSide() == Side.WHITE && (destX == x + 1 && destY == y - 1) && board.get(destX, destY) != null) {
            return board.get(destX, destY).getSide() != board.get(x, y).getSide();
        }
        if (x == 6) {
            if (board.get(x, y).getSide() == Side.BLACK && this.y == 1 && destX != x - 1 && destY != y + 1) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.WHITE && this.y == 6 && destX != x - 1 && destY != y - 1) {
                if (board.get(destX, destY) == null) {
                    return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 2);
                } else {
                    return false;
                }
            }
            if (board.get(x, y).getSide() == Side.BLACK && (destX == x - 1 && destY == y + 1) && board.get(destX, destY) != null) {
                return board.get(destX, destY).getSide() != board.get(x, y).getSide();
            }
            if (board.get(x, y).getSide() == Side.WHITE && (destX == x - 1 && destY == y - 1) && board.get(destX, destY) != null) {
                return board.get(destX, destY).getSide() != board.get(x, y).getSide();
            }
        }

        if (board.get(destX,destY) == null && board.get(x,y) != null) {
            return (Math.abs(this.x - destX) == 0 && Math.abs(this.y - destY) <= 1);
        } else {
            return false;
        }
    }
    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ? "♟" : "♙";
    }
}
