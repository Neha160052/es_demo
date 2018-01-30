package tv.videoready.api.co;

import tv.videoready.api.controller.SampleController;
import tv.videoready.api.exception.SampleException;

/**
 * The {@link SampleCO} class is sample command object.
 *
 * @author Vikram Jakhar
 * @see SampleController
 */
public class SampleCO {
    /**
     * represents sample string
     */
    private String str1;

    public SampleCO() {
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public void validate() {
        if (this.getStr1() == null || this.getStr1().isEmpty())
            throw new SampleException.SampleError();
    }

    @Override
    public String toString() {
        return "SampleCO{" +
                "str1='" + str1 + '\'' +
                '}';
    }
}
