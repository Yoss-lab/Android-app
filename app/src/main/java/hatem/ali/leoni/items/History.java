package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History {

    @SerializedName("id_hist")
    @Expose
    private String id_hist;
    @SerializedName("annee_hist")
    @Expose
    private String annee_hist;
    @SerializedName("text_hist")
    @Expose
    private String text_hist;

    @SerializedName("image_hist")
    @Expose
    private String image_hist;

    public String getImage_hist() {
        return image_hist;
    }

    public void setImage_hist(String image_hist) {
        this.image_hist = image_hist;
    }

    public String getId_hist() {
        return id_hist;
    }

    public void setId_hist(String id_hist) {
        this.id_hist = id_hist;
    }

    public String getAnnee_hist() {
        return annee_hist;
    }

    public void setAnnee_hist(String annee_hist) {
        this.annee_hist = annee_hist;
    }

    public String getText_hist() {
        return text_hist;
    }

    public void setText_hist(String text_hist) {
        this.text_hist = text_hist;
    }


    @Override
    public String toString() {
        return "History{" +
                "id_hist='" + id_hist + '\'' +
                ", annee_hist='" + annee_hist + '\'' +
                ", text_hist='" + text_hist + '\'' +
                '}';
    }

    public History(String id, String annee, String text) {
        this.id_hist = id;
        this.annee_hist = annee;
        this.text_hist = text;
    }
}
