
💳 💵 🏦 ₿

# AndroCoda
The best architecture for Android apps


Developed by [Burhan ARAS] with all the love on planet.

**AndroCoda :** The best architecture for an Android app

We, developers have wasted many years looking for the best architecture; but only a few of us were lucky enough to realize that there is no perfect architecture for every kind of application.
Today, we present you **AndroCoda:** the best architecture for Android apps


## Architecture

We have developed this application using **AndroCoda Architecture** which is an improved version of Clean Architecture + MVVM. We haved used the **Kotlin** programming language using industry-proven tools and libraries.

The main players in the MVVM pattern are:
  - **The View** — that informs the ViewModel about the user’s actions
  - **The ViewModel** — exposes streams of data relevant to the View
  - **The DataModel** — abstracts the data source. The ViewModel works with the DataModel to get and save the data.


In this MVVM architecture Activities and Fragments depend only on a view model. The repository is the only class that depends on multiple other classes; in this project, the repository depends on a persistent data model and a remote backend data source.

Repository is the single source of truth for all the app data and has a clean API for UI to communicate with.

Repository fetches data from network then it saves into local database and also notifies UI View classes.

Also we have implemented a background worker using **WorkManager** to run periodically in the background and keep local db up to date. We have configured worker to run once a day.

This design creates a consistent and pleasant user experience. Regardless of whether the user comes back to the app several minutes after they've last closed it or several days later, they instantly see a user's information that the app persists locally. If this data is stale, the app's repository module starts updating the data in the background.

Local data can always be kept up to dat thanks to daily work manager.

Architecture of AndroCoda App: 
![alt text](https://github.com/burhanaras/AndroCoda/blob/master/screenshots/androcoda.png "AndroCoda App Architecture")

AndroCoda Architecture Overview:
![AndroCoda Architecture Diagram](https://github.com/burhanaras/AndroCoda/blob/master/screenshots/architecture.jpg?raw=true)


## Used technologies and libraries

We have used popular, industry-proven tools and libraries :

* **Architecture Components - ViewModel** We keep UI related logic here.
* **Architecture Components - LiveData** We keep data that UI needs. Fragments observe this LiveData
* **DataBinding** To bind XML UI with data
* **Room** To save data to local db
* **Android Material** To benefit new Android Material design library
* **Android KTX**  provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
* **Coroutines** To fetch data in background threads. (We no longer need RxJava)
* **WorkManager** To fetch data in the background periodically.
* **Retrofit** To connect a web service
* **Stetho** To trace the network requests and see local db content
* **GSon** To parse Json
* **LeakCanary** To detect memory leaks
* **MonkeyRunner** To test UI crashes crazily :)
* **Lint** To see warnings in our code
* **JUnit - Espresso** To write automated tests.
* **Android Profiler - APK Analyzer** To analyze our apk
* **Proguard** To obfuscate our Apk code


## Package Structure

* **UI** Contains UI related classes which are Activities, Fragments, ViewModels  and custom views.
* **Database** Contains DAO, entity classes, Room DB implementation and everything else related to database
* **Domain** Keeps domain objects, anything related to business logic and usecases
* **Network** Contains Retrofit implementation, service api interface and data transfer objects
* **Repository** Single source of truth for all the app data
* **Work** Contains a WorkManager worker to run daily and keep local db up to date


## TO-DO List

* SSL Pinning (https://developer.android.com/training/articles/security-config#CertificatePinning)
* Instant App support (https://developer.android.com/topic/google-play-instant/getting-started/instant-enabled-app-bundle)
* Shortcut Support (https://developer.android.com/guide/topics/ui/shortcuts/creating-shortcuts)
* Sark Theme Support (https://proandroiddev.com/implementing-dark-theme-in-your-android-application-ec2b4fefb6e3)
* Foreground Service for Heartbeat (https://developer.android.com/guide/components/foreground-services)
* Session Refresh Support (https://medium.com/android-news/refresh-access-token-globally-using-rxjava-2-rxandroid-2-and-retrofit-2-fba6be0f11bd)


Developed By Burhan ARAS with all the love on planet
------------

www.burhanaras.net

   [Burhan ARAS]: <http://www.burhanaras.net>


License
-------

    Copyright 2020 Burhan ARAS

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
