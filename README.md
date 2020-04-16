# Nigerian-Administrative-Division-Spinner
A Simple Android Library to show all Nigerian States and Local governments for use in forms to select state and corresponding Lga.

![Spinner Demo](https://raw.githubusercontent.com/petyr47/Nigerian-Administrative-Division-Spinner/master/screenshots/20200416_235301.gif)

## How To Use
First, you would have to add the library to your project

In your project level build.gradle 
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Then in your app level build.gradle 
The latest version is [![](https://jitpack.io/v/petyr47/Nigerian-Administrative-Division-Spinner.svg)](https://jitpack.io/#petyr47/Nigerian-Administrative-Division-Spinner)

```groovy
dependencies {
     implementation 'com.github.petyr47:Nigerian-Administrative-Division-Spinner:$latestVersion'
}
```

There are two administrative levels for the AdministrativeSpinner, this extends from the AutoCompleteTextView component,
so you can use all the same styling attributes used for the AutoCompleteTextView, in the example below i would use the OutlinedBox.ExposedDropdownMenu style, but any of the other styles would work

**State Level**
```XML
 <com.google.android.material.textfield.TextInputLayout
            style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.ExposedDropdownMenu"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">

            <com.aneke.peter.nigerianadministrativedivisionspinner.AdministrativeSpinner
                android:layout_width="150dp"
                android:layout_height="70dp"
                android:id="@+id/state"
                app:admin_level="state" />

        </com.google.android.material.textfield.TextInputLayout>
```

**Lga Level**
```XML
       <com.google.android.material.textfield.TextInputLayout
             style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.ExposedDropdownMenu"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content">
 
             <com.aneke.peter.nigerianadministrativedivisionspinner.AdministrativeSpinner
                 android:layout_width="150dp"
                 android:id="@+id/lga"
                 android:layout_height="70dp"
                 app:admin_level="lga" />
 
         </com.google.android.material.textfield.TextInputLayout>
```

In order to connect the lga level spinner to the lga, there are two possible methods,
First, we can use Databinding, Livedata and a ViewModel to setup a one-way bind between the value to the state level spinner to a livedata object 
and then observing said livedata to setCurrentState for the lga level AdministrativeSpinner, you can check this out on the sample app

```kotlin
viewModel.state.observe(this, Observer {
            it?.let {
                lga.setCurrentState(it)
            }
        })
```

Or we can use a good old onItemSelectedListener as shown below
```kotlin
state.setOnItemClickListener { _, _, _, id ->
            lga.setCurrentState(getAllStates()[id.toInt()].name) }
```


#TODO
- [ ] Add Ward level spinner
- [ ] Setup link between different spinner levels to auto set lists


## License
[MIT](https://choosealicense.com/licenses/mit/)