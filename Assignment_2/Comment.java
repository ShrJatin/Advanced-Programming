package Assignment_2;

import java.util.*;

public class Comment implements Utility {

    private final String  comment;
    private final String uploader;
    private final Date timestamp;

    Comment(String comment, String uploader){
        this.comment = comment;
        this.uploader = uploader;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return
            this.comment + " - " + this.uploader + "\n" +
            this.timestamp + "\n";
    }
}
