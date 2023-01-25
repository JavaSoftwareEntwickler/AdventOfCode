package src.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    private BufferedReader _reader;
    private String _urlFile;
    public FileReader(String percosoFile){
        _urlFile = percosoFile;
        _reader = getFile();
    }

    private BufferedReader getFile() {
        try {
            this._reader = new BufferedReader(new java.io.FileReader(_urlFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return this._reader;
    }

    public String getLine() {
        if (_reader == null) return null;
        try {
           return this._reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void close() {
        try {
            _reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
