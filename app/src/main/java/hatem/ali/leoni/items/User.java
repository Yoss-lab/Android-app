package hatem.ali.leoni.items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pseudo")
    @Expose
    private String pseudo;

    @SerializedName("prenom")
    @Expose
    private String prenom;

    @SerializedName("phone")
    @Expose
    private String phone;


    @SerializedName("adresse")
    @Expose
    private String adresse;

    @SerializedName("code_post")
    @Expose
    private String code_post;

    @SerializedName("ville")
    @Expose
    private String ville;

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("grade")
    @Expose
    private String grade;

    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("langue")
    @Expose
    private String langue;

    @SerializedName("informatique")
    @Expose
    private String informatique;

    @SerializedName("competence")
    @Expose
    private String competence;

    @SerializedName("education")
    @Expose
    private String education;

    @SerializedName("linkedIn")
    @Expose
    private String linkedIn;

    @SerializedName("siteWeb")
    @Expose
    private String siteWeb;


    @SerializedName("datnaiss")
    @Expose
    private String datnaiss;




    @SerializedName("success")
    @Expose
    private int success;

    User user;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_post() {
        return code_post;
    }

    public void setCode_post(String code_post) {
        this.code_post = code_post;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getInformatique() {
        return informatique;
    }

    public void setInformatique(String informatique) {
        this.informatique = informatique;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getDatnaiss() {
        return datnaiss;
    }

    public void setDatnaiss(String datnaiss) {
        this.datnaiss = datnaiss;
    }

    public User(int id, String pseudo, String email,String phone, String password,String position) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.grade = position;

    }

    public User(int id, String pseudo, String prenom, String phone, String position, String adresse, String code_post, String ville, String email, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.phone = phone;
        this.grade = position;
        this.adresse = adresse;
        this.code_post = code_post;
        this.ville = ville;
        this.email = email;
        this.password = password;
    }

   /* public User(int id, String pseudo, String prenom, String phone, String adresse, String code_post, String ville, String email,  String tel, String langue, String informatique, String competence, String education, String linkedIn, String siteWeb, String datnaiss) {
        this.id = id;
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.phone = phone;
        this.adresse = adresse;
        this.code_post = code_post;
        this.ville = ville;
        this.email = email;

        this.tel = tel;
        this.langue = langue;
        this.informatique = informatique;
        this.competence = competence;
        this.education = education;
        this.linkedIn = linkedIn;
        this.siteWeb = siteWeb;
        this.datnaiss = datnaiss;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phone='" + phone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", code_post='" + code_post + '\'' +
                ", ville='" + ville + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                ", tel='" + tel + '\'' +
                ", langue='" + langue + '\'' +
                ", informatique='" + informatique + '\'' +
                ", competence='" + competence + '\'' +
                ", education='" + education + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                ", datnaiss='" + datnaiss + '\'' +
                '}';
    }

    public User(int id, String pseudo, String prenom, String phone, String adresse, String code_post, String ville, String email, String password, String grade, String tel, String langue, String informatique, String competence, String education, String linkedIn, String siteWeb, String datnaiss, int success, User user) {
        this.id = id;
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.phone = phone;
        this.adresse = adresse;
        this.code_post = code_post;
        this.ville = ville;
        this.email = email;
        this.password = password;
        this.grade = grade;
        this.tel = tel;
        this.langue = langue;
        this.informatique = informatique;
        this.competence = competence;
        this.education = education;
        this.linkedIn = linkedIn;
        this.siteWeb = siteWeb;
        this.datnaiss = datnaiss;
        this.success = success;
        this.user = user;
    }

    public User getUser(){
        return user;
}
}
