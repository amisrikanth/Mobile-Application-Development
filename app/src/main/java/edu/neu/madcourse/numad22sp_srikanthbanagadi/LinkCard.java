package edu.neu.madcourse.numad22sp_srikanthbanagadi;

public class LinkCard implements ILinkListener {

    private final String url;
    private final String urlName;

    public LinkCard(String url, String urlName) {
        this.url = url;
        this.urlName = urlName;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlName() {
        return urlName;
    }

    @Override
    public void onItemClick(int position) {

    }
}
