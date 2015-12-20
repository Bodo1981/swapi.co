package com.christianbahl.swapico.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.christianbahl.appkit.core.activity.CBActivityFragment
import com.christianbahl.swapico.list.model.ListType

/**
 * @author Christian Bahl
 */
class DetailsActivity : CBActivityFragment() {

  lateinit private var listType: ListType
  private var detailsId: Int = 1

  companion object {
    val INTENT_EXTRA_DETAILS_TYPE = "details_type"
    val INTENT_EXTRA_DETAILS_ID = "details_id"

    fun getStartIntent(context: Context, detailsType: ListType, detailsId: Int): Intent {
      val i = Intent(context, DetailsActivity::class.java)
      i.putExtra(INTENT_EXTRA_DETAILS_TYPE, detailsType.name)
      i.putExtra(INTENT_EXTRA_DETAILS_ID, detailsId);
      return i
    }
  }

  override fun createFragmentToDisplay(): Fragment? {
    return DetailsFragmentBuilder(detailsId, listType).build()
  }

  override fun readExtras(bundle: Bundle) {
    super.readExtras(bundle)

    listType = ListType.valueOf(bundle.getString(INTENT_EXTRA_DETAILS_TYPE))
    detailsId = bundle.getInt(INTENT_EXTRA_DETAILS_ID, 1)
  }
}