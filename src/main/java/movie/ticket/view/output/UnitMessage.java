package movie.ticket.view.output;

public enum UnitMessage {

    SPACE(" "),
    ENTER("\n"),
    DOT("."),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }
}
