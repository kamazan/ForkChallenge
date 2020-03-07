package com.kris.fork.features.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.kris.fork.R
import com.kris.fork.core.BaseDataBindingFragment
import com.kris.fork.databinding.FragmentRestaurantDetailsBinding
import com.kris.fork.features.details.adapter.CarouselAdapter
import com.kris.fork.features.details.adapter.MenuAdapter
import com.kris.fork.features.details.adapter.TagAdapter
import com.kris.fork.utils.MarginSpaceItemDecoration
import kotlinx.android.synthetic.main.layout_carousel.*
import kotlinx.android.synthetic.main.layout_details_scroll_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class RestaurantDetailsFragment: BaseDataBindingFragment<RestaurantDetailsViewModel, FragmentRestaurantDetailsBinding>() {
    override val layoutId: Int = R.layout.fragment_restaurant_details

    override val viewModel: RestaurantDetailsViewModel by viewModel()

    private val menuAdapter = MenuAdapter()
    private val tagsAdapter = TagAdapter()
    private val carouselAdapter = CarouselAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val marginSpaceItemDecoration = MarginSpaceItemDecoration(resources, R.dimen.keyline_1)
        recyclerViewMenu.set(menuAdapter, marginSpaceItemDecoration)
        recyclerViewTags.set(tagsAdapter, marginSpaceItemDecoration)
        viewPagerDiaporama.adapter = carouselAdapter
        viewPagerIndicator.setViewPager(viewPagerDiaporama)
        carouselAdapter.registerAdapterDataObserver(viewPagerIndicator.adapterDataObserver)

        viewModel.restaurant.observe(viewLifecycleOwner, Observer {
            menuAdapter.submitList(it.menu?.dishes)
            tagsAdapter.submitList(it.visibleTagHolders)
            carouselAdapter.submitList(it.diaporamaPictures)
        })
    }

    private fun RecyclerView.set(adapter: RecyclerView.Adapter<*>, decoration: RecyclerView.ItemDecoration?) {
        this.adapter = adapter
        decoration?.let { addItemDecoration(it) }
    }
}