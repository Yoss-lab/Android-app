package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Emploi {
    @SerializedName("id_emploi")
    @Expose
    private String id_emploi;
    @SerializedName("title_emploi")
    @Expose
    private String title_emploi;
    @SerializedName("desc_emploi")
    @Expose
    private String desc_emploi;

    @SerializedName("annonce_de")
    @Expose
    private String annonce_de;

    @SerializedName("image_emploi")
    @Expose
    private String image_emploi;

    @SerializedName("dat")
    @Expose
    private String dat;

    public Emploi(String id_emploi, String title_emploi, String desc_emploi, String annonce_de) {
        this.id_emploi = id_emploi;
        this.title_emploi = title_emploi;
        this.desc_emploi = desc_emploi;
        this.annonce_de = annonce_de;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getId_emploi() {
        return id_emploi;
    }

    public void setId_emploi(String id_emploi) {
        this.id_emploi = id_emploi;
    }

    public String getTitle_emploi() {
        return title_emploi;
    }

    public void setTitle_emploi(String title_emploi) {
        this.title_emploi = title_emploi;
    }

    public String getDesc_emploi() {
        return desc_emploi;
    }

    public void setDesc_emploi(String desc_emploi) {
        this.desc_emploi = desc_emploi;
    }

    public String getAnnonce_de() {
        return annonce_de;
    }

    public void setAnnonce_de(String annonce_de) {
        this.annonce_de = annonce_de;
    }

    public String getImage_emploi() {
        return image_emploi;
    }

    public void setImage_emploi(String image_emploi) {
        this.image_emploi = image_emploi;
    }

    @Override
    public String toString() {
        return "Emploi{" +
                "id_emploi='" + id_emploi + '\'' +
                ", title_emploi='" + title_emploi + '\'' +
                ", desc_emploi='" + desc_emploi + '\'' +
                ", annonce_de='" + annonce_de + '\'' +
                '}';
    }
}
