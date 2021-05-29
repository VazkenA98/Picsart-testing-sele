package enums;

public enum EditorTypes {
    /*
    Templates
     */
    INSTA_STORY_TEMP("templateSize=insta_story"),
    FACEBOOK_AD_TEMP("templateSize=fb_ad");

    private final String typeUrl;

    EditorTypes(String chooserUrl) {
        this.typeUrl = chooserUrl;
    }

    public String getChooserUrl() {
        return typeUrl;
    }
}
