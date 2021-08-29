package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stage {

    @SerializedName("id_stage")
    @Expose
    private int id_stage;

    @SerializedName("title_stage")
    @Expose
    private String title_stage;
    @SerializedName("desc_stage")
    @Expose
    private String desc_stage;

    @SerializedName("annonce_de")
    @Expose
    private String annonce_de;

    @SerializedName("image_stage")
    @Expose
    private String image_stage;

    public Stage(int id_stage, String title_stage, String desc_stage, String annonce_de) {
        this.id_stage = id_stage;
        this.title_stage = title_stage;
        this.desc_stage = desc_stage;
        this.annonce_de = annonce_de;
    }

    public int getId_stage() {
        return id_stage;
    }

    public void setId_stage(int id_stage) {
        this.id_stage = id_stage;
    }

    public String getTitle_stage() {
        return title_stage;
    }

    public void setTitle_stage(String title_stage) {
        this.title_stage = title_stage;
    }

    public String getDesc_stage() {
        return desc_stage;
    }

    public void setDesc_stage(String desc_stage) {
        this.desc_stage = desc_stage;
    }

    public String getAnnonce_de() {
        return annonce_de;
    }

    public void setAnnonce_de(String annonce_de) {
        this.annonce_de = annonce_de;
    }

    public String getImage_stage() {
        return image_stage;
    }

    public void setImage_stage(String image_stage) {
        this.image_stage = image_stage;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id_stage='" + id_stage + '\'' +
                ", title_stage='" + title_stage + '\'' +
                ", desc_stage='" + desc_stage + '\'' +
                ", annonce_de='" + annonce_de + '\'' +
                '}';
    }
}
