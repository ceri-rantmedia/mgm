package uk.co.cerihughes.mgm.android.ui.albumscores

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_album_scores.view.*
import uk.co.cerihughes.mgm.android.R
import uk.co.cerihughes.mgm.android.dataloader.DataLoader

class AlbumScoresFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val activity = activity ?: return null

        val fragmentView = inflater.inflate(R.layout.fragment_album_scores, container, false)
        val dataLoader = DataLoader(activity)
        val viewModel = AlbumScoresViewModelImpl(dataLoader)
        viewModel.loadData()

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(activity, layoutManager.orientation)
        fragmentView.recycler_view.layoutManager = layoutManager
        fragmentView.recycler_view.addItemDecoration(dividerItemDecoration)
        fragmentView.recycler_view.adapter = AlbumScoresAdapter(viewModel)

        return fragmentView
    }
}