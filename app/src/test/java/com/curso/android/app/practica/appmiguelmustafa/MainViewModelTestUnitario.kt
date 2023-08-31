package com.curso.android.app.practica.appmiguelmustafa
import com.curso.android.app.practica.appmiguelmustafa.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.appmiguelmustafa.model.Comparador

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelTestUnitario {

    private lateinit var viewModel: MainViewModel
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckComparacion() = runTest {
        val comparador = Comparador("Es igual", "Es igual", "Resultado")
        viewModel.updateComparador(comparador)

        assertEquals(comparador, viewModel.comparador.value)
    }




}