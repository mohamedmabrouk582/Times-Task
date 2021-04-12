package com.example.timestask.view.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.example.timestask.R
import com.example.timestask.lunchedFragmentInHiltContainer
import com.example.timestask.view.ArticlesAdapter
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
@HiltAndroidTest
@MediumTest
class ArticlesListFigmentTest{
    @get:Rule
    var hiltRule  = HiltAndroidRule(this)

    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun navigateFromListToDetailsArticle() {
      val navController = Mockito.mock(NavController::class.java)
//        val fragmentScenario = FragmentScenario.launchInContainer(ArticlesListFigment::class.java)
//        fragmentScenario.onFragment{
//            Navigation.setViewNavController(it.requireView(),navController)
//        }
        lunchedFragmentInHiltContainer<ArticlesListFigment> {
            Navigation.setViewNavController(requireView(), navController)
        }
//        Espresso.onView(withId(R.id.article_rcv)).perform(RecyclerViewActions.
//        actionOnItemAtPosition<ArticlesAdapter.Holder>(1, MyViewAction.clickItemWithId(R.id.item)))
//

    }

}