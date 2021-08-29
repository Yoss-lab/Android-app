package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conge {

    @SerializedName("idConge")
    @Expose
    private int idConge;

    @SerializedName("idEmploye")
    @Expose
    private String idEmploye;

    @SerializedName("nomEmploye")
    @Expose
    private String nomEmploye;

    @SerializedName("prenomEmplye")
    @Expose
    private String prenomEmploye;

    @SerializedName("typeConge")
    @Expose
    private String typeConge;

    @SerializedName("dateDebut")
    @Expose
    private String dateDebut;

    @SerializedName("dateFin")
    @Expose
    private String dateFin;

    @SerializedName("causeConge")
    @Expose
    private String causeConge;

    @SerializedName("statut")
    @Expose
    private String statut;



    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @SerializedName("success")
    @Expose
    private boolean success;

    Conge conge;

    public int getIdConge() {
        return idConge;
    }

    public void setIdConge(int idConge) {
        this.idConge = idConge;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getTypeConge() {
        return typeConge;
    }

    public void setTypeConge(String typeConge) {
        this.typeConge = typeConge;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getCauseConge() {
        return causeConge;
    }

    public void setCauseConge(String causeConge) {
        this.causeConge = causeConge;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Conge getConge() {
        return conge;
    }

    public void setConge(Conge conge) {
        this.conge = conge;
    }

    public Conge(int idConge, String idEmploye, String nomEmploye, String prenomEmploye, String typeConge, String dateDebut, String dateFin, String causeConge,String statut, boolean success, Conge conge) {
        this.idConge = idConge;
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.typeConge = typeConge;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.causeConge = causeConge;
        this.statut=statut;
        this.success = success;
        this.conge = conge;
    }

    public Conge(int idConge, String idEmploye, String nomEmploye, String prenomEmploye, String typeConge, String dateDebut, String dateFin, String causeConge,String statut) {
        this.idConge = idConge;
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.typeConge = typeConge;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.causeConge = causeConge;
        this.statut=statut;
    }

    public Conge(String typeConge, String causeConge, String statut) {
        this.typeConge = typeConge;
        this.causeConge = causeConge;
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Conge{" +
                "idConge=" + idConge +
                ", idEmploye='" + idEmploye + '\'' +
                ", nomEmploye='" + nomEmploye + '\'' +
                ", prenomEmploye='" + prenomEmploye + '\'' +
                ", typeConge='" + typeConge + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", causeConge='" + causeConge + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
