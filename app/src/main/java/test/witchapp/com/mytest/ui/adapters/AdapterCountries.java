package test.witchapp.com.mytest.ui.adapters;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import test.witchapp.com.mytest.R;
import test.witchapp.com.mytest.db.model.CountryDao;

import static android.view.LayoutInflater.from;
/**
 * Created by z.ahmadi on 4/21/2018.
 */
public class AdapterCountries extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public List<CountryDao> data=new ArrayList<>();
    public final int FOOTER_VIEW=1;
    public final int Header_VIEW=2;
    public final int Data_VIEW=2;
    public Context context;
    public void clear() {
        data.clear();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public AdapterCountries(Context context) {
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        final RecyclerView.ViewHolder viewHolder;
        if (viewType == FOOTER_VIEW) {
            View view = from(parent.getContext()).inflate(R.layout.adapter_countries,parent,false);
            viewHolder = new FooterViewHolder(view);
        } else  if (viewType == Header_VIEW) {
            View view = from(parent.getContext()).inflate(R.layout.adapter_countries,parent,false);
            viewHolder = new HeaderViewHolder(view);
        }
        else {
            View view = from(parent.getContext()).inflate(R.layout.adapter_countries, parent, false);
            viewHolder = new DataViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder hvh = (HeaderViewHolder) holder;
            hvh.txtHeader.setText(context.getString(R.string.header_section));
        }else if (holder instanceof FooterViewHolder) {
            FooterViewHolder hvh = (FooterViewHolder) holder;
            hvh.txtFooter.setText(context.getString(R.string.footer_section));
        }
        else {
            DataViewHolder hvh = (DataViewHolder) holder;
            hvh.txtName.setText(data.get(position).name);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) {
            return FOOTER_VIEW;
        }
        else if(position==0){
            return Header_VIEW;
        } else  {
            return Data_VIEW;
        }
    }
    public void addItems(List<CountryDao> items) {
        data.addAll(items);
        notifyDataSetChanged();
    }
    protected static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtHeader;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    protected static final class DataViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;

        public DataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    protected static final class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtFooter;
        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public void removeItem(int index) {
        data.remove(index);
        notifyDataSetChanged();
    }
}
