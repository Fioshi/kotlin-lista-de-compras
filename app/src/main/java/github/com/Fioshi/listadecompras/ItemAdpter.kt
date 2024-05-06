package github.com.Fioshi.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    /*
     * onCreateViewHolder serve para que o RecyclerView necessita criar um novo ViewHolder.
     * Ele mantem a referencia de todas as subvisualizações do item a ser exibido no
     * recycleView. Vale ressaltar que não é ele quem vincula dados ás Views, apenas as inicializa
     * lembrando que as views podem ser de variados tipos, como TextView ou ImageView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    /*
     * onBindViewHolder é utilizado pelo RecyclerView para exibir o dados
     * em uma posição especifica. Funciona com o intuito de atualizar tudo o que é exibido
     * no arquivo de xml, por exemplo, se nele desejamos exibir nomes ou images, ele devolvera
     * TextView ou ImageView. Resumidamente, ele atualizara o conteudo da tela em tempo real,
     * apagando o que já foi visto e carregando o que sera visto logo em seguida, assim
     * otimizando o uso de recursos do aparelho android
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * `ItemViewHolder` é uma implementação de `RecyclerView.ViewHolder` que armazena referências
     * para as visualizações que precisam ser atualizadas com novos dados conforme o usuário
     * rola pelo `RecyclerView`. Esta classe é usada para evitar a busca desnecessária de visualizações,
     * proporcionando uma melhoria de desempenho significativa.
     *
     * @param view A visualização base que o ViewHolder irá segurar. Esta é uma das visualizações
     *             infladas do layout que representa um único item na lista.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*
        * Variavel responsavel por guardar a view que sera exibida, aqui é um TextView
        * mas poderia ser uma imageView. Essa variavel evita a repetição de chamar "findViewById
        * repetidas vezes
         */
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        /*
        * Nesse trecho é realizada a chamada para cada ItemViewHolder para alterar individualmente
        * o valor associado a TextView
         */
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }

    /*
    * RecyclerView chama esse método para conferir o tamanho do conjunto de dados. Por exemplo, em um
    * aplicativo de catálogo de endereços, isso pode ser o número total de endereços. O RecyclerView
    *  usa isso para determinar quando não há mais itens que possam ser mostrados.
     */
    override fun getItemCount(): Int = items.size

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged();
    }
}