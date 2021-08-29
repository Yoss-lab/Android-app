package hatem.ali.leoni.items;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("id_event")
    @Expose
    private String id_event;

    @SerializedName("title_event")
    @Expose
    private String title_event;

    @SerializedName("text_event")
    @Expose
    private String text_event;

    @SerializedName("image_event")
    @Expose
    private String image_event;

    public Event(String id_event, String title_event, String text_event) {
        this.id_event = id_event;
        this.title_event = title_event;
        this.text_event = text_event;
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getTitle_event() {
        return title_event;
    }

    public void setTitle_event(String title_event) {
        this.title_event = title_event;
    }

    public String getText_event() {
        return text_event;
    }

    public void setText_event(String text_event) {
        this.text_event = text_event;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id_event='" + id_event + '\'' +
                ", title_event='" + title_event + '\'' +
                ", text_event='" + text_event + '\'' +
                '}';
    }
}
