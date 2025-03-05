import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.lab1.R
import com.example.lab1.models.Post

class PostAdapter(private val posts: MutableList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postText: TextView = itemView.findViewById(R.id.postText)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val likesText: TextView = itemView.findViewById(R.id.likesText)
        val commentsText: TextView = itemView.findViewById(R.id.commentsText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var post = posts[position]
        holder.postText.text = post.text
        holder.likesText.text = "❤️ ${post.likes}"
        holder.commentsText.text = "💬 ${post.comments}"

        if (post.imageURL != null) {
            holder.postImage.visibility = View.VISIBLE
            Glide.with(holder.itemView.context)
                .load(post.imageURL)
                .transform(MultiTransformation(CenterCrop(), RoundedCorners(20)))
                .into(holder.postImage)
        } else {
            holder.postImage.visibility = View.GONE
        }

        holder.likesText.setOnClickListener {
            posts[position] = post.copy(likes = post.likes + 1)
            notifyItemChanged(position, "likes")

            holder.likesText.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200)
                .withEndAction {
                    holder.likesText.animate().scaleX(1f).scaleY(1f).setDuration(200)
                }
        }

        holder.commentsText.setOnClickListener {
            posts[position] = post.copy(comments = post.comments + 1)
            notifyItemChanged(position, "comments")

            holder.commentsText.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200)
                .withEndAction {
                    holder.commentsText.animate().scaleX(1f).scaleY(1f).setDuration(200)
                }
        }
    }

    override fun getItemCount() = posts.size
}
