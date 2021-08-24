package model;

import java.awt.*;
import java.io.IOException;

public class PosterHelper {
    private String posterUrl;
    private PosterHelperListener listener;
    private Runnable runnable;
    AmazonConnectionManager connectionManager = new AmazonConnectionManager();

    public PosterHelper() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Image response = connectionManager.requisitarPoster(posterUrl);
                    if(listener != null) {
                        listener.chegouOPoster(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void setListener(PosterHelperListener listener) {
        this.listener = listener;
    }

    public void requestPoster(String posterUrl) {
        this.posterUrl = posterUrl;
        (new Thread(runnable)).start();
    }
}
