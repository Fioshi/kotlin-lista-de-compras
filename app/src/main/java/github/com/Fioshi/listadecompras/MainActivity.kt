package github.com.Fioshi.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import github.com.Fioshi.listadecompras.ui.theme.ListaDeComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listaProduto);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.incluirButton)
        val editText = findViewById<EditText>(R.id.produtoEditText)

        button.setOnClickListener {
            val item = ItemModel(
                name = editText.text.toString()
            )

            itemsAdapter.addItem(item)
        }
    }
}