package com.arman.dev.androiddocumentation.questions

/**
 * explain clean architecture.
 * clean architecture is recommended architecture pattern by google.
 * it divides the project into three layer.
 * data
 * domain
 * presentation
 *
 * data layer consist of the data sources, Dto, Entities, Mappers, Retrofit, Room.
 * domain layer consist of pure kotlin codes.
 * domain layer creates abstraction.
 * has repository interface the repository implements.
 * has model.
 * has use cases.
 * presentation layer takes care of user interface and business logic related to the user
 * interface.
 * it consist of viewmodel, user interface.
 * this architecture provides the separation of concern.
 */


/**
 * explain repository pattern.
 * repository pattern abstract the data source behind it.domain contains a repository interface
 * and data layer implements that interface with retrofit, room.
 * and viewmodel depends on the interface.
 * this creates the abstraction.
 */

/**
 * explain MVVM
 * MVVM is an architecture pattern.
 * stands for Model View Model.
 * model stands for the data.
 * view stands for the user interface.
 * viewmodel is  bridge between the user interface and model.
 * ui->viewmodel->model.
 * ui<-viewmodel<-model.
 *
 * ui keeps on observing the state which is exposed from viewmodel.
 * viewmodel keeps the business logic related to the user interface.
 */