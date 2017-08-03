package com.example.servicebestpractice;

/**
 * Created by 99502 on 2017/7/31.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
