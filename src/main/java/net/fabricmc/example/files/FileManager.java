package net.fabricmc.example.files;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public File createJsonFile() {
        if (getPath() != null) {
            File jsonFile = new File(this.getPath());
            return jsonFile;
        }
        return null; // For now
    }

    public boolean writeFileJson(File fileToWriter, JsonObject jsonObject) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(fileToWriter);
            fileWriter.write(jsonObject.toString());
            return true;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}
