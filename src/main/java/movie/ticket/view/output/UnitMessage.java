package movie.ticket.view.output;

public enum UnitMessage {

    SPACE(" "),
    ENTER("\n"),
    DOT("."),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")"),
    SLASH("/"),
    PEOPLE_COUNT("명"),
    WON("원");

    public final String unit;

    UnitMessage(String unit) {
        this.unit = unit;
    }
}
