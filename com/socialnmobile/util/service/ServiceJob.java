package com.socialnmobile.util.service;

import java.util.concurrent.Callable;

public abstract class ServiceJob implements Callable {
    final JobListener listener;

    public interface JobListener {
        void onException(Exception exception);

        void onFinalize();

        void onFinished(Object obj);

        void onInit();
    }

    public ServiceJob(JobListener jobListener) {
        this.listener = jobListener;
    }

    public JobListener getJobListener() {
        return this.listener;
    }

    public void onJobResult(Object obj) {
    }

    public boolean onJobException(Exception exception) {
        return false;
    }

    public void onJobFinally() {
    }
}
