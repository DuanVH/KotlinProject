package com.example.gem.firstapp.ui.home

import com.example.gem.firstapp.base.activity.vipe.ActivityContract

interface MainContract {

    interface Interactor : ActivityContract.Interactor<Presenter> {
        fun fetchData();
    }

    interface View: ActivityContract.View<Presenter> {
        fun show();
    }

    interface Presenter: ActivityContract.Presenter<View, Interactor> {
        fun getData();

        fun getSuccess();

        fun getFailure();
    }
}