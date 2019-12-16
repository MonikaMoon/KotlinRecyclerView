package com.monika.kotlinrecyclerview;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.monika.kotlinrecyclerview.model.ApiResponse;
import com.monika.kotlinrecyclerview.model.Facts;
import com.monika.kotlinrecyclerview.viewmodel.FactsListViewModel;

import org.junit.Assert;
import org.junit.Test;

public class FactsViewModelTest extends BaseViewModelTest {

    private FactsListViewModel factsListViewModel;

    @Override
    public void beforeTest() {
        super.beforeTest();
        factsListViewModel = new FactsListViewModel();
    }

    @Test
    public void getAccountList() throws InterruptedException {

        factsListViewModel.fetchFacts().observeForever(new Observer<ApiResponse<Facts>>() {
            @Override
            public void onChanged(@Nullable ApiResponse<Facts> factsList) {
                if (factsList != null)
                    countDownLatch.countDown();
                Assert.assertNotNull(factsList);
            }
        });
        countDownLatch.await();
    }
}