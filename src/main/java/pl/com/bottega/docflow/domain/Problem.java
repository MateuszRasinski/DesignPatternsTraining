package pl.com.bottega.docflow.domain;

public class Problem {
    private String message;
    private boolean critical;

    public Problem(String message, boolean critical) {
        this.message = message;
        this.critical = critical;
    }

    public boolean isCritical() {
        return critical;
    }

    public String getMessage() {
        return message;
    }
}
