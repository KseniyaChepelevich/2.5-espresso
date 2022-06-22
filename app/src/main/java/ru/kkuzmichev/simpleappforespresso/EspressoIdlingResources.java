package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResources {
    private  static final String RESOURCE = "GLOBAL";
    public static CountingIdlingResource idlingRecource = new CountingIdlingResource(RESOURCE);

    public static void increment() {
        idlingRecource.increment();
    }

    public static void decrement() {
        if(!idlingRecource.isIdleNow()) {
            idlingRecource.decrement();
        }
    }

}
