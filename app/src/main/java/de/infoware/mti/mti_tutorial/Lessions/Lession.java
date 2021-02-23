package de.infoware.mti.mti_tutorial.Lessions;

/**
 * This abstract class is the template for all lessions
 */
public abstract class Lession  {
    private int functionId;
    private String buttonCaption;

    public Lession(int functionId, String buttonCaption) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
    }

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }
}