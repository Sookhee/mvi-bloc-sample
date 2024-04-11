package com.sangrok.bloc_mvi_sample.bloc

import kotlinx.coroutines.flow.Flow

interface ErrorMapper<STATE, ACTION> {
    fun mapErrorToAction(state: STATE, action: ACTION, throwable: Throwable): Flow<ACTION>
    fun mapErrorToState(state: STATE, action: ACTION, throwable: Throwable): Flow<STATE>
}