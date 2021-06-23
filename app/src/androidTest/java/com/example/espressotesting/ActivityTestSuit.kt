package com.example.espressotesting

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SeconderyActivityTest::class
)
class ActivityTestSuit {
/*This class is to run all the tests together one after the other if want to run all the test classes together
* just mension the classes you want to run inside the anotation */

}