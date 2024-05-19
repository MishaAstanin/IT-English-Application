class MainActivityTest {
    @get:Rule
    val activityTest = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkBtn1() {
        // Проверяем, что приложение открыто
        onView(withId(R.id.container)).check(matches(isDisplayed()))

        // Нажимаем на первый элемент меню
        onView(withId(R.id.navigation_dashboard)).perform(click())

        // Проверяем, что после нажатия на элемент меню отображается соответствующий фрагмент
        onView(withId(R.id.nav_host_fragment_activity_main))
            .check(matches(hasDescendant(withText("Переводчик с английского"))));
    }
    @Test
    fun checkBtn2() {
        // Проверяем, что приложение открыто
        onView(withId(R.id.container)).check(matches(isDisplayed()))

        // Нажимаем на первый элемент меню
        onView(withId(R.id.navigation_home)).perform(click())

        // Проверяем, что после нажатия на элемент меню отображается соответствующий фрагмент
        onView(withId(R.id.nav_host_fragment_activity_main))
            .check(matches(hasDescendant(withText("TechLingo"))));
    }
    @Test
    fun checkBtn3() {
        // Проверяем, что приложение открыто
        onView(withId(R.id.container)).check(matches(isDisplayed()))

        // Нажимаем на первый элемент меню
        onView(withId(R.id.navigation_notifications)).perform(click())

        // Проверяем, что после нажатия на элемент меню отображается соответствующий фрагмент
        onView(withId(R.id.nav_host_fragment_activity_main))
            .check(matches(hasDescendant(withText("Здесь отобажается Ваша статистика"))));
    }
}
