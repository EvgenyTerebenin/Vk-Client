package com.terebenin.vkclient.models.newsItem;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.DaoException;

/**
 * Created by evgeny on 07.02.17.
 */
@Entity(
        // If you have more than one schema, you can tell greenDAO
        // to which schema an entity belongs (pick any string as a name).
//        schema = "myschema",

        // Flag to make an entity "active": Active entities have update,
        // delete, and refresh methods.
        active = true,

        // Specifies the name of the table in the database.
        // By default, the name is based on the entities class name.
        nameInDb = "Photo",

        // Define indexes spanning multiple columns here.
//        indexes = {
//                @Index(value = "name DESC", unique = true)
//        },

        // Flag if the DAO should create the database table (default is true).
        // Set this to false, if you have multiple entities mapping to one table,
        // or the table creation is done outside of greenDAO.
        createInDb = false,

        // Whether an all properties constructor should be generated.
        // A no-args constructor is always required.
        generateConstructors = true,

        // Whether getters and setters for properties should be generated if missing.
        generateGettersSetters = false
)
public class Photo implements Parcelable {
    @Id
    private int id;

    private int album_id;
    private int owner_id;
    private String photo_75;
    private String photo_130;

    @Property(nameInDb = "PHOTO_URL")
    private String photo_604;

    private int width;
    private int height;
    private String text;
    private int date;


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }


    public int getAlbum_id() {
        return album_id;
    }


    public void setAlbum_id(int album_id) {
        this.album_id = album_id;

    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;

    }

    public String getPhoto_75() {
        return photo_75;
    }


    public void setPhoto_75(String photo_75) {
        this.photo_75 = photo_75;

    }


    public String getPhoto_130() {
        return photo_130;

    }


    public void setPhoto_130(String photo_130) {
        this.photo_130 = photo_130;

    }

    public String getPhoto_604() {
        return photo_604;

    }


    public void setPhoto_604(String photo_604) {
        this.photo_604 = photo_604;

    }


    public int getWidth() {
        return width;

    }


    public void setWidth(int width) {
        this.width = width;

    }


    public int getHeight() {
        return height;

    }


    public void setHeight(int height) {
        this.height = height;

    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;

    }

    public int getDate() {
        return date;

    }


    public void setDate(int date) {
        this.date = date;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.album_id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.photo_75);
        dest.writeString(this.photo_130);
        dest.writeString(this.photo_604);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.text);
        dest.writeInt(this.date);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 442052972)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPhotoDao() : null;
    }

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.id = in.readInt();
        this.album_id = in.readInt();
        this.owner_id = in.readInt();
        this.photo_75 = in.readString();
        this.photo_130 = in.readString();
        this.photo_604 = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.text = in.readString();
        this.date = in.readInt();
    }

    @Generated(hash = 2138723985)
    public Photo(int id, int album_id, int owner_id, String photo_75, String photo_130,
            String photo_604, int width, int height, String text, int date) {
        this.id = id;
        this.album_id = album_id;
        this.owner_id = owner_id;
        this.photo_75 = photo_75;
        this.photo_130 = photo_130;
        this.photo_604 = photo_604;
        this.width = width;
        this.height = height;
        this.text = text;
        this.date = date;
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 566311508)
    private transient PhotoDao myDao;
}