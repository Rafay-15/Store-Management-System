package com.company.FileHandling;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOOS extends ObjectOutputStream {
    public MyOOS(OutputStream out) throws IOException {
        super(out);
    }

    protected MyOOS() throws IOException, SecurityException {
    }
    public MyOOS(File f) throws IOException{
        super();
    }
    @Override
    public void writeStreamHeader(){}
}
