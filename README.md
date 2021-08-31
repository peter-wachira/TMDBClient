# TMDB Client


#### July 20th 2021
#### By **peteHack**

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/550c2893ba1a45339589435926a1d709)](https://app.codacy.com/gh/peter-wachira/TMDBClient?utm_source=github.com&utm_medium=referral&utm_content=peter-wachira/TMDBClient&utm_campaign=Badge_Grade_Settings)


This is my simple app demonstration the use of clean architecture. It gets data from the [TMDB API](https://www.themoviedb.org/documentation/api) and entertains the user using
clean architecture and MVVM.

## Prerequisite

minSdkVersion -> 26

Gradle build system

Head over to the TMDB api above and get your own API-KEY as well.


## TOC

- [Architecture](#architecture)
- [Flow](#flow)
- [Libraries](#libraries)
- [Extras](#extras)
- [Contacts](#Contacts)

## Architecture

### Implemented using Clean Architecture
The following diagram shows the structure of this project with 3 layers:
- Presentation
- Domain
- Data

<br>
<p align="center">
  <img src="https://github.com/peter-wachira/TMDBClient/blob/master/diagram.png" width="750"/>
</p>
<br>

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case combines data from TvShow, Movie and Artist Repositories.
4. Each Repository returns data from a Data Source (Cached or Remote).
5. Information flows back to the UI where we display the list of posts.



The App is not organized into multiple modules but follows the same principles of
the Presentation, Domain, and Data Layers.
The presentation layer handles the UI work with the logic contained in the **ViewModel**.
The UI uses a **LiveData** object from the ViewModel and observes it using the **Observer Pattern**.
A ListAdapter handles the actual displaying of the Data over the network is retrieved using
**retrofit** and **coroutines** to handle background work asynchronously. Additionally, note that
the ViewModel uses the **viewModelScope** to launch the couroutines to observe data.
The data layer uses the recommended **Repository Pattern** to make the network calls and store the data using
**Room DB**.

## Flow

 **Landing screen**

  Once the app is launched, the user has the option of choosing where to navigate within the app.

## Libraries

This app takes use of the following libraries:

- [Jetpack](https://developer.android.com/jetpack)🚀
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI data to survive configuration changes and is lifecycle-aware
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - Declaratively bind observable data to UI elements
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify views when underlying database changes
- [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
- [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back
- [Dagger2](https://github.com/google/dagger) - A fast dependency injector for Android and Java.
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logging HTTP request related data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
- [Glide](https://github.com/bumptech/glide) - Hassle-free image loading
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API which provides utility on top of Android's normal Log class.


## Extras

### Known Bugs

- There are currently no tests done for this project
- As at the time this project was made, testing and UIs was not a major concern 
- The project is currently not being maintained any more. Contributions are most welcome if you would like to add more modules to the project, you can reach me through my [Contacts](#Contacts) below.
- Thanks for understanding.


#### CI-Pipeline

[Github Actions CI](https://github.com/features/actions/) is used for Continuous Integration every time an update is made
to the repo. The configuration is in the .develop.yml .master.yml .branch.yml*** files

#### Code Analysis and test coverage

This code uses [Codacy](https://www.codacy.com/) for analysing the quality of the code, which is
always going to be > B :)
```
   Copyright 2020 Peter Wachira
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```



## Contacts

```bash

You can reach me via my personal email pwachira900@gmail.com or my website for contibutions or reuse


