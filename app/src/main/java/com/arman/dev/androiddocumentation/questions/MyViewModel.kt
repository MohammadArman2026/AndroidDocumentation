package com.arman.dev.androiddocumentation.questions

class MyViewModel(){}

class ViewModelStore{
    val map = mutableMapOf<String, MyViewModel>()
}

class ViewModelProvider(val store: ViewModelStore){
    fun provideViewModel(key:   String): MyViewModel{
        if(store.map[key] == null){
            store.map[key] = MyViewModel()
        }
        return store.map[key]!!
        }
}


/**
 * this is a view model class
 */