package Assignment_2;

import java.util.*;

public class Lecture implements Utility{

    private final String title;
    private final String type;

    private final ArrayList<String> slides;
    private final String videoFile;

    private final String uploader;
    private final Date timestamp;

    Lecture(String title, ArrayList<String> slides, String uploader){

        this.title = title;
        this.type  = "";
        this.slides = slides;
        this.videoFile = null;
        this.uploader = uploader;
        this.timestamp = new Date();
    }

    Lecture(String title, String videoFile, String uploader){

        this.title = title;
        this.type  = " of video";
        this.slides = null;
        this.videoFile = videoFile;
        this.uploader = uploader;
        this.timestamp = new Date();
    }


    @Override
    public String toString() {
        String print = "";

        if(this.slides != null){
            for(int i = 0; i < slides.size(); i++){
                print = print.concat("Slide " + i + ": " + slides.get(i) + "\n");
            }
            print += "Number of slides: " + slides.size() + "\n";

        } else {
            print = "Video file: " + this.videoFile + "\n";
        }

        print = "Title" + this.type + ": " + this.title + "\n" +
                 print +
                "Date of upload: " + timestamp + "\n" +
                "Uploaded by: " + uploader;

        return  print;
    }
}
