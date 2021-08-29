package hatem.ali.leoni.adapter;

import android.widget.Adapter;
import android.widget.Filter;

import java.util.ArrayList;

import hatem.ali.leoni.items.Stage;

public class stageFilter extends Filter {

    Adapter adapter;
    ArrayList<Stage> filterList;

    public stageFilter(ArrayList<Stage> filterList,Adapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Stage> filteredStages=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getTitle_stage().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredStages.add(filterList.get(i));
                }
            }

            results.count=filteredStages.size();
            results.values=filteredStages;

        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

    }

    /*@Override
    protected void publishResults(CharSequence constraint, FilterResults results) {


        adapter.stages = (ArrayList<Stage>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();

    }*/

}
