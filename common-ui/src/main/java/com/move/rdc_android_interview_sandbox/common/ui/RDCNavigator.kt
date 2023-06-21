package com.move.rdc_android_interview_sandbox.common.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface RDCNavigator {

    fun navigationTargetStateFlow(): StateFlow<NavigationTarget>

    fun navigate(navigationTarget: NavigationTarget)
}

class RDCNavigatorImpl : RDCNavigator {

    private val _navigationTargetFlow = MutableStateFlow<NavigationTarget>(
        NavigationTarget.DemoFragmentTarget(
            isEntryPoint = true
        )
    )

    override fun navigationTargetStateFlow(): StateFlow<NavigationTarget> {
        return _navigationTargetFlow.asStateFlow()
    }
    override fun navigate(navigationTarget: NavigationTarget) {
        _navigationTargetFlow.value = navigationTarget
    }

}

sealed class NavigationTarget(
    val isEntryPoint: Boolean = false
) {
    class PropertyFragmentTarget(isEntryPoint: Boolean = false) : NavigationTarget(isEntryPoint)
    class DemoFragmentTarget(isEntryPoint: Boolean = false) : NavigationTarget(isEntryPoint)
}