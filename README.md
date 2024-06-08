Steps to use recycler view:

1.Creating data class<br/>
2.Creating data objects<br/>
3.Creating an item design<br/>
4.Creating the adapter<br/>
5.Linking the adapter to recycler in activity<br/>
6.OnBind, OnCount etc<br/>
7.NotifyDatasetChange<br/>
</br></br>

**The code given in the code file works, but for complex models -> Always pass the context</br></br>

**Context -> If calling from activity : Pass this</br>
             If parent adapter calling child adapter for nested rv -> pass the context that the parent received

**Context is necessary for calling back to the parent functions, toasts, dialog boxes, progress bars etc


    open class CardListItemAdapter(context: Context, val cardList:List<Card>): RecyclerView.Adapter<CardListItemAdapter.MainViewHolder>() {
        inner class MainViewHolder(val itemBinding:ItemCardBinding):RecyclerView.ViewHolder(itemBinding.root){

        //where do we get data
        fun bindItem(card:Card){
            itemBinding?.tvCardName?.text=card.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val card=cardList[position]
        holder.bindItem(card)
    }
}

