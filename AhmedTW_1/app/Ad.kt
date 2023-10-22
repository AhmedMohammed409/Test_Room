import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class $ { Name }(
var $
{ Data_Name }: List<${ Data_Name }>) : Adapter<${ Name }.${ ViewHolder_Name }>() {

    override fun onCreate${ ViewHolder_Name }(
        parent: ViewGroup,
        viewType: Int
    ): ${ ViewHolder_Name } {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.${ Item_Name }, parent, false)
        return ${ ViewHolder_Name }(view)
    }

    override fun onBind${ ViewHolder_Name }(holder: ${ ViewHolder_Name }, position: Int) {
//       holder.imageView.setImageResource(${ Data_Name}[position].id_img)
//        holder.textView_name.text=${ Data_Name}[position].name
//        holder.textview_adress.text=${ Data_Name}[position].address

    }

    override fun getItemCount(): Int {
        return ${ Data_Name }.size
    }


    class $ { ViewHolder_Name }(itewview: View) : RecyclerView.${ ViewHolder_Name }(itewview) {
//        var imageView:ImageView=itewview.findViewById(R.id.img_res)
//        var textView_name:TextView=itewview.findViewById(R.id.txt_name)
//        var textview_adress:TextView=itewview.findViewById(R.id.txt_street)
    }

}