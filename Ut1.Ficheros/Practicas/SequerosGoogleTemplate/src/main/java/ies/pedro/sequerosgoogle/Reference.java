package ies.pedro.sequerosgoogle;

import java.io.File;

public class Reference {


    private String word;
    private File file;
    private double position;
    private String resume;
    public Reference(String word,File file, double position, String resume) {
        this.file = file;
        this.position = position;
        this.resume = resume;
        this.word = word;
    }
    public File getFile() {
        return file;
    }
    public String getFilename() {
        if(this.file!=null)
            return this.file.getName();
        else
            return "";
    }
    public void setFile(File file) {
        this.file = file;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
