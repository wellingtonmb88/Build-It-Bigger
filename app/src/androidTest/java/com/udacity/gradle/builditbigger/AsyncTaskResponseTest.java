package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device to test the class {@link EndpointsAsyncTask}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskResponseTest {

    @org.junit.Test
    public void asyncTaskResponse_EnsureResponseIsNotNull() throws InterruptedException {

        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        endpointsAsyncTask.setListener(new EndpointsAsyncTask.EndpointListener() {
            @Override
            public void onResultReceived(String result) {
                assertNotNull("Response result should not be Null", result);
                signal.countDown();
            }
        });
        endpointsAsyncTask.execute();
        signal.await();
    }
}
