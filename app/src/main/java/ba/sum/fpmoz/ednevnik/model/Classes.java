package ba.sum.fpmoz.ednevnik.model;

public class Classes {
    public String uid;
    public String name;

    public Classes() {
    }

    public Classes(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
