# A demo to display Crypto Currency List

## Objective
Create a reusable CurrencyListFragment. 
Also create a DemoActivity to showcase the CurrencyListFragment

## Requirement
### Overview
- CurrencyListFragment should receive an array list of CurrencyInfo to create the ui.
- DemoActivity should provide 1 dataset, Currency List A of CurrencyInfo to CurrencyListFragment and the dataset should be queried from local db
- DemoActivity should provide 2 buttons to do the demo.
- First button to load the data and display
- Second button for sorting currency list
- CurrencyListFragment should provide a hook of item click listener to the parent
- All the IO operations MUST NOT be in UI Thread.
- Please show how to handle multi threading operation, and deal with concurrency issue when do sorting (fast double click of sorting button)
- Search functionality is not required

## Implementation
### Tech and libs in use
- Kotlin & MVVM 
- DataBinding & LiveData
- Local DB: Room
- Concurrency handle: Coroutine
- Dependency Injection: Hilt
- Logging: Timber

### User Logic
- When open the app, display the DemoActivity containing CurrencyListFragment, with an empty list. 
- Touch "FETCH DATA" button to load data: 
- 1. load the data from local DB, if DB has data, return and display; if not: 
- 2. fetch the json file from asset folder, parsing with Gson to object. Save the data to local DB, return the data. 
- Touch "SORT LIST" to sort the list by name and update the list in fragment. 
- Touch "CLEAR DB" to clear the local db table and update the list in fragment. 
- The room database is created as a singleton with a synchronized lock to avoid multiple instance opening or operation at the same time. 
