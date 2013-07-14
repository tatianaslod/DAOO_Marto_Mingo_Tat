package server;

import ioc.MsgEncoder;
import ioc.Task;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class EncodeDecodeTask extends Task {
    private final MsgEncoder encoder;

    protected EncodeDecodeTask(Socket socket, MsgEncoder encoder) {
        super(socket);
        this.encoder = encoder;
    }

    @Override
    protected void task() throws IOException {
        encode();
    }

    private void encode() throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        final StringBuilder header = new StringBuilder();

        while (true) {
            final String s = in.readLine();
            if (s == null || s.isEmpty()) break;
            header.append(s);
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: text/plain\r\n");

        // Echo path
        out.write("\r\n");
        final String path = getHeaderPath(header.toString());
        String[] data = path.split("/");

        print("\nEncoding/Decoding"+Arrays.toString(data)+"...");

        if (data.length > 2 && data[1] != null && data[2] != null) {
            switch (data[1]) {
                case "encode":
                    out.write("Encode text: " + data[2] + "\r\n");
                    final byte[] code = encoder.encode(data[2]);
                    out.write("Encoded code: " + new String(code) + "\r\n");
//                    out.write("Encoded code: " + code.toString() + "\r\n");

                    break;
                case "decode":
                    out.write("Decode code: " + data[2] + "\r\n");
                    final String text = encoder.decode(data[2].getBytes());
                    out.write("Decoded text: " + text + "\r\n");
                    break;
                default:
//                TODO to be implemented
                    break;
            }
        } else {
            out.write("Command not supported. Supported Commands: ENCODE - DECODE.");
        }
        out.close();
        in.close();
    }

    private String getHeaderPath(String header) {
        final int method = header.indexOf("GET /");
        if (method == -1) throw unsupported("Unsupported HTTP Method! GET only!");
        final int protocol = header.indexOf("HTTP/1.");
        if (protocol == -1) throw unsupported("Unsupported HTTP Protocol! HTTP/1.* only!");
        return header.substring(method + 4, protocol);
    }

    private UnsupportedOperationException unsupported(String s) {
        return new UnsupportedOperationException(s);
    }

}
