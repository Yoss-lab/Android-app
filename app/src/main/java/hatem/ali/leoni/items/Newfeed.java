package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Newfeed {


    @SerializedName("id_act")
    @Expose
    private String id_act;

    @SerializedName("image_text")
    @Expose
    private String image_text;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("dat")
    @Expose
    private String dat;


    public String getId_act() {
        return id_act;
    }

    public void setId_act(String id_act) {
        this.id_act = id_act;
    }

    public String getText_act() {
        return image_text;
    }

    public void setText_act(String text_act) {
        this.image_text = text_act;
    }

    public Newfeed(String id_act, String text_act) {
        this.id_act = id_act;
        this.image_text = text_act;
    }

    public String getImage_text() {
        return image_text;
    }

    public void setImage_text(String image_text) {
        this.image_text = image_text;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public Newfeed(String id_act, String image_text, String image) {
        this.id_act = id_act;
        this.image_text = image_text;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Newfeed{" +
                "id_act='" + id_act + '\'' +
                ", text_act='" + image_text + '\'' +
                '}';
    }
}