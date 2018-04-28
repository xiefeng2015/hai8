package com.wesai;

public class AppBaseTest extends BackgroundBaseTest {
    public static String issueId;
    public static String mPlayingCode;
    public String playingCode;

    public AppBaseTest(){}

    public AppBaseTest(String playingCode) {
        super.setPlayingCode(playingCode);
        mPlayingCode = getPlayingCode();
    }
}
