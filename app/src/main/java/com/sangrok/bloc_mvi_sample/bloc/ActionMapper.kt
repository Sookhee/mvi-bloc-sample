package com.sangrok.bloc_mvi_sample.bloc

import kotlinx.coroutines.flow.Flow

interface ActionMapper<STATE, ACTION> {
    fun mapActionToState(action: ACTION, state: STATE): Flow<STATE>
}