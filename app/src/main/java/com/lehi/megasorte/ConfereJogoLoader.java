package com.lehi.megasorte;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Lehi on 09/09/2016.
 */
public class ConfereJogoLoader extends AsyncTaskLoader<Jogo> {
    /** Tag for log messages */
    private static final String LOG_TAG = ConfereJogoLoader.class.getName();


    /** Query URL */
    private String mUrl;
    /**** Construtor Loader ************************/
    public ConfereJogoLoader(Context context, String url) {
        super(context);
        mUrl = url;



    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }



    @Override
    public Jogo loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        Jogo jogo = QueryUtils.fetchJogoData(mUrl);
        return jogo;
    }


}
