package com.sangrok.bloc_mvi_sample.bloc

import kotlinx.coroutines.flow.Flow

interface ActionTransformer<ACTION> {
    fun transformActions(action: ACTION): Flow<ACTION>
}