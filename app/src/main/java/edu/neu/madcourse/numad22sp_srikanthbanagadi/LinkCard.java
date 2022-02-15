package edu.neu.madcourse.numad22sp_srikanthbanagadi;

public class LinkCard implements ILinkListener {

    private final String url;

    public LinkCard(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void onItemClick(int position) {

    }
}
