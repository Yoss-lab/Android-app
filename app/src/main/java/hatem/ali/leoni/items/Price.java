package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    //if desplay image from internet can using String variable

   /* private int image;
    private String title;
    private String subtitle;
    private String description;*/

    @SerializedName("id_prix")
    @Expose
    private String id_prix;

    @SerializedName("title_prix")
    @Expose
    private String title_prix;

    @SerializedName("subtitle_prix")
    @Expose
    private String subtitle_prix;

    @SerializedName("text_prix")
    @Expose
    private String text_prix;

    @SerializedName("image_prix")
    @Expose
    private String image_prix;


    public Price(String id_prix, String title_prix, String subtitle_prix, String text_prix) {
        this.id_prix = id_prix;
        this.title_prix = title_prix;
        this.subtitle_prix = subtitle_prix;
        this.text_prix = text_prix;
    }

    public String getId_prix() {
        return id_prix;
    }

    public void setId_prix(String id_prix) {
        this.id_prix = id_prix;
    }

    public String getTitle_prix() {
        return title_prix;
    }

    public void setTitle_prix(String title_prix) {
        this.title_prix = title_prix;
    }

    public String getSubtitle_prix() {
        return subtitle_prix;
    }

    public void setSubtitle_prix(String subtitle_prix) {
        this.subtitle_prix = subtitle_prix;
    }

    public String getText_prix() {
        return text_prix;
    }

    public void setText_prix(String text_prix) {
        this.text_prix = text_prix;
    }

    public String getImage_prix() {
        return image_prix;
    }

    public void setImage_prix(String image_prix) {
        this.image_prix = image_prix;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id_prix='" + id_prix + '\'' +
                ", title_prix='" + title_prix + '\'' +
                ", subtitle_prix='" + subtitle_prix + '\'' +
                ", text_prix='" + text_prix + '\'' +
                '}';
    }
}
