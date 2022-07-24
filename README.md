# MoviesApplication

This project is an Android App to fullfill  the requeriments of Indra's tech test. It allows fetching "posts" from [MoviesDB API](https://developers.themoviedb.org/3/getting-started/introduction), caching them on a local database.

## Installation

Use Android Studio to run/install the project on an emulator or a physical Android device. The API_KEY is not included (security reasons), but you can add yours in the local.properties file.

## How to use it

The LoginScreen is the entry point to the application. To access one must enter the valid credentials: User/Password*123.

When executed by the first time, it will look for movies in a local database, if no post was found, it will fetch them from the API, caching them in the database and show in the  MovieScreen. The MovieScreen list the movies in a recyclerview, paging them in batches of 20 movies each.

If an item in the movies list is touched/clicked, it will redirect to a detail screen, where more information is depicted: The poster, title, rating, release date and an overview.

## Technologies used
<img src="https://4.bp.blogspot.com/-NnAkV5vpYuw/XNMYF4RtLvI/AAAAAAAAI70/kdgLm3cnTO4FB4rUC0v9smscN3zHJPlLgCLcBGAs/s1600/Jetpack_logo%2B%25282%2529.png" width="140" height="140" /> &nbsp; &nbsp; <img src="https://miro.medium.com/max/1400/1*o8Q_O-C6yGZQqW_2cdafoQ.png" width="200" height="140" /> &nbsp; &nbsp; <img src="https://3.bp.blogspot.com/-GOONRBOVwjo/WwWmZjvUb_I/AAAAAAAABqQ/IgFZ-m0CxFwiP5u1QxR5Hwzg3VkCwNK0QCLcBGAs/s1600/room.jpeg" width="240" height="140" /> &nbsp; &nbsp; <img src="https://miro.medium.com/max/1200/1*WMf1XcyKU98dOMlNnn-Agg.png" width="240" height="140" />
<img src="https://miro.medium.com/max/1200/1*qaRO6v0bTbBQzkw9sBCWlg.jpeg" width="280" height="120" /> &nbsp; &nbsp; <img src="https://miro.medium.com/max/800/1*1tDZwUd3NMQuIjZVkv-r0w.png" width="280" height="120" /> &nbsp; &nbsp; <img src="https://daurislittle.com/wp-content/uploads/2021/01/using-jetpack-navigation-component-in-android-banner-925bdeb7f7ee09f0.png" width="190" height="120" />

## Architecture

The project follows a MVVM architecture with Clean Architecture. It is divided in a core package and one package for feature (this is a single feature-case: posts). A feature has three layers: presentation, domain, data. All the componentes in the layers are decoupled.

### Presentation Layer

It contains the componentes related to the UI, like screen/fragments, and its state, stored in a ViewModel.

### Domain Layer

It contains the business logic of the app. It allows the interaction of the UI with any other components, in this case the data layer. It has interfaces that represent the repositories for all the types of dat that could be requested.

**UseCases**:
The business logic is encapsulated in UseCases, which are called by the ViewModel, and can call the repositories.

**Model**:
The model contain all the classes representing the data.

### Data Layer

It contains the components to access the information required to make use of the application.

**Room**:
This package contains the implementation of the local database in Room, caching all the incoming data from the API. It has the the Entities and DAOs.

**Api**:
Contains all the classes and interfaces to interact  with the API using Retrofit.

**Repository**:
Here it is where the operations to fetch data take place.

## Dependecies

**Dagger Hilt**: Facilitates dependency injection with annotatinos and it is useful to use fake classes in a testing context.

**Jetpack Navigation**: This suite facilitates the cration of a a navigation tree between multiple screen. It is easy to setup and to include.

**Retrofit**: It enables an easy implementations of functions to make HTTP request to external REST API.

**Room**: This ORM faciliates the management of local databases adding a layer and working under the hood with SqLite.

**Jetpack Pagination3**: It facilitates the concertation of local caching (Room) and network fetching (Retrofit) but also provides and API to paginate data from both sources.

**oroutines/Flow**: They facilitate the incorporation of asynchronous operation in any project, not to mention that it is a *must* with various Android dependecies suites.
