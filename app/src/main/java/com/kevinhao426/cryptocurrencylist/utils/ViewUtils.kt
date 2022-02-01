package com.kevinhao426.cryptocurrencylist.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.kevinhao426.cryptocurrencylist.R

/**
 * Replaces a fragment without a back-stack entry.
 *
 * @param fragment the fragment you want to inflate
 */
inline fun <reified T : Fragment> FragmentManager.replaceFragment(
    fragment: T,
    name: String? = null
): Int {
    val transaction = this.beginTransaction()

    val className = name ?: T::class.simpleName
    return transaction.replace(R.id.fragmentContainer, fragment, className).commit()
}


/**
 * Adds a fragment with a back-stack entry.
 *
 * @param fragment the fragment you want to inflate
 */
inline fun <reified T : Fragment> FragmentManager.addFragment(
    fragment: T,
    name: String? = null
): Int {
    val transaction = this.beginTransaction()

    // set the visibility of all fragments to false, as they are about to be "underneath" this new fragment.
    fragments.forEach {
        transaction.setMaxLifecycle(it, Lifecycle.State.STARTED)
    }

    val className = name ?: T::class.simpleName
    return transaction.add(R.id.fragmentContainer, fragment, className)
        .addToBackStack(className)
        .commit()
}