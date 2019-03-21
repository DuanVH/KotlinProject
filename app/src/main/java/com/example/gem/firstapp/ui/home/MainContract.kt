package com.example.gem.firstapp.ui.home

import com.example.gem.firstapp.base.activity.vipe.ActivityContract

interface MainContract {

    interface Interactor : ActivityContract.Interactor<Presenter> {

    }

    interface View: ActivityContract.View<Presenter> {

    }

    interface Presenter: ActivityContract.Presenter<View, Interactor> {

    }
}