

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.components.TabButton
import ui.theme.AppTheme
import utilities.MenuItem

@Composable
fun App(currentScreen: MutableState<MenuItem>) {

    Column {

            TabRow(selectedTabIndex = currentScreen.value.ordinal) {

                TabButton(text = "Search",
                    selected = currentScreen.value == MenuItem.Search,
                    onClick = { currentScreen.value = MenuItem.Search })

                TabButton(text = "Sort",
                    selected = currentScreen.value == MenuItem.Sort,
                    onClick = { currentScreen.value = MenuItem.Sort })
            }

        }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Searching and Sorting App"
    ) {
        AppTheme (false) {
            val currentScreen = remember { mutableStateOf(MenuItem.Search) }
            App(currentScreen)
        }
    }
}


