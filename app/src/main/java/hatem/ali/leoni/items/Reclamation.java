package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reclamation {

    @SerializedName("commantaire")
    @Expose
    private String commantaire;


    @SerializedName("success")
    @Expose
    private boolean success;

    Reclamation reclamation;

    public String getCommantaire() {
        return commantaire;
    }

    public void setCommantaire(String commantaire) {
        this.commantaire = commantaire;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }

    public Reclamation(String commantaire, boolean success, Reclamation reclamation) {
        this.commantaire = commantaire;
        this.success = success;
        this.reclamation = reclamation;
    }
}
