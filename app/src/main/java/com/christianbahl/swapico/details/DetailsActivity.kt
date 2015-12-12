package com.christianbahl.swapico.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.christianbahl.appkit.core.activity.CBActivityToolbarFragment
import com.christianbahl.swapico.list.model.ListType

/**
 * @author Christian Bahl
 */
class DetailsActivity : CBActivityToolbarFragment() {

  companion object {
    val INTENT_EXTRA_DETAILS_TYPE = "details_type"

    fun getStartIntent(context: Context, detailsType: ListType): Intent {
      val i = Intent(context, DetailsActivity::class.java)
      i.putExtra(INTENT_EXTRA_DETAILS_TYPE, detailsType.ordinal);
      return i
    }
  }

  override fun createFragmentToDisplay(): Fragment? {
    throw UnsupportedOperationException()
  }

  override fun readExtras(bundle: Bundle) {
    super.readExtras(bundle)
  }
}