package com.example.lyx4_p6;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShibaFragment extends Fragment {

    private ImageView mShiba;

    public ShibaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shiba, container, false);
        mShiba = rootView.findViewById(R.id.shiba_image);

        OkHttpClient client = new OkHttpClient();
        String url = "https://shibe.online/api/shibes?count=1&urls=true&httpsUrls=true";
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(url)
//                .newBuilder();
//        String new_url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d("testing", response.body().string());
                }
            }
        });

        return rootView;
    }
}
