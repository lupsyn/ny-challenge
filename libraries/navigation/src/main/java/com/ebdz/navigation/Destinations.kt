package com.ebdz.navigation

/**
 * Represents the possible destinations of App via Compose Navigation. The destinations represents
 * a flow where a backstack is required, so the tabs inside the Home destination is a simple
 * navigation.
 */
object Destinations {

    /**
     * Home destination.
     */
    const val Home = "home_screen"

    /**
     * Search destination.
     */
    const val Search = "search_screen"

    /**
     * Settings destination.
     */
    const val Settings = "settings_screen"

    /**
     * About destination.
     */
    const val About = "about_screen"
}

const val ROOT_GRAPH_ROUTE = "root"
const val PREF_GRAPH_ROUTE = "preferences"
const val HOME_GRAPH_ROUTE = "home"
const val BOTTOM_TEST_TAG = "_bottom"
const val SCREEN_TEST_TAG = "_screen"
