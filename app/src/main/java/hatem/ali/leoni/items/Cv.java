package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("prenom")
    @Expose
    private String prenom;

    @SerializedName("datnaiss")
    @Expose
    private String datnaiss;


    @SerializedName("ville")
    @Expose
    private String ville;

    @SerializedName("code_post")
    @Expose
    private String code_post;

    @SerializedName("adresse")
    @Expose
    private String adresse;

    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("tel2")
    @Expose
    private String tel2;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("siteWeb")
    @Expose
    private String siteWeb;

    @SerializedName("linkedin")
    @Expose
    private String linkedin;

    @SerializedName("education")
    @Expose
    private String education;

    @SerializedName("competence")
    @Expose
    private String competence;

    @SerializedName("informatique")
    @Expose
    private String informatique;

    @SerializedName("langue")
    @Expose
    private String langue;


    @SerializedName("success")
    @Expose
    private boolean success;

    Cv cv;

  /*  public int getId() {
        return id;
    }*/

   /* public void setId(int id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatnaiss() {
        return datnaiss;
    }

    public void setDatnaiss(String datnaiss) {
        this.datnaiss = datnaiss;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_post() {
        return code_post;
    }

    public void setCode_post(String code_post) {
        this.code_post = code_post;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getInformatique() {
        return informatique;
    }

    public void setInformatique(String informatique) {
        this.informatique = informatique;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Cv(int id, String nom, String prenom, String datnaiss, String ville, String code_post, String adresse, String tel, String tel2, String email, String siteWeb, String linkedin, String education, String competence, String informatique, String langue, boolean success, Cv cv) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datnaiss = datnaiss;
        this.ville = ville;
        this.code_post = code_post;
        this.adresse = adresse;
        this.tel = tel;
        this.tel2 = tel2;
        this.email = email;
        this.siteWeb = siteWeb;
        this.linkedin = linkedin;
        this.education = education;
        this.competence = competence;
        this.informatique = informatique;
        this.langue = langue;
        this.success = success;
        this.cv = cv;
    }

}
