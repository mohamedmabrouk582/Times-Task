package com.example.timestask.view.fragments

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import org.hamcrest.Matcher


class MyViewAction {
    companion object {

        fun clickRecyclerViewItem(position: Int, id: Int? = null): ViewAction {
            return actionOnItemAtPosition<RecyclerView.ViewHolder>(position,
                id?.let {
                    object : ViewAction {
                        override fun getConstraints() = null
                        override fun getDescription() = "Click on an item view with specified id."
                        override fun perform(uiController: UiController?, view: View?) {
                            val itemView = view?.findViewById<View>(id)
                                ?: throw Exception("Item view is not found")
                            itemView.performClick()
                        }
                    }
                } ?: click())
        }


        fun clickItemWithId(id: Int): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View>? {
                    return null
                }

                override fun getDescription(): String {
                    return "Click on a child view with specified id."
                }

                override fun perform(uiController: UiController, view: View) {
                    val v = view.findViewById<View>(id) as View
                    v.performClick()
                }
            }
        }
    }
}