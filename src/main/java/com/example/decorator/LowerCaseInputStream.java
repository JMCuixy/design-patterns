package com.example.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/15 09:20
 */
public class LowerCaseInputStream extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }


    @Override
    public int read() throws IOException {
        int read = super.read();
        return (read == -1 ? read : Character.toLowerCase(read));
    }


    @Override
    public int read(byte[] b) throws IOException {
        int read = super.read(b);
        for (int i = 0; i < read; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return read;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = super.read(b, off, len);
        for (int i = off; i < off + read; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return read;
    }
}
