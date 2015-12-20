package com.christianbahl.swapico.details

import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.christianbahl.swapico.App
import com.christianbahl.swapico.R
import com.christianbahl.swapico.list.DaggerTypeComponent
import com.christianbahl.swapico.list.TypeComponent
import com.christianbahl.swapico.list.TypeModule
import com.christianbahl.swapico.list.model.ListType
import com.christianbahl.swapico.model.IListData
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState
import kotlinx.android.synthetic.main.fragment_details.*

import org.jetbrains.anko.find

/**
 * @author Christian Bahl
 */
@FragmentWithArgs
class DetailsFragment : MvpLceViewStateFragment<NestedScrollView, IListData, DetailsView, DetailsPresenter>() {

  @Arg var detailsId = 1
  @Arg lateinit var listType: ListType

  lateinit private var typeComponent: TypeComponent

  private var data: IListData? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true

    DetailsFragmentBuilder.injectArguments(this)

    val app = activity.applicationContext as App
    typeComponent = DaggerTypeComponent.builder()
        .typeModule(TypeModule(listType))
        .netComponent(app.netComponent()).build()
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater?.inflate(R.layout.fragment_details, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.navigationIcon = resources.getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null)
    toolbar.setNavigationOnClickListener { activity.onBackPressed() }
  }

  override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String? = getString(R.string.cb_error_view_text)

  override fun createViewState(): LceViewState<IListData, DetailsView>? = RetainingLceViewState()
  override fun createPresenter(): DetailsPresenter? = typeComponent.detailsPresenter()
  override fun getData(): IListData? = data

  override fun loadData(pullToRefresh: Boolean) {
    presenter.loadData(detailsId, listType, pullToRefresh)
  }

  override fun setData(data: IListData?) {
    this.data = data

    buildLayout(data?.displayData)
  }

  private fun buildLayout(layoutData: Map<String, String>?) {
    val inflater = LayoutInflater.from(activity)

    layoutData?.forEach {
      if (it.key === "Opening Crawl") {
        toolbarText.text = it.value
      } else if (it.key === "Title") {
        toolbar.title = it.value
      } else {
        var ll = inflater.inflate(R.layout.row_key_value, scrollViewContainer, false) as LinearLayout
        ll.find<TextView>(R.id.key).text = it.key
        ll.find<TextView>(R.id.value).text = it.value

        scrollViewContainer.addView(ll)
      }
    }
  }
}