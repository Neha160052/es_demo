package tv.videoready.api.dto;

import tv.videoready.api.controller.SampleController;

/**
 * The {@link SampleResponseDTO} is sample DTO.
 *
 * @author Vikram Jakhar
 * @see SampleController
 */
public class SampleResponseDTO {

    private String str1;
    private boolean flag;

    public SampleResponseDTO() {
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SampleResponseDTO{" +
                "str1='" + str1 + '\'' +
                ", flag=" + flag +
                '}';
    }
}
