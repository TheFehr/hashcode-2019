package hashcode.utils;

/**
 * Parser
 */
public class Parser {
    private String[] lines;

    public Parser(String[] lines) {
        this.lines = lines;
    }

    /**
     * @return the lines
     */
    public String[] getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(String[] lines) {
        this.lines = lines;
    }
}
